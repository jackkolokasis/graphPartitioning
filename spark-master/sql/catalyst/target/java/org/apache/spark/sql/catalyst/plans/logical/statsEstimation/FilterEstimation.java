package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
public  class FilterEstimation implements org.apache.spark.internal.Logging, scala.Product, scala.Serializable {
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Filter plan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.internal.SQLConf catalystConf ()  { throw new RuntimeException(); }
  // not preceding
  public   FilterEstimation (org.apache.spark.sql.catalyst.plans.logical.Filter plan, org.apache.spark.sql.internal.SQLConf catalystConf)  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.plans.logical.Statistics childStats ()  { throw new RuntimeException(); }
  /**
   * We will update the corresponding ColumnStats for a column after we apply a predicate condition.
   * For example, column c has [min, max] value as [0, 100].  In a range condition such as
   * (c > 40 AND c <= 50), we need to set the column's [min, max] value to [40, 100] after we
   * evaluate the first condition c > 40.  We need to set the column's [min, max] value to [40, 50]
   * after we evaluate the second condition c <= 50.
   * @return (undocumented)
   */
  private  org.apache.spark.sql.catalyst.plans.logical.statsEstimation.ColumnStatsMap colStatsMap ()  { throw new RuntimeException(); }
  /**
   * Returns an option of Statistics for a Filter logical plan node.
   * For a given compound expression condition, this method computes filter selectivity
   * (or the percentage of rows meeting the filter condition), which
   * is used to compute row count, size in bytes, and the updated statistics after a given
   * predicated is applied.
   * <p>
   * @return Option[Statistics] When there is no statistics collected, it returns None.
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.Statistics> estimate ()  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting a condition in Filter node.
   * If it's a single condition, we calculate the percentage directly.
   * If it's a compound condition, it is decomposed into multiple single conditions linked with
   * AND, OR, NOT.
   * For logical AND conditions, we need to update stats after a condition estimation
   * so that the stats will be more accurate for subsequent estimation.  This is needed for
   * range condition such as (c > 40 AND c <= 50)
   * For logical OR and NOT conditions, we do not update stats after a condition estimation.
   * <p>
   * @param condition the compound logical expression
   * @param update a boolean flag to specify if we need to update ColumnStat of a column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition.
   *         It returns None if the condition is not supported.
   */
  public  scala.Option<java.lang.Object> calculateFilterSelectivity (org.apache.spark.sql.catalyst.expressions.Expression condition, boolean update)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting a single condition in Filter node.
   * Currently we only support binary predicates where one side is a column,
   * and the other is a literal.
   * <p>
   * @param condition a single logical expression
   * @param update a boolean flag to specify if we need to update ColumnStat of a column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition.
   *         It returns None if the condition is not supported.
   */
  public  scala.Option<java.lang.Object> calculateSingleCondition (org.apache.spark.sql.catalyst.expressions.Expression condition, boolean update)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting "IS NULL" or "IS NOT NULL" condition.
   * <p>
   * @param attr an Attribute (or a column)
   * @param isNull set to true for "IS NULL" condition.  set to false for "IS NOT NULL" condition
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   *         It returns None if no statistics collected for a given column.
   */
  public  scala.Option<java.lang.Object> evaluateNullCheck (org.apache.spark.sql.catalyst.expressions.Attribute attr, boolean isNull, boolean update)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting a binary comparison expression.
   * <p>
   * @param op a binary comparison operator uch as =, <, <=, >, >=
   * @param attr an Attribute (or a column)
   * @param literal a literal value (or constant)
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   *         It returns None if no statistics exists for a given column or wrong value.
   */
  public  scala.Option<java.lang.Object> evaluateBinary (org.apache.spark.sql.catalyst.expressions.BinaryComparison op, org.apache.spark.sql.catalyst.expressions.Attribute attr, org.apache.spark.sql.catalyst.expressions.Literal literal, boolean update)  { throw new RuntimeException(); }
  /**
   * For a SQL data type, its internal data type may be different from its external type.
   * For DateType, its internal type is Int, and its external data type is Java Date type.
   * The min/max values in ColumnStat are saved in their corresponding external type.
   * <p>
   * @param attrDataType the column data type
   * @param litValue the literal value
   * @return a BigDecimal value
   */
  public  scala.Option<java.lang.Object> convertBoundValue (org.apache.spark.sql.types.DataType attrDataType, Object litValue)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting an equality (=) expression.
   * This method evaluates the equality predicate for all data types.
   * <p>
   * For EqualNullSafe (<=&gt;), if the literal is not null, result will be the same as EqualTo;
   * if the literal is null, the condition will be changed to IsNull after optimization.
   * So we don't need specific logic for EqualNullSafe here.
   * <p>
   * @param attr an Attribute (or a column)
   * @param literal a literal value (or constant)
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   */
  public  scala.Option<java.lang.Object> evaluateEquality (org.apache.spark.sql.catalyst.expressions.Attribute attr, org.apache.spark.sql.catalyst.expressions.Literal literal, boolean update)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting a Literal expression.
   * This method evaluates all the possible literal cases in Filter.
   * <p>
   * FalseLiteral and TrueLiteral should be eliminated by optimizer, but null literal might be added
   * by optimizer rule NullPropagation. For safety, we handle all the cases here.
   * <p>
   * @param literal a literal value (or constant)
   * @return an optional double value to show the percentage of rows meeting a given condition
   */
  public  scala.Option<java.lang.Object> evaluateLiteral (org.apache.spark.sql.catalyst.expressions.Literal literal)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting "IN" operator expression.
   * This method evaluates the equality predicate for all data types.
   * <p>
   * @param attr an Attribute (or a column)
   * @param hSet a set of literal values
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   *         It returns None if no statistics exists for a given column.
   */
  public  scala.Option<java.lang.Object> evaluateInSet (org.apache.spark.sql.catalyst.expressions.Attribute attr, scala.collection.immutable.Set<java.lang.Object> hSet, boolean update)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting a binary comparison expression.
   * This method evaluate expression for Numeric/Date/Timestamp/Boolean columns.
   * <p>
   * @param op a binary comparison operator uch as =, <, <=, >, >=
   * @param attr an Attribute (or a column)
   * @param literal a literal value (or constant)
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   */
  public  scala.Option<java.lang.Object> evaluateBinaryForNumeric (org.apache.spark.sql.catalyst.expressions.BinaryComparison op, org.apache.spark.sql.catalyst.expressions.Attribute attr, org.apache.spark.sql.catalyst.expressions.Literal literal, boolean update)  { throw new RuntimeException(); }
}
