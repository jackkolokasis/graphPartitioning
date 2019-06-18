package org.apache.spark.scheduler;
public final class BlacklistedExecutor implements scala.Product, scala.Serializable {
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  java.lang.String node ()  { throw new RuntimeException(); }
  public  long expiryTime ()  { throw new RuntimeException(); }
  // not preceding
  public   BlacklistedExecutor (java.lang.String node, long expiryTime)  { throw new RuntimeException(); }
}
