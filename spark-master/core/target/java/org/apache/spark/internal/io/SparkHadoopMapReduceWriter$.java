package org.apache.spark.internal.io;
/**
 * A helper object that saves an RDD using a Hadoop OutputFormat
 * (from the newer mapreduce API, not the old mapred API).
 */
public  class SparkHadoopMapReduceWriter$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SparkHadoopMapReduceWriter$ MODULE$ = null;
  public   SparkHadoopMapReduceWriter$ ()  { throw new RuntimeException(); }
  /**
   * Basic work flow of this command is:
   * 1. Driver side setup, prepare the data source and hadoop configuration for the write job to
   *    be issued.
   * 2. Issues a write job consists of one or more executor side tasks, each of which writes all
   *    rows within an RDD partition.
   * 3. If no exception is thrown in a task, commits that task, otherwise aborts that task;  If any
   *    exception is thrown during task commitment, also aborts that task.
   * 4. If all tasks are committed, commit the job, otherwise aborts the job;  If any exception is
   *    thrown during job commitment, also aborts the job.
   * @param rdd (undocumented)
   * @param hadoopConf (undocumented)
   * @param evidence$1 (undocumented)
   */
  public <K extends java.lang.Object, V extends java.lang.Object> void write (org.apache.spark.rdd.RDD<scala.Tuple2<K, V>> rdd, org.apache.hadoop.conf.Configuration hadoopConf, scala.reflect.ClassTag<V> evidence$1)  { throw new RuntimeException(); }
  /** Write an RDD partition out in a single Spark task. */
  private <K extends java.lang.Object, V extends java.lang.Object> org.apache.spark.internal.io.FileCommitProtocol.TaskCommitMessage executeTask (org.apache.spark.TaskContext context, java.lang.String jobTrackerId, int sparkStageId, int sparkPartitionId, int sparkAttemptNumber, org.apache.spark.internal.io.FileCommitProtocol committer, org.apache.hadoop.conf.Configuration hadoopConf, java.lang.Class<? extends org.apache.hadoop.mapreduce.OutputFormat<K, V>> outputFormat, scala.collection.Iterator<scala.Tuple2<K, V>> iterator, scala.reflect.ClassTag<V> evidence$2)  { throw new RuntimeException(); }
}
