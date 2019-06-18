package org.apache.spark.examples.sql;
public  class UserDefinedUntypedAggregation {
  static public  class MyAverage$ extends org.apache.spark.sql.expressions.UserDefinedAggregateFunction {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final MyAverage$ MODULE$ = null;
    public   MyAverage$ ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.types.StructType inputSchema ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.types.StructType bufferSchema ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
    public  boolean deterministic ()  { throw new RuntimeException(); }
    public  void initialize (org.apache.spark.sql.expressions.MutableAggregationBuffer buffer)  { throw new RuntimeException(); }
    public  void update (org.apache.spark.sql.expressions.MutableAggregationBuffer buffer, org.apache.spark.sql.Row input)  { throw new RuntimeException(); }
    public  void merge (org.apache.spark.sql.expressions.MutableAggregationBuffer buffer1, org.apache.spark.sql.Row buffer2)  { throw new RuntimeException(); }
    public  double evaluate (org.apache.spark.sql.Row buffer)  { throw new RuntimeException(); }
  }
  static public  void main (java.lang.String[] args)  { throw new RuntimeException(); }
}
