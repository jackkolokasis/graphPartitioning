package org.apache.spark.sql.execution.streaming;
public  class FileStreamSink$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final FileStreamSink$ MODULE$ = null;
  public   FileStreamSink$ ()  { throw new RuntimeException(); }
  public  java.lang.String metadataDir ()  { throw new RuntimeException(); }
  /**
   * Returns true if there is a single path that has a metadata log indicating which files should
   * be read.
   * @param path (undocumented)
   * @param hadoopConf (undocumented)
   * @return (undocumented)
   */
  public  boolean hasMetadata (scala.collection.Seq<java.lang.String> path, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
}
