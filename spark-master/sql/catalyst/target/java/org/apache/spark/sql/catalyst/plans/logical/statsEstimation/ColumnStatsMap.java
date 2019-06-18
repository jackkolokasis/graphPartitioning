package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
public  class ColumnStatsMap {
  public   ColumnStatsMap ()  { throw new RuntimeException(); }
  private  scala.collection.mutable.Map<org.apache.spark.sql.catalyst.expressions.ExprId, scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Attribute, org.apache.spark.sql.catalyst.plans.logical.ColumnStat>> baseMap ()  { throw new RuntimeException(); }
  public  void setInitValues (org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> colStats)  { throw new RuntimeException(); }
  public  boolean contains (org.apache.spark.sql.catalyst.expressions.Attribute a)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.ColumnStat apply (org.apache.spark.sql.catalyst.expressions.Attribute a)  { throw new RuntimeException(); }
  public  void update (org.apache.spark.sql.catalyst.expressions.Attribute a, org.apache.spark.sql.catalyst.plans.logical.ColumnStat stats)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> toColumnStats ()  { throw new RuntimeException(); }
}
