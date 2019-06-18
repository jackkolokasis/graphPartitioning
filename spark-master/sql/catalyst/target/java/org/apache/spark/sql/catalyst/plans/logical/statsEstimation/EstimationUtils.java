package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
public  class EstimationUtils {
  /** Check if each plan has rowCount in its statistics. */
  static public  boolean rowCountsExist (org.apache.spark.sql.internal.SQLConf conf, scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> plans)  { throw new RuntimeException(); }
  /** Check if each attribute has column stat in the corresponding statistics. */
  static public  boolean columnStatsExist (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.plans.logical.Statistics, org.apache.spark.sql.catalyst.expressions.Attribute>> statsAndAttr)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.logical.ColumnStat nullColumnStat (org.apache.spark.sql.types.DataType dataType, scala.math.BigInt rowCount)  { throw new RuntimeException(); }
  static public  scala.math.BigInt ceil (scala.math.BigDecimal bigDecimal)  { throw new RuntimeException(); }
  /** Get column stats for output attributes. */
  static public  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> getOutputMap (org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> inputMap, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output)  { throw new RuntimeException(); }
  static public  scala.math.BigInt getOutputSize (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes, scala.math.BigInt outputRowCount, org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> attrStats)  { throw new RuntimeException(); }
}
