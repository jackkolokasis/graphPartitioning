package org.apache.spark.sql.execution.datasources.csv;
public  class CSVOptions implements org.apache.spark.internal.Logging, scala.Serializable {
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
  private  org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters ()  { throw new RuntimeException(); }
  // not preceding
  public   CSVOptions (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters, java.lang.String defaultTimeZoneId, java.lang.String defaultColumnNameOfCorruptRecord)  { throw new RuntimeException(); }
  public   CSVOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, java.lang.String defaultTimeZoneId, java.lang.String defaultColumnNameOfCorruptRecord)  { throw new RuntimeException(); }
  private  char getChar (java.lang.String paramName, char default_)  { throw new RuntimeException(); }
  private  int getInt (java.lang.String paramName, int default_)  { throw new RuntimeException(); }
  private  boolean getBool (java.lang.String paramName, boolean default_)  { throw new RuntimeException(); }
  public  char delimiter ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.ParseMode parseMode ()  { throw new RuntimeException(); }
  public  java.lang.String charset ()  { throw new RuntimeException(); }
  public  char quote ()  { throw new RuntimeException(); }
  public  char escape ()  { throw new RuntimeException(); }
  public  char comment ()  { throw new RuntimeException(); }
  public  boolean headerFlag ()  { throw new RuntimeException(); }
  public  boolean inferSchemaFlag ()  { throw new RuntimeException(); }
  public  boolean ignoreLeadingWhiteSpaceInRead ()  { throw new RuntimeException(); }
  public  boolean ignoreTrailingWhiteSpaceInRead ()  { throw new RuntimeException(); }
  public  boolean ignoreLeadingWhiteSpaceFlagInWrite ()  { throw new RuntimeException(); }
  public  boolean ignoreTrailingWhiteSpaceFlagInWrite ()  { throw new RuntimeException(); }
  public  java.lang.String columnNameOfCorruptRecord ()  { throw new RuntimeException(); }
  public  java.lang.String nullValue ()  { throw new RuntimeException(); }
  public  java.lang.String nanValue ()  { throw new RuntimeException(); }
  public  java.lang.String positiveInf ()  { throw new RuntimeException(); }
  public  java.lang.String negativeInf ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> compressionCodec ()  { throw new RuntimeException(); }
  public  java.util.TimeZone timeZone ()  { throw new RuntimeException(); }
  public  org.apache.commons.lang3.time.FastDateFormat dateFormat ()  { throw new RuntimeException(); }
  public  org.apache.commons.lang3.time.FastDateFormat timestampFormat ()  { throw new RuntimeException(); }
  public  boolean wholeFile ()  { throw new RuntimeException(); }
  public  int maxColumns ()  { throw new RuntimeException(); }
  public  int maxCharsPerColumn ()  { throw new RuntimeException(); }
  public  boolean escapeQuotes ()  { throw new RuntimeException(); }
  public  boolean quoteAll ()  { throw new RuntimeException(); }
  public  int inputBufferSize ()  { throw new RuntimeException(); }
  public  boolean isCommentSet ()  { throw new RuntimeException(); }
  public  com.univocity.parsers.csv.CsvWriterSettings asWriterSettings ()  { throw new RuntimeException(); }
  public  com.univocity.parsers.csv.CsvParserSettings asParserSettings ()  { throw new RuntimeException(); }
}
