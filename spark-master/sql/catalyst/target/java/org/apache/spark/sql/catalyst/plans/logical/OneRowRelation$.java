package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A relation with one row. This is used in "SELECT ..." without a from clause.
 */
public  class OneRowRelation$ extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final OneRowRelation$ MODULE$ = null;
  public   OneRowRelation$ ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> maxRows ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats (org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
}
