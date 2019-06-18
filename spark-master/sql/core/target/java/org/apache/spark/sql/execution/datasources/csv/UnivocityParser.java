package org.apache.spark.sql.execution.datasources.csv;
public  class UnivocityParser implements org.apache.spark.internal.Logging {
  /**
   * Parses a stream that contains CSV strings and turns it into an iterator of tokens.
   * @param inputStream (undocumented)
   * @param shouldDropHeader (undocumented)
   * @param tokenizer (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Iterator<java.lang.String[]> tokenizeStream (java.io.InputStream inputStream, boolean shouldDropHeader, com.univocity.parsers.csv.CsvParser tokenizer)  { throw new RuntimeException(); }
  /**
   * Parses a stream that contains CSV strings and turns it into an iterator of rows.
   * @param inputStream (undocumented)
   * @param shouldDropHeader (undocumented)
   * @param parser (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> parseStream (java.io.InputStream inputStream, boolean shouldDropHeader, org.apache.spark.sql.execution.datasources.csv.UnivocityParser parser, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static private <T extends java.lang.Object> java.lang.Object convertStream (java.io.InputStream inputStream, boolean shouldDropHeader, com.univocity.parsers.csv.CsvParser tokenizer, scala.Function1<java.lang.String[], T> convert)  { throw new RuntimeException(); }
  /**
   * Parses an iterator that contains CSV strings and turns it into an iterator of rows.
   * @param lines (undocumented)
   * @param shouldDropHeader (undocumented)
   * @param parser (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> parseIterator (scala.collection.Iterator<java.lang.String> lines, boolean shouldDropHeader, org.apache.spark.sql.execution.datasources.csv.UnivocityParser parser, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.csv.CSVOptions options ()  { throw new RuntimeException(); }
  // not preceding
  public   UnivocityParser (org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.types.StructType requiredSchema, org.apache.spark.sql.execution.datasources.csv.CSVOptions options)  { throw new RuntimeException(); }
  public   UnivocityParser (org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.execution.datasources.csv.CSVOptions options)  { throw new RuntimeException(); }
  private  com.univocity.parsers.csv.CsvParser tokenizer ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.expressions.GenericInternalRow row ()  { throw new RuntimeException(); }
  private  org.apache.spark.unsafe.types.UTF8String getCurrentInput ()  { throw new RuntimeException(); }
  private  scala.Function1<java.lang.String, java.lang.Object>[] valueConverters ()  { throw new RuntimeException(); }
  private  int[] tokenIndexArr ()  { throw new RuntimeException(); }
  /**
   * Create a converter which converts the string value to a value according to a desired type.
   * Currently, we do not support complex types (<code>ArrayType</code>, <code>MapType</code>, <code>StructType</code>).
   * <p>
   * For other nullable types, returns null if it is null or equals to the value specified
   * in <code>nullValue</code> option.
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @param nullable (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  scala.Function1<java.lang.String, java.lang.Object> makeConverter (java.lang.String name, org.apache.spark.sql.types.DataType dataType, boolean nullable, org.apache.spark.sql.execution.datasources.csv.CSVOptions options)  { throw new RuntimeException(); }
  private  Object nullSafeDatum (java.lang.String datum, java.lang.String name, boolean nullable, org.apache.spark.sql.execution.datasources.csv.CSVOptions options, scala.Function1<java.lang.String, java.lang.Object> converter)  { throw new RuntimeException(); }
  /**
   * Parses a single CSV string and turns it into either one resulting row or no row (if the
   * the record is malformed).
   * @param input (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow parse (java.lang.String input)  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.InternalRow convert (java.lang.String[] tokens)  { throw new RuntimeException(); }
}
