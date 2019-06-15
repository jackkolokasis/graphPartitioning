/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.catalyst.plans.logical.statsEstimation

import scala.collection.immutable.HashSet
import scala.collection.mutable
import scala.math.BigDecimal.RoundingMode

import org.apache.spark.internal.Logging
import org.apache.spark.sql.catalyst.CatalystConf
import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.catalyst.expressions.Literal.{FalseLiteral, TrueLiteral}
import org.apache.spark.sql.catalyst.plans.logical.{ColumnStat, Filter, LeafNode, Statistics}
import org.apache.spark.sql.catalyst.util.DateTimeUtils
import org.apache.spark.sql.types._

case class FilterEstimation(plan: Filter, catalystConf: CatalystConf) extends Logging {

  private val childStats = plan.child.stats(catalystConf)

  /**
   * We will update the corresponding ColumnStats for a column after we apply a predicate condition.
   * For example, column c has [min, max] value as [0, 100].  In a range condition such as
   * (c > 40 AND c <= 50), we need to set the column's [min, max] value to [40, 100] after we
   * evaluate the first condition c > 40.  We need to set the column's [min, max] value to [40, 50]
   * after we evaluate the second condition c <= 50.
   */
  private val colStatsMap = new ColumnStatsMap

  /**
   * Returns an option of Statistics for a Filter logical plan node.
   * For a given compound expression condition, this method computes filter selectivity
   * (or the percentage of rows meeting the filter condition), which
   * is used to compute row count, size in bytes, and the updated statistics after a given
   * predicated is applied.
   *
   * @return Option[Statistics] When there is no statistics collected, it returns None.
   */
  def estimate: Option[Statistics] = {
    if (childStats.rowCount.isEmpty) return None

    // Save a mutable copy of colStats so that we can later change it recursively.
    colStatsMap.setInitValues(childStats.attributeStats)

    // Estimate selectivity of this filter predicate, and update column stats if needed.
    // For not-supported condition, set filter selectivity to a conservative estimate 100%
    val filterSelectivity: Double = calculateFilterSelectivity(plan.condition).getOrElse(1.0)

    val newColStats = if (filterSelectivity == 0) {
      // The output is empty, we don't need to keep column stats.
      AttributeMap[ColumnStat](Nil)
    } else {
      colStatsMap.toColumnStats
    }

    val filteredRowCount: BigInt =
      EstimationUtils.ceil(BigDecimal(childStats.rowCount.get) * filterSelectivity)
    val filteredSizeInBytes: BigInt =
      EstimationUtils.getOutputSize(plan.output, filteredRowCount, newColStats)

    Some(childStats.copy(sizeInBytes = filteredSizeInBytes, rowCount = Some(filteredRowCount),
      attributeStats = newColStats))
  }

  /**
   * Returns a percentage of rows meeting a condition in Filter node.
   * If it's a single condition, we calculate the percentage directly.
   * If it's a compound condition, it is decomposed into multiple single conditions linked with
   * AND, OR, NOT.
   * For logical AND conditions, we need to update stats after a condition estimation
   * so that the stats will be more accurate for subsequent estimation.  This is needed for
   * range condition such as (c > 40 AND c <= 50)
   * For logical OR and NOT conditions, we do not update stats after a condition estimation.
   *
   * @param condition the compound logical expression
   * @param update a boolean flag to specify if we need to update ColumnStat of a column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition.
   *         It returns None if the condition is not supported.
   */
  def calculateFilterSelectivity(condition: Expression, update: Boolean = true): Option[Double] = {
    condition match {
      case And(cond1, cond2) =>
        val percent1 = calculateFilterSelectivity(cond1, update).getOrElse(1.0)
        val percent2 = calculateFilterSelectivity(cond2, update).getOrElse(1.0)
        Some(percent1 * percent2)

      case Or(cond1, cond2) =>
        val percent1 = calculateFilterSelectivity(cond1, update = false).getOrElse(1.0)
        val percent2 = calculateFilterSelectivity(cond2, update = false).getOrElse(1.0)
        Some(percent1 + percent2 - (percent1 * percent2))

      // Not-operator pushdown
      case Not(And(cond1, cond2)) =>
        calculateFilterSelectivity(Or(Not(cond1), Not(cond2)), update = false)

      // Not-operator pushdown
      case Not(Or(cond1, cond2)) =>
        calculateFilterSelectivity(And(Not(cond1), Not(cond2)), update = false)

      // Collapse two consecutive Not operators which could be generated after Not-operator pushdown
      case Not(Not(cond)) =>
        calculateFilterSelectivity(cond, update = false)

      // The foldable Not has been processed in the ConstantFolding rule
      // This is a top-down traversal. The Not could be pushed down by the above two cases.
      case Not(l @ Literal(null, _)) =>
        calculateSingleCondition(l, update = false)

      case Not(cond) =>
        calculateFilterSelectivity(cond, update = false) match {
          case Some(percent) => Some(1.0 - percent)
          case None => None
        }

      case _ =>
        calculateSingleCondition(condition, update)
    }
  }

  /**
   * Returns a percentage of rows meeting a single condition in Filter node.
   * Currently we only support binary predicates where one side is a column,
   * and the other is a literal.
   *
   * @param condition a single logical expression
   * @param update a boolean flag to specify if we need to update ColumnStat of a column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition.
   *         It returns None if the condition is not supported.
   */
  def calculateSingleCondition(condition: Expression, update: Boolean): Option[Double] = {
    condition match {
      case l: Literal =>
        evaluateLiteral(l)

      // For evaluateBinary method, we assume the literal on the right side of an operator.
      // So we will change the order if not.

      // EqualTo/EqualNullSafe does not care about the order
      case Equality(ar: Attribute, l: Literal) =>
        evaluateEquality(ar, l, update)
      case Equality(l: Literal, ar: Attribute) =>
        evaluateEquality(ar, l, update)

      case op @ LessThan(ar: Attribute, l: Literal) =>
        evaluateBinary(op, ar, l, update)
      case op @ LessThan(l: Literal, ar: Attribute) =>
        evaluateBinary(GreaterThan(ar, l), ar, l, update)

      case op @ LessThanOrEqual(ar: Attribute, l: Literal) =>
        evaluateBinary(op, ar, l, update)
      case op @ LessThanOrEqual(l: Literal, ar: Attribute) =>
        evaluateBinary(GreaterThanOrEqual(ar, l), ar, l, update)

      case op @ GreaterThan(ar: Attribute, l: Literal) =>
        evaluateBinary(op, ar, l, update)
      case op @ GreaterThan(l: Literal, ar: Attribute) =>
        evaluateBinary(LessThan(ar, l), ar, l, update)

      case op @ GreaterThanOrEqual(ar: Attribute, l: Literal) =>
        evaluateBinary(op, ar, l, update)
      case op @ GreaterThanOrEqual(l: Literal, ar: Attribute) =>
        evaluateBinary(LessThanOrEqual(ar, l), ar, l, update)

      case In(ar: Attribute, expList)
        if expList.forall(e => e.isInstanceOf[Literal]) =>
        // Expression [In (value, seq[Literal])] will be replaced with optimized version
        // [InSet (value, HashSet[Literal])] in Optimizer, but only for list.size > 10.
        // Here we convert In into InSet anyway, because they share the same processing logic.
        val hSet = expList.map(e => e.eval())
        evaluateInSet(ar, HashSet() ++ hSet, update)

      case InSet(ar: Attribute, set) =>
        evaluateInSet(ar, set, update)

      // In current stage, we don't have advanced statistics such as sketches or histograms.
      // As a result, some operator can't estimate `nullCount` accurately. E.g. left outer join
      // estimation does not accurately update `nullCount` currently.
      // So for IsNull and IsNotNull predicates, we only estimate them when the child is a leaf
      // node, whose `nullCount` is accurate.
      // This is a limitation due to lack of advanced stats. We should remove it in the future.
      case IsNull(ar: Attribute) if plan.child.isInstanceOf[LeafNode] =>
        evaluateNullCheck(ar, isNull = true, update)

      case IsNotNull(ar: Attribute) if plan.child.isInstanceOf[LeafNode] =>
        evaluateNullCheck(ar, isNull = false, update)

      case _ =>
        // TODO: it's difficult to support string operators without advanced statistics.
        // Hence, these string operators Like(_, _) | Contains(_, _) | StartsWith(_, _)
        // | EndsWith(_, _) are not supported yet
        logDebug("[CBO] Unsupported filter condition: " + condition)
        None
    }
  }

  /**
   * Returns a percentage of rows meeting "IS NULL" or "IS NOT NULL" condition.
   *
   * @param attr an Attribute (or a column)
   * @param isNull set to true for "IS NULL" condition.  set to false for "IS NOT NULL" condition
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   *         It returns None if no statistics collected for a given column.
   */
  def evaluateNullCheck(
      attr: Attribute,
      isNull: Boolean,
      update: Boolean): Option[Double] = {
    if (!colStatsMap.contains(attr)) {
      logDebug("[CBO] No statistics for " + attr)
      return None
    }
    val colStat = colStatsMap(attr)
    val rowCountValue = childStats.rowCount.get
    val nullPercent: BigDecimal = if (rowCountValue == 0) {
      0
    } else {
      BigDecimal(colStat.nullCount) / BigDecimal(rowCountValue)
    }

    if (update) {
      val newStats = if (isNull) {
        colStat.copy(distinctCount = 0, min = None, max = None)
      } else {
        colStat.copy(nullCount = 0)
      }
      colStatsMap(attr) = newStats
    }

    val percent = if (isNull) {
      nullPercent
    } else {
      1.0 - nullPercent
    }

    Some(percent.toDouble)
  }

  /**
   * Returns a percentage of rows meeting a binary comparison expression.
   *
   * @param op a binary comparison operator uch as =, <, <=, >, >=
   * @param attr an Attribute (or a column)
   * @param literal a literal value (or constant)
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
    *         It returns None if no statistics exists for a given column or wrong value.
   */
  def evaluateBinary(
      op: BinaryComparison,
      attr: Attribute,
      literal: Literal,
      update: Boolean): Option[Double] = {
    if (!colStatsMap.contains(attr)) {
      logDebug("[CBO] No statistics for " + attr)
      return None
    }

    attr.dataType match {
      case _: NumericType | DateType | TimestampType | BooleanType =>
        evaluateBinaryForNumeric(op, attr, literal, update)
      case StringType | BinaryType =>
        // TODO: It is difficult to support other binary comparisons for String/Binary
        // type without min/max and advanced statistics like histogram.
        logDebug("[CBO] No range comparison statistics for String/Binary type " + attr)
        None
    }
  }

  /**
   * For a SQL data type, its internal data type may be different from its external type.
   * For DateType, its internal type is Int, and its external data type is Java Date type.
   * The min/max values in ColumnStat are saved in their corresponding external type.
   *
   * @param attrDataType the column data type
   * @param litValue the literal value
   * @return a BigDecimal value
   */
  def convertBoundValue(attrDataType: DataType, litValue: Any): Option[Any] = {
    attrDataType match {
      case DateType =>
        Some(DateTimeUtils.toJavaDate(litValue.toString.toInt))
      case TimestampType =>
        Some(DateTimeUtils.toJavaTimestamp(litValue.toString.toLong))
      case _: DecimalType =>
        Some(litValue.asInstanceOf[Decimal].toJavaBigDecimal)
      case StringType | BinaryType =>
        None
      case _ =>
        Some(litValue)
    }
  }

  /**
   * Returns a percentage of rows meeting an equality (=) expression.
   * This method evaluates the equality predicate for all data types.
   *
   * For EqualNullSafe (<=>), if the literal is not null, result will be the same as EqualTo;
   * if the literal is null, the condition will be changed to IsNull after optimization.
   * So we don't need specific logic for EqualNullSafe here.
   *
   * @param attr an Attribute (or a column)
   * @param literal a literal value (or constant)
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   */
  def evaluateEquality(
      attr: Attribute,
      literal: Literal,
      update: Boolean): Option[Double] = {
    if (!colStatsMap.contains(attr)) {
      logDebug("[CBO] No statistics for " + attr)
      return None
    }
    val colStat = colStatsMap(attr)
    val ndv = colStat.distinctCount

    // decide if the value is in [min, max] of the column.
    // We currently don't store min/max for binary/string type.
    // Hence, we assume it is in boundary for binary/string type.
    val statsRange = Range(colStat.min, colStat.max, attr.dataType)
    if (statsRange.contains(literal)) {
      if (update) {
        // We update ColumnStat structure after apply this equality predicate.
        // Set distinctCount to 1.  Set nullCount to 0.
        // Need to save new min/max using the external type value of the literal
        val newValue = convertBoundValue(attr.dataType, literal.value)
        val newStats = colStat.copy(distinctCount = 1, min = newValue,
          max = newValue, nullCount = 0)
        colStatsMap(attr) = newStats
      }

      Some((1.0 / BigDecimal(ndv)).toDouble)
    } else {
      Some(0.0)
    }

  }

  /**
   * Returns a percentage of rows meeting a Literal expression.
   * This method evaluates all the possible literal cases in Filter.
   *
   * FalseLiteral and TrueLiteral should be eliminated by optimizer, but null literal might be added
   * by optimizer rule NullPropagation. For safety, we handle all the cases here.
   *
   * @param literal a literal value (or constant)
   * @return an optional double value to show the percentage of rows meeting a given condition
   */
  def evaluateLiteral(literal: Literal): Option[Double] = {
    literal match {
      case Literal(null, _) => Some(0.0)
      case FalseLiteral => Some(0.0)
      case TrueLiteral => Some(1.0)
      // Ideally, we should not hit the following branch
      case _ => None
    }
  }

  /**
   * Returns a percentage of rows meeting "IN" operator expression.
   * This method evaluates the equality predicate for all data types.
   *
   * @param attr an Attribute (or a column)
   * @param hSet a set of literal values
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   *         It returns None if no statistics exists for a given column.
   */

  def evaluateInSet(
      attr: Attribute,
      hSet: Set[Any],
      update: Boolean): Option[Double] = {
    if (!colStatsMap.contains(attr)) {
      logDebug("[CBO] No statistics for " + attr)
      return None
    }

    val colStat = colStatsMap(attr)
    val ndv = colStat.distinctCount
    val dataType = attr.dataType
    var newNdv = ndv

    // use [min, max] to filter the original hSet
    dataType match {
      case _: NumericType | BooleanType | DateType | TimestampType =>
        val statsRange = Range(colStat.min, colStat.max, dataType).asInstanceOf[NumericRange]
        val validQuerySet = hSet.filter { v =>
          v != null && statsRange.contains(Literal(v, dataType))
        }

        if (validQuerySet.isEmpty) {
          return Some(0.0)
        }

        // Need to save new min/max using the external type value of the literal
        val newMax = convertBoundValue(
          attr.dataType, validQuerySet.maxBy(v => BigDecimal(v.toString)))
        val newMin = convertBoundValue(
          attr.dataType, validQuerySet.minBy(v => BigDecimal(v.toString)))

        // newNdv should not be greater than the old ndv.  For example, column has only 2 values
        // 1 and 6. The predicate column IN (1, 2, 3, 4, 5). validQuerySet.size is 5.
        newNdv = ndv.min(BigInt(validQuerySet.size))
        if (update) {
          val newStats = colStat.copy(distinctCount = newNdv, min = newMin,
                max = newMax, nullCount = 0)
          colStatsMap(attr) = newStats
        }

      // We assume the whole set since there is no min/max information for String/Binary type
      case StringType | BinaryType =>
        newNdv = ndv.min(BigInt(hSet.size))
        if (update) {
          val newStats = colStat.copy(distinctCount = newNdv, nullCount = 0)
          colStatsMap(attr) = newStats
        }
    }

    // return the filter selectivity.  Without advanced statistics such as histograms,
    // we have to assume uniform distribution.
    Some(math.min(1.0, (BigDecimal(newNdv) / BigDecimal(ndv)).toDouble))
  }

  /**
   * Returns a percentage of rows meeting a binary comparison expression.
   * This method evaluate expression for Numeric/Date/Timestamp/Boolean columns.
   *
   * @param op a binary comparison operator uch as =, <, <=, >, >=
   * @param attr an Attribute (or a column)
   * @param literal a literal value (or constant)
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   */
  def evaluateBinaryForNumeric(
      op: BinaryComparison,
      attr: Attribute,
      literal: Literal,
      update: Boolean): Option[Double] = {

    val colStat = colStatsMap(attr)
    val statsRange = Range(colStat.min, colStat.max, attr.dataType).asInstanceOf[NumericRange]
    val max = BigDecimal(statsRange.max)
    val min = BigDecimal(statsRange.min)
    val ndv = BigDecimal(colStat.distinctCount)

    // determine the overlapping degree between predicate range and column's range
    val numericLiteral = if (literal.dataType == BooleanType) {
      if (literal.value.asInstanceOf[Boolean]) BigDecimal(1) else BigDecimal(0)
    } else {
      BigDecimal(literal.value.toString)
    }
    val (noOverlap: Boolean, completeOverlap: Boolean) = op match {
      case _: LessThan =>
        (numericLiteral <= min, numericLiteral > max)
      case _: LessThanOrEqual =>
        (numericLiteral < min, numericLiteral >= max)
      case _: GreaterThan =>
        (numericLiteral >= max, numericLiteral < min)
      case _: GreaterThanOrEqual =>
        (numericLiteral > max, numericLiteral <= min)
    }

    var percent = BigDecimal(1.0)
    if (noOverlap) {
      percent = 0.0
    } else if (completeOverlap) {
      percent = 1.0
    } else {
      // This is the partial overlap case:
      // Without advanced statistics like histogram, we assume uniform data distribution.
      // We just prorate the adjusted range over the initial range to compute filter selectivity.
      assert(max > min)
      percent = op match {
        case _: LessThan =>
          if (numericLiteral == max) {
            // If the literal value is right on the boundary, we can minus the part of the
            // boundary value (1/ndv).
            1.0 - 1.0 / ndv
          } else {
            (numericLiteral - min) / (max - min)
          }
        case _: LessThanOrEqual =>
          if (numericLiteral == min) {
            // The boundary value is the only satisfying value.
            1.0 / ndv
          } else {
            (numericLiteral - min) / (max - min)
          }
        case _: GreaterThan =>
          if (numericLiteral == min) {
            1.0 - 1.0 / ndv
          } else {
            (max - numericLiteral) / (max - min)
          }
        case _: GreaterThanOrEqual =>
          if (numericLiteral == max) {
            1.0 / ndv
          } else {
            (max - numericLiteral) / (max - min)
          }
      }

      if (update) {
        // Need to save new min/max using the external type value of the literal
        val newValue = convertBoundValue(attr.dataType, literal.value)
        var newMax = colStat.max
        var newMin = colStat.min
        var newNdv = (ndv * percent).setScale(0, RoundingMode.HALF_UP).toBigInt()
        if (newNdv < 1) newNdv = 1

        op match {
          case _: GreaterThan | _: GreaterThanOrEqual =>
            // If new ndv is 1, then new max must be equal to new min.
            newMin = if (newNdv == 1) newMax else newValue
          case _: LessThan | _: LessThanOrEqual =>
            newMax = if (newNdv == 1) newMin else newValue
        }

        val newStats =
          colStat.copy(distinctCount = newNdv, min = newMin, max = newMax, nullCount = 0)

        colStatsMap(attr) = newStats
      }
    }

    Some(percent.toDouble)
  }

}

class ColumnStatsMap {
  private val baseMap: mutable.Map[ExprId, (Attribute, ColumnStat)] = mutable.HashMap.empty

  def setInitValues(colStats: AttributeMap[ColumnStat]): Unit = {
    baseMap.clear()
    baseMap ++= colStats.baseMap
  }

  def contains(a: Attribute): Boolean = baseMap.contains(a.exprId)

  def apply(a: Attribute): ColumnStat = baseMap(a.exprId)._2

  def update(a: Attribute, stats: ColumnStat): Unit = baseMap.update(a.exprId, a -> stats)

  def toColumnStats: AttributeMap[ColumnStat] = AttributeMap(baseMap.values.toSeq)
}
