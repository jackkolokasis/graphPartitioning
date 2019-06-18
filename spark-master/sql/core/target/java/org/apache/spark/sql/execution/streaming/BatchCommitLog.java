package org.apache.spark.sql.execution.streaming;
/**
 * Used to write log files that represent batch commit points in structured streaming.
 * A commit log file will be written immediately after the successful completion of a
 * batch, and before processing the next batch. Here is an execution summary:
 * - trigger batch 1
 * - obtain batch 1 offsets and write to offset log
 * - process batch 1
 * - write batch 1 to completion log
 * - trigger batch 2
 * - obtain bactch 2 offsets and write to offset log
 * - process batch 2
 * - write batch 2 to completion log
 * ....
 * <p>
 * The current format of the batch completion log is:
 * line 1: version
 * line 2: metadata (optional json string)
 */
public  class BatchCommitLog extends org.apache.spark.sql.execution.streaming.HDFSMetadataLog<java.lang.String> {
  static private  int VERSION ()  { throw new RuntimeException(); }
  static private  java.lang.String EMPTY_JSON ()  { throw new RuntimeException(); }
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
  static public  org.apache.hadoop.fs.Path metadataPath ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.execution.streaming.HDFSMetadataLog.FileManager fileManager ()  { throw new RuntimeException(); }
  static protected  java.lang.Object batchFilesFilter ()  { throw new RuntimeException(); }
  static protected  org.apache.hadoop.fs.Path batchIdToPath (long batchId)  { throw new RuntimeException(); }
  static protected  long pathToBatchId (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  static protected  boolean isBatchFile (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  static public  scala.Option<T> get (org.apache.hadoop.fs.Path batchFile)  { throw new RuntimeException(); }
  static public  scala.Option<T> get (long batchId)  { throw new RuntimeException(); }
  static public  scala.Tuple2<java.lang.Object, T>[] get (scala.Option<java.lang.Object> startId, scala.Option<java.lang.Object> endId)  { throw new RuntimeException(); }
  static public  scala.Option<scala.Tuple2<java.lang.Object, T>> getLatest ()  { throw new RuntimeException(); }
  static public  org.apache.hadoop.fs.FileStatus[] getOrderedBatchFiles ()  { throw new RuntimeException(); }
  static public  void purge (long thresholdBatchId)  { throw new RuntimeException(); }
  static   int parseVersion (java.lang.String text, int maxSupportedVersion)  { throw new RuntimeException(); }
  public   BatchCommitLog (org.apache.spark.sql.SparkSession sparkSession, java.lang.String path)  { throw new RuntimeException(); }
  public  void add (long batchId)  { throw new RuntimeException(); }
  public  boolean add (long batchId, java.lang.String metadata)  { throw new RuntimeException(); }
  protected  java.lang.String deserialize (java.io.InputStream in)  { throw new RuntimeException(); }
  protected  void serialize (java.lang.String metadata, java.io.OutputStream out)  { throw new RuntimeException(); }
}
