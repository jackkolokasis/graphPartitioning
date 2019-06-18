package org.apache.spark.sql.catalyst.json;
/**
 * Options for parsing JSON data into Spark SQL rows.
 * <p>
 * Most of these map directly to Jackson's internal options, specified in {@link JsonParser.Feature}.
 */
  class JSONOptions implements org.apache.spark.internal.Logging, scala.Serializable {
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
  public   JSONOptions (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters, java.lang.String defaultTimeZoneId, java.lang.String defaultColumnNameOfCorruptRecord)  { throw new RuntimeException(); }
  public   JSONOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, java.lang.String defaultTimeZoneId, java.lang.String defaultColumnNameOfCorruptRecord)  { throw new RuntimeException(); }
  public  double samplingRatio ()  { throw new RuntimeException(); }
  public  boolean primitivesAsString ()  { throw new RuntimeException(); }
  public  boolean prefersDecimal ()  { throw new RuntimeException(); }
  public  boolean allowComments ()  { throw new RuntimeException(); }
  public  boolean allowUnquotedFieldNames ()  { throw new RuntimeException(); }
  public  boolean allowSingleQuotes ()  { throw new RuntimeException(); }
  public  boolean allowNumericLeadingZeros ()  { throw new RuntimeException(); }
  public  boolean allowNonNumericNumbers ()  { throw new RuntimeException(); }
  public  boolean allowBackslashEscapingAnyCharacter ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> compressionCodec ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.ParseMode parseMode ()  { throw new RuntimeException(); }
  public  java.lang.String columnNameOfCorruptRecord ()  { throw new RuntimeException(); }
  public  java.util.TimeZone timeZone ()  { throw new RuntimeException(); }
  public  org.apache.commons.lang3.time.FastDateFormat dateFormat ()  { throw new RuntimeException(); }
  public  org.apache.commons.lang3.time.FastDateFormat timestampFormat ()  { throw new RuntimeException(); }
  public  boolean wholeFile ()  { throw new RuntimeException(); }
  /** Sets config options on a Jackson {@link JsonFactory}. */
  public  void setJacksonOptions (com.fasterxml.jackson.core.JsonFactory factory)  { throw new RuntimeException(); }
}
