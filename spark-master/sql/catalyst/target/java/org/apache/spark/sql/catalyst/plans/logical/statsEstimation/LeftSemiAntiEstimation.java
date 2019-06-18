package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
public  class LeftSemiAntiEstimation implements scala.Product, scala.Serializable {
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Join join ()  { throw new RuntimeException(); }
  // not preceding
  public   LeftSemiAntiEstimation (org.apache.spark.sql.internal.SQLConf conf, org.apache.spark.sql.catalyst.plans.logical.Join join)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.Statistics> doEstimate ()  { throw new RuntimeException(); }
}
