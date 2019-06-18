package org.apache.spark.sql.catalyst.optimizer;
/**
 * This class defines the cost model for a plan.
 * param:  card Cardinality (number of rows).
 * param:  size Size in bytes.
 */
public  class Cost implements scala.Product, scala.Serializable {
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  scala.math.BigInt card ()  { throw new RuntimeException(); }
  public  scala.math.BigInt size ()  { throw new RuntimeException(); }
  // not preceding
  public   Cost (scala.math.BigInt card, scala.math.BigInt size)  { throw new RuntimeException(); }
}
