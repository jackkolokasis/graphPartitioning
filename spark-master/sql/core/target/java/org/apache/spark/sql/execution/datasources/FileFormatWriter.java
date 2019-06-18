package org.apache.spark.sql.execution.datasources;
/** A helper object for writing FileFormat data out to a location. */
public  class FileFormatWriter {
  /** Describes how output files should be placed in the filesystem. */
  static public  class OutputSpec implements scala.Product, scala.Serializable {
    public  java.lang.String outputPath ()  { throw new RuntimeException(); }
    public  scala.collection.immutable.Map<scala.collection.immutable.Map<java.lang.String, java.lang.String>, java.lang.String> customPartitionLocations ()  { throw new RuntimeException(); }
    // not preceding
    public   OutputSpec (java.lang.String outputPath, scala.collection.immutable.Map<scala.collection.immutable.Map<java.lang.String, java.lang.String>, java.lang.String> customPartitionLocations)  { throw new RuntimeException(); }
  }
  static public  class OutputSpec$ extends scala.runtime.AbstractFunction2<java.lang.String, scala.collection.immutable.Map<scala.collection.immutable.Map<java.lang.String, java.lang.String>, java.lang.String>, org.apache.spark.sql.execution.datasources.FileFormatWriter.OutputSpec> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final OutputSpec$ MODULE$ = null;
    public   OutputSpec$ ()  { throw new RuntimeException(); }
  }
  /** The result of a successful write task. */
  static private  class WriteTaskResult implements scala.Product, scala.Serializable {
    public  org.apache.spark.internal.io.FileCommitProtocol.TaskCommitMessage commitMsg ()  { throw new RuntimeException(); }
    public  scala.collection.immutable.Set<java.lang.String> updatedPartitions ()  { throw new RuntimeException(); }
    // not preceding
    public   WriteTaskResult (org.apache.spark.internal.io.FileCommitProtocol.TaskCommitMessage commitMsg, scala.collection.immutable.Set<java.lang.String> updatedPartitions)  { throw new RuntimeException(); }
  }
  static private  class WriteTaskResult$ extends scala.runtime.AbstractFunction2<org.apache.spark.internal.io.FileCommitProtocol.TaskCommitMessage, scala.collection.immutable.Set<java.lang.String>, org.apache.spark.sql.execution.datasources.FileFormatWriter.WriteTaskResult> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final WriteTaskResult$ MODULE$ = null;
    public   WriteTaskResult$ ()  { throw new RuntimeException(); }
  }
  /** A shared job description for all the write tasks. */
  static private  class WriteJobDescription implements scala.Serializable {
    public  java.lang.String uuid ()  { throw new RuntimeException(); }
    public  org.apache.spark.util.SerializableConfiguration serializableHadoopConf ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.execution.datasources.OutputWriterFactory outputWriterFactory ()  { throw new RuntimeException(); }
    public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> allColumns ()  { throw new RuntimeException(); }
    public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataColumns ()  { throw new RuntimeException(); }
    public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> partitionColumns ()  { throw new RuntimeException(); }
    public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> bucketIdExpression ()  { throw new RuntimeException(); }
    public  java.lang.String path ()  { throw new RuntimeException(); }
    public  scala.collection.immutable.Map<scala.collection.immutable.Map<java.lang.String, java.lang.String>, java.lang.String> customPartitionLocations ()  { throw new RuntimeException(); }
    public  long maxRecordsPerFile ()  { throw new RuntimeException(); }
    public  java.lang.String timeZoneId ()  { throw new RuntimeException(); }
    // not preceding
    public   WriteJobDescription (java.lang.String uuid, org.apache.spark.util.SerializableConfiguration serializableHadoopConf, org.apache.spark.sql.execution.datasources.OutputWriterFactory outputWriterFactory, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> allColumns, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataColumns, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> partitionColumns, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> bucketIdExpression, java.lang.String path, scala.collection.immutable.Map<scala.collection.immutable.Map<java.lang.String, java.lang.String>, java.lang.String> customPartitionLocations, long maxRecordsPerFile, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  }
  /**
   * A simple trait for writing out data in a single Spark task, without any concerns about how
   * to commit or abort tasks. Exceptions thrown by the implementation of this trait will
   * automatically trigger task aborts.
   */
  static   interface ExecuteWriteTask {
    /**
     * Writes data out to files, and then returns the list of partition strings written out.
     * The list of partitions is sent back to the driver and used to update the catalog.
     * @param iterator (undocumented)
     * @return (undocumented)
     */
    public  scala.collection.immutable.Set<java.lang.String> execute (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> iterator)  ;
    public  void releaseResources ()  ;
  }
  /** Writes data to a single directory (used for non-dynamic-partition writes). */
  static private  class SingleDirectoryWriteTask implements org.apache.spark.sql.execution.datasources.FileFormatWriter.ExecuteWriteTask {
    public   SingleDirectoryWriteTask (org.apache.spark.sql.execution.datasources.FileFormatWriter.WriteJobDescription description, org.apache.hadoop.mapreduce.TaskAttemptContext taskAttemptContext, org.apache.spark.internal.io.FileCommitProtocol committer)  { throw new RuntimeException(); }
    private  void newOutputWriter (int fileCounter)  { throw new RuntimeException(); }
    public  scala.collection.immutable.Set<java.lang.String> execute (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> iter)  { throw new RuntimeException(); }
    public  void releaseResources ()  { throw new RuntimeException(); }
  }
  /**
   * Writes data to using dynamic partition writes, meaning this single function can write to
   * multiple directories (partitions) or files (bucketing).
   */
  static private  class DynamicPartitionWriteTask implements org.apache.spark.sql.execution.datasources.FileFormatWriter.ExecuteWriteTask {
    public   DynamicPartitionWriteTask (org.apache.spark.sql.execution.datasources.FileFormatWriter.WriteJobDescription desc, org.apache.hadoop.mapreduce.TaskAttemptContext taskAttemptContext, org.apache.spark.internal.io.FileCommitProtocol committer)  { throw new RuntimeException(); }
    private  org.apache.spark.sql.execution.datasources.OutputWriter currentWriter ()  { throw new RuntimeException(); }
    /** Expressions that given partition columns build a path string like: col1=val/col2=val/... */
    private  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionPathExpression ()  { throw new RuntimeException(); }
    /**
     * Opens a new OutputWriter given a partition key and optional bucket id.
     * If bucket id is specified, we will append it to the end of the file name, but before the
     * file extension, e.g. part-r-00009-ea518ad4-455a-4431-b471-d24e03814677-00002.gz.parquet
     * <p>
     * @param partColsAndBucketId a row consisting of partition columns and a bucket id for the
     *                            current row.
     * @param getPartitionPath a function that projects the partition values into a path string.
     * @param fileCounter the number of files that have been written in the past for this specific
     *                    partition. This is used to limit the max number of records written for a
     *                    single file. The value should start from 0.
     * @param updatedPartitions the set of updated partition paths, we should add the new partition
     *                          path of this writer to it.
     */
    private  void newOutputWriter (org.apache.spark.sql.catalyst.InternalRow partColsAndBucketId, org.apache.spark.sql.catalyst.expressions.UnsafeProjection getPartitionPath, int fileCounter, scala.collection.mutable.Set<java.lang.String> updatedPartitions)  { throw new RuntimeException(); }
    public  scala.collection.immutable.Set<java.lang.String> execute (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> iter)  { throw new RuntimeException(); }
    public  void releaseResources ()  { throw new RuntimeException(); }
  }
  /**
   * Max number of files a single task writes out due to file size. In most cases the number of
   * files written should be very small. This is just a safe guard to protect some really bad
   * settings, e.g. maxRecordsPerFile = 1.
   * @return (undocumented)
   */
  static private  int MAX_FILE_COUNTER ()  { throw new RuntimeException(); }
  /**
   * Basic work flow of this command is:
   * 1. Driver side setup, including output committer initialization and data source specific
   *    preparation work for the write job to be issued.
   * 2. Issues a write job consists of one or more executor side tasks, each of which writes all
   *    rows within an RDD partition.
   * 3. If no exception is thrown in a task, commits that task, otherwise aborts that task;  If any
   *    exception is thrown during task commitment, also aborts that task.
   * 4. If all tasks are committed, commit the job, otherwise aborts the job;  If any exception is
   *    thrown during job commitment, also aborts the job.
   * @param sparkSession (undocumented)
   * @param queryExecution (undocumented)
   * @param fileFormat (undocumented)
   * @param committer (undocumented)
   * @param outputSpec (undocumented)
   * @param hadoopConf (undocumented)
   * @param partitionColumns (undocumented)
   * @param bucketSpec (undocumented)
   * @param refreshFunction (undocumented)
   * @param options (undocumented)
   */
  static public  void write (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.QueryExecution queryExecution, org.apache.spark.sql.execution.datasources.FileFormat fileFormat, org.apache.spark.internal.io.FileCommitProtocol committer, org.apache.spark.sql.execution.datasources.FileFormatWriter.OutputSpec outputSpec, org.apache.hadoop.conf.Configuration hadoopConf, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> partitionColumns, scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec, scala.Function1<scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>>, scala.runtime.BoxedUnit> refreshFunction, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /** Writes data out in a single Spark task. */
  static private  org.apache.spark.sql.execution.datasources.FileFormatWriter.WriteTaskResult executeTask (org.apache.spark.sql.execution.datasources.FileFormatWriter.WriteJobDescription description, int sparkStageId, int sparkPartitionId, int sparkAttemptNumber, org.apache.spark.internal.io.FileCommitProtocol committer, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> iterator)  { throw new RuntimeException(); }
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
}
