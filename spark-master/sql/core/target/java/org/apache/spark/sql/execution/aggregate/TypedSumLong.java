package org.apache.spark.sql.execution.aggregate;
public  class TypedSumLong<IN extends java.lang.Object> extends org.apache.spark.sql.expressions.Aggregator<IN, java.lang.Object, java.lang.Object> {
  public  scala.Function1<IN, java.lang.Object> f ()  { throw new RuntimeException(); }
  // not preceding
  public   TypedSumLong (scala.Function1<IN, java.lang.Object> f)  { throw new RuntimeException(); }
  public  long zero ()  { throw new RuntimeException(); }
  public  long reduce (long b, IN a)  { throw new RuntimeException(); }
  public  long merge (long b1, long b2)  { throw new RuntimeException(); }
  public  long finish (long reduction)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Encoder<java.lang.Object> bufferEncoder ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Encoder<java.lang.Object> outputEncoder ()  { throw new RuntimeException(); }
  public   TypedSumLong (org.apache.spark.api.java.function.MapFunction<IN, java.lang.Long> f)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.TypedColumn<IN, java.lang.Long> toColumnJava ()  { throw new RuntimeException(); }
}
