package org.apache.spark.sql.execution;
public  class RDDConversions$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RDDConversions$ MODULE$ = null;
  public   RDDConversions$ ()  { throw new RuntimeException(); }
  public <A extends scala.Product> org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> productToRowRdd (org.apache.spark.rdd.RDD<A> data, scala.collection.Seq<org.apache.spark.sql.types.DataType> outputTypes)  { throw new RuntimeException(); }
  /**
   * Convert the objects inside Row into the types Catalyst expected.
   * @param data (undocumented)
   * @param outputTypes (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> rowToRowRdd (org.apache.spark.rdd.RDD<org.apache.spark.sql.Row> data, scala.collection.Seq<org.apache.spark.sql.types.DataType> outputTypes)  { throw new RuntimeException(); }
}
