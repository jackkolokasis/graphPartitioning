package org.apache.spark.sql.execution.datasources.text;
/**
 * Options for the Text data source.
 */
  class TextOptions implements scala.Serializable {
  static public  java.lang.String COMPRESSION ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters ()  { throw new RuntimeException(); }
  // not preceding
  public   TextOptions (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters)  { throw new RuntimeException(); }
  public   TextOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  /**
   * Compression codec to use.
   * @return (undocumented)
   */
  public  scala.Option<java.lang.String> compressionCodec ()  { throw new RuntimeException(); }
}
