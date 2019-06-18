package org.apache.spark.sql.execution.datasources.csv;
public  class UnivocityParser$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final UnivocityParser$ MODULE$ = null;
  public   UnivocityParser$ ()  { throw new RuntimeException(); }
  /**
   * Parses a stream that contains CSV strings and turns it into an iterator of tokens.
   * @param inputStream (undocumented)
   * @param shouldDropHeader (undocumented)
   * @param tokenizer (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<java.lang.String[]> tokenizeStream (java.io.InputStream inputStream, boolean shouldDropHeader, com.univocity.parsers.csv.CsvParser tokenizer)  { throw new RuntimeException(); }
  /**
   * Parses a stream that contains CSV strings and turns it into an iterator of rows.
   * @param inputStream (undocumented)
   * @param shouldDropHeader (undocumented)
   * @param parser (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> parseStream (java.io.InputStream inputStream, boolean shouldDropHeader, org.apache.spark.sql.execution.datasources.csv.UnivocityParser parser, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  private <T extends java.lang.Object> java.lang.Object convertStream (java.io.InputStream inputStream, boolean shouldDropHeader, com.univocity.parsers.csv.CsvParser tokenizer, scala.Function1<java.lang.String[], T> convert)  { throw new RuntimeException(); }
  /**
   * Parses an iterator that contains CSV strings and turns it into an iterator of rows.
   * @param lines (undocumented)
   * @param shouldDropHeader (undocumented)
   * @param parser (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> parseIterator (scala.collection.Iterator<java.lang.String> lines, boolean shouldDropHeader, org.apache.spark.sql.execution.datasources.csv.UnivocityParser parser, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
}
