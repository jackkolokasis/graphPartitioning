package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
/** For simplicity we use decimal to unify operations of numeric ranges. */
public  class NumericRange implements org.apache.spark.sql.catalyst.plans.logical.statsEstimation.Range, scala.Product, scala.Serializable {
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  java.math.BigDecimal min ()  { throw new RuntimeException(); }
  public  java.math.BigDecimal max ()  { throw new RuntimeException(); }
  // not preceding
  public   NumericRange (java.math.BigDecimal min, java.math.BigDecimal max)  { throw new RuntimeException(); }
  public  boolean contains (org.apache.spark.sql.catalyst.expressions.Literal l)  { throw new RuntimeException(); }
}
