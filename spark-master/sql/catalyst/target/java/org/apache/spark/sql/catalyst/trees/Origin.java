package org.apache.spark.sql.catalyst.trees;
public  class Origin implements scala.Product, scala.Serializable {
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> line ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> startPosition ()  { throw new RuntimeException(); }
  // not preceding
  public   Origin (scala.Option<java.lang.Object> line, scala.Option<java.lang.Object> startPosition)  { throw new RuntimeException(); }
}
