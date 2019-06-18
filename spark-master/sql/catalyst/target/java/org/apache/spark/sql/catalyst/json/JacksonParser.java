package org.apache.spark.sql.catalyst.json;
/**
 * Constructs a parser for a given schema that translates a json string to an {@link InternalRow}.
 */
public  class JacksonParser implements org.apache.spark.internal.Logging {
  public  org.apache.spark.sql.catalyst.json.JSONOptions options ()  { throw new RuntimeException(); }
  // not preceding
  public   JacksonParser (org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.catalyst.json.JSONOptions options)  { throw new RuntimeException(); }
  private  scala.Function1<com.fasterxml.jackson.core.JsonParser, scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow>> rootConverter ()  { throw new RuntimeException(); }
  private  com.fasterxml.jackson.core.JsonFactory factory ()  { throw new RuntimeException(); }
  /**
   * Create a converter which converts the JSON documents held by the <code>JsonParser</code>
   * to a value according to a desired schema. This is a wrapper for the method
   * <code>makeConverter()</code> to handle a row wrapped with an array.
   * @param st (undocumented)
   * @return (undocumented)
   */
  private  scala.Function1<com.fasterxml.jackson.core.JsonParser, scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow>> makeRootConverter (org.apache.spark.sql.types.StructType st)  { throw new RuntimeException(); }
  /**
   * Create a converter which converts the JSON documents held by the <code>JsonParser</code>
   * to a value according to a desired schema.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  scala.Function1<com.fasterxml.jackson.core.JsonParser, java.lang.Object> makeConverter (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * This method skips <code>FIELD_NAME</code>s at the beginning, and handles nulls ahead before trying
   * to parse the JSON token using given function <code>f</code>. If the <code>f</code> failed to parse and convert the
   * token, call <code>failedConversion</code> to handle the token.
   * @param parser (undocumented)
   * @param dataType (undocumented)
   * @param f (undocumented)
   * @return (undocumented)
   */
  private <R extends java.lang.Object> R parseJsonToken (com.fasterxml.jackson.core.JsonParser parser, org.apache.spark.sql.types.DataType dataType, scala.PartialFunction<com.fasterxml.jackson.core.JsonToken, R> f)  { throw new RuntimeException(); }
  /**
   * This function throws an exception for failed conversion, but returns null for empty string,
   * to guard the non string types.
   * @param parser (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  private <R extends java.lang.Object> scala.PartialFunction<com.fasterxml.jackson.core.JsonToken, R> failedConversion (com.fasterxml.jackson.core.JsonParser parser, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Parse an object from the token stream into a new Row representing the schema.
   * Fields in the json that are not defined in the requested schema will be dropped.
   * @param parser (undocumented)
   * @param schema (undocumented)
   * @param fieldConverters (undocumented)
   * @return (undocumented)
   */
  private  org.apache.spark.sql.catalyst.InternalRow convertObject (com.fasterxml.jackson.core.JsonParser parser, org.apache.spark.sql.types.StructType schema, scala.Function1<com.fasterxml.jackson.core.JsonParser, java.lang.Object>[] fieldConverters)  { throw new RuntimeException(); }
  /**
   * Parse an object as a Map, preserving all fields.
   * @param parser (undocumented)
   * @param fieldConverter (undocumented)
   * @return (undocumented)
   */
  private  org.apache.spark.sql.catalyst.util.MapData convertMap (com.fasterxml.jackson.core.JsonParser parser, scala.Function1<com.fasterxml.jackson.core.JsonParser, java.lang.Object> fieldConverter)  { throw new RuntimeException(); }
  /**
   * Parse an object as a Array.
   * @param parser (undocumented)
   * @param fieldConverter (undocumented)
   * @return (undocumented)
   */
  private  org.apache.spark.sql.catalyst.util.ArrayData convertArray (com.fasterxml.jackson.core.JsonParser parser, scala.Function1<com.fasterxml.jackson.core.JsonParser, java.lang.Object> fieldConverter)  { throw new RuntimeException(); }
  /**
   * Parse the JSON input to the set of {@link InternalRow}s.
   * <p>
   * @param recordLiteral an optional function that will be used to generate
   *   the corrupt record text instead of record.toString
   * @param createParser (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> parse (T record, scala.Function2<com.fasterxml.jackson.core.JsonFactory, T, com.fasterxml.jackson.core.JsonParser> createParser, scala.Function1<T, org.apache.spark.unsafe.types.UTF8String> recordLiteral)  { throw new RuntimeException(); }
}
