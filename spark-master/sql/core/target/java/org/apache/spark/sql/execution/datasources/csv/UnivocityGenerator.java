package org.apache.spark.sql.execution.datasources.csv;
  class UnivocityGenerator {
  public   UnivocityGenerator (org.apache.spark.sql.types.StructType schema, java.io.Writer writer, org.apache.spark.sql.execution.datasources.csv.CSVOptions options)  { throw new RuntimeException(); }
  private  com.univocity.parsers.csv.CsvWriterSettings writerSettings ()  { throw new RuntimeException(); }
  private  com.univocity.parsers.csv.CsvWriter gen ()  { throw new RuntimeException(); }
  private  boolean printHeader ()  { throw new RuntimeException(); }
  private  scala.Function2<org.apache.spark.sql.catalyst.InternalRow, java.lang.Object, java.lang.String>[] valueConverters ()  { throw new RuntimeException(); }
  private  scala.Function2<org.apache.spark.sql.catalyst.InternalRow, java.lang.Object, java.lang.String> makeConverter (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  private  scala.collection.Seq<java.lang.String> convertRow (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
  /**
   * Writes a single InternalRow to CSV using Univocity.
   * @param row (undocumented)
   */
  public  void write (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  void flush ()  { throw new RuntimeException(); }
}
