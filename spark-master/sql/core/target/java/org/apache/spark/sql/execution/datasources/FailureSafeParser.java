package org.apache.spark.sql.execution.datasources;
public  class FailureSafeParser<IN extends java.lang.Object> {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   FailureSafeParser (scala.Function1<IN, scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow>> rawParser, org.apache.spark.sql.catalyst.util.ParseMode mode, org.apache.spark.sql.types.StructType schema, java.lang.String columnNameOfCorruptRecord)  { throw new RuntimeException(); }
  private  scala.Option<java.lang.Object> corruptFieldIndex ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.types.StructType actualSchema ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.expressions.GenericInternalRow resultRow ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.expressions.GenericInternalRow nullResult ()  { throw new RuntimeException(); }
  private  scala.Function2<scala.Option<org.apache.spark.sql.catalyst.InternalRow>, scala.Function0<org.apache.spark.unsafe.types.UTF8String>, org.apache.spark.sql.catalyst.InternalRow> toResultRow ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> parse (IN input)  { throw new RuntimeException(); }
}
