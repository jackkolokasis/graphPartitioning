package org.apache.spark.sql.execution.streaming;
/**
 * Manages the execution of a streaming Spark SQL query that is occurring in a separate thread.
 * Unlike a standard query, a streaming query executes repeatedly each time new data arrives at any
 * {@link Source} present in the query plan. Whenever new data arrives, a {@link QueryExecution} is created
 * and the results are committed transactionally to the given {@link Sink}.
 * <p>
 * param:  deleteCheckpointOnStop whether to delete the checkpoint if the query is stopped without
 *                               errors
 */
public  class StreamExecution implements org.apache.spark.sql.streaming.StreamingQuery, org.apache.spark.sql.execution.streaming.ProgressReporter, org.apache.spark.internal.Logging {
  public  org.apache.spark.sql.SparkSession sparkSession ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  java.lang.String checkpointRoot ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.Sink sink ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.Trigger trigger ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.Clock triggerClock ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.OutputMode outputMode ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamExecution (org.apache.spark.sql.SparkSession sparkSession, java.lang.String name, java.lang.String checkpointRoot, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan analyzedPlan, org.apache.spark.sql.execution.streaming.Sink sink, org.apache.spark.sql.streaming.Trigger trigger, org.apache.spark.util.Clock triggerClock, org.apache.spark.sql.streaming.OutputMode outputMode, boolean deleteCheckpointOnStop)  { throw new RuntimeException(); }
  private  long pollingDelayMs ()  { throw new RuntimeException(); }
  private  int minBatchesToRetain ()  { throw new RuntimeException(); }
  /**
   * A lock used to wait/notify when batches complete. Use a fair lock to avoid thread starvation.
   * @return (undocumented)
   */
  private  java.util.concurrent.locks.ReentrantLock awaitBatchLock ()  { throw new RuntimeException(); }
  private  java.util.concurrent.locks.Condition awaitBatchLockCondition ()  { throw new RuntimeException(); }
  private  java.util.concurrent.CountDownLatch initializationLatch ()  { throw new RuntimeException(); }
  private  java.util.concurrent.CountDownLatch startLatch ()  { throw new RuntimeException(); }
  private  java.util.concurrent.CountDownLatch terminationLatch ()  { throw new RuntimeException(); }
  /**
   * Tracks how much data we have processed and committed to the sink or state store from each
   * input source.
   * Only the scheduler thread should modify this field, and only in atomic steps.
   * Other threads should make a shallow copy if they are going to access this field more than
   * once, since the field's value may change at any time.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.StreamProgress committedOffsets ()  { throw new RuntimeException(); }
  /**
   * Tracks the offsets that are available to be processed, but have not yet be committed to the
   * sink.
   * Only the scheduler thread should modify this field, and only in atomic steps.
   * Other threads should make a shallow copy if they are going to access this field more than
   * once, since the field's value may change at any time.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.StreamProgress availableOffsets ()  { throw new RuntimeException(); }
  /** The current batchId or -1 if execution has not yet been initialized. */
  protected  long currentBatchId ()  { throw new RuntimeException(); }
  /** Metadata associated with the whole query */
  protected  org.apache.spark.sql.execution.streaming.StreamMetadata streamMetadata ()  { throw new RuntimeException(); }
  /** Metadata associated with the offset seq of a batch in the query. */
  protected  org.apache.spark.sql.execution.streaming.OffsetSeqMetadata offsetSeqMetadata ()  { throw new RuntimeException(); }
  public  java.util.UUID id ()  { throw new RuntimeException(); }
  public  java.util.UUID runId ()  { throw new RuntimeException(); }
  /**
   * Pretty identified string of printing in logs. Format is
   * If name is set "queryName [id = xyz, runId = abc]" else "[id = xyz, runId = abc]"
   * @return (undocumented)
   */
  private  java.lang.String prettyIdString ()  { throw new RuntimeException(); }
  /**
   * All stream sources present in the query plan. This will be set when generating logical plan.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<org.apache.spark.sql.execution.streaming.Source> sources ()  { throw new RuntimeException(); }
  /**
   * A list of unique sources in the query plan. This will be set when generating logical plan.
   * @return (undocumented)
   */
  private  scala.collection.Seq<org.apache.spark.sql.execution.streaming.Source> uniqueSources ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan ()  { throw new RuntimeException(); }
  private  scala.Product triggerExecutor ()  { throw new RuntimeException(); }
  /** Defines the internal state of execution */
  private  java.util.concurrent.atomic.AtomicReference<org.apache.spark.sql.execution.streaming.State> state ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.IncrementalExecution lastExecution ()  { throw new RuntimeException(); }
  /** Holds the most recent input data for each source. */
  protected  scala.collection.immutable.Map<org.apache.spark.sql.execution.streaming.Source, org.apache.spark.sql.Dataset<org.apache.spark.sql.Row>> newData ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.streaming.StreamingQueryException streamDeathCause ()  { throw new RuntimeException(); }
  private  org.apache.spark.util.CallSite callSite ()  { throw new RuntimeException(); }
  /** Used to report metrics to coda-hale. This uses id for easier tracking across restarts. */
  public  org.apache.spark.sql.execution.streaming.MetricsReporter streamMetrics ()  { throw new RuntimeException(); }
  /**
   * The thread that runs the micro-batches of this stream. Note that this thread must be
   * {@link org.apache.spark.util.UninterruptibleThread} to workaround KAFKA-1894: interrupting a
   * running <code>KafkaConsumer</code> may cause endless loop.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.StreamExecutionThread microBatchThread ()  { throw new RuntimeException(); }
  /**
   * A write-ahead-log that records the offsets that are present in each batch. In order to ensure
   * that a given batch will always consist of the same data, we write to this log *before* any
   * processing is done.  Thus, the Nth record in this log indicated data that is currently being
   * processed and the N-1th entry indicates which offsets have been durably committed to the sink.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.OffsetSeqLog offsetLog ()  { throw new RuntimeException(); }
  /**
   * A log that records the batch ids that have completed. This is used to check if a batch was
   * fully processed, and its output was committed to the sink, hence no need to process it again.
   * This is used (for instance) during restart, to help identify which batch to run next.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.BatchCommitLog batchCommitLog ()  { throw new RuntimeException(); }
  /** Whether all fields of the query have been initialized */
  private  boolean isInitialized ()  { throw new RuntimeException(); }
  /** Whether the query is currently active or not */
  public  boolean isActive ()  { throw new RuntimeException(); }
  /** Returns the {@link StreamingQueryException} if the query was terminated by an exception. */
  public  scala.Option<org.apache.spark.sql.streaming.StreamingQueryException> exception ()  { throw new RuntimeException(); }
  /** Returns the path of a file with `name` in the checkpoint directory. */
  private  java.lang.String checkpointFile (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Starts the execution. This returns only after the thread has started and {@link QueryStartedEvent}
   * has been posted to all the listeners.
   */
  public  void start ()  { throw new RuntimeException(); }
  /**
   * Repeatedly attempts to run batches as data arrives.
   * <p>
   * Note that this method ensures that {@link QueryStartedEvent} and {@link QueryTerminatedEvent} are
   * posted such that listeners are guaranteed to get a start event before a termination.
   * Furthermore, this method also ensures that {@link QueryStartedEvent} event is posted before the
   * <code>start()</code> method returns.
   */
  private  void runBatches ()  { throw new RuntimeException(); }
  /**
   * Populate the start offsets to start the execution at the current offsets stored in the sink
   * (i.e. avoid reprocessing data that we have already processed). This function must be called
   * before any processing occurs and will populate the following fields:
   *  - currentBatchId
   *  - committedOffsets
   *  - availableOffsets
   *  The basic structure of this method is as follows:
   * <p>
   *  Identify (from the offset log) the offsets used to run the last batch
   *  IF last batch exists THEN
   *    Set the next batch to be executed as the last recovered batch
   *    Check the commit log to see which batch was committed last
   *    IF the last batch was committed THEN
   *      Call getBatch using the last batch start and end offsets
   *      // ^^^^ above line is needed since some sources assume last batch always re-executes
   *      Setup for a new batch i.e., start = last batch end, and identify new end
   *    DONE
   *  ELSE
   *    Identify a brand new batch
   *  DONE
   * @param sparkSessionToRunBatches (undocumented)
   */
  private  void populateStartOffsets (org.apache.spark.sql.SparkSession sparkSessionToRunBatches)  { throw new RuntimeException(); }
  /**
   * Returns true if there is any new data available to be processed.
   * @return (undocumented)
   */
  private  boolean dataAvailable ()  { throw new RuntimeException(); }
  /**
   * Queries all of the sources to see if any new data is available. When there is new data the
   * batchId counter is incremented and a new log entry is written with the newest offsets.
   */
  private  void constructNextBatch ()  { throw new RuntimeException(); }
  /**
   * Processes any data available between <code>availableOffsets</code> and <code>committedOffsets</code>.
   * @param sparkSessionToRunBatch Isolated {@link SparkSession} to run this batch with.
   */
  private  void runBatch (org.apache.spark.sql.SparkSession sparkSessionToRunBatch)  { throw new RuntimeException(); }
  protected  void postEvent (org.apache.spark.sql.streaming.StreamingQueryListener.Event event)  { throw new RuntimeException(); }
  /** Stops all streaming sources safely. */
  private  void stopSources ()  { throw new RuntimeException(); }
  /**
   * Signals to the thread executing micro-batches that it should stop running after the next
   * batch. This method blocks until the thread stops running.
   */
  public  void stop ()  { throw new RuntimeException(); }
  /**
   * Blocks the current thread until processing for data from the given <code>source</code> has reached at
   * least the given <code>Offset</code>. This method is intended for use primarily when writing tests.
   * @param source (undocumented)
   * @param newOffset (undocumented)
   */
    void awaitOffset (org.apache.spark.sql.execution.streaming.Source source, org.apache.spark.sql.execution.streaming.Offset newOffset)  { throw new RuntimeException(); }
  /** A flag to indicate that a batch has completed with no new data available. */
  private  boolean noNewData ()  { throw new RuntimeException(); }
  /**
   * Assert that the await APIs should not be called in the stream thread. Otherwise, it may cause
   * dead-lock, e.g., calling any await APIs in <code>StreamingQueryListener.onQueryStarted</code> will block
   * the stream thread forever.
   */
  private  void assertAwaitThread ()  { throw new RuntimeException(); }
  /**
   * Await until all fields of the query have been initialized.
   * @param timeoutMs (undocumented)
   */
  public  void awaitInitialization (long timeoutMs)  { throw new RuntimeException(); }
  public  void processAllAvailable ()  { throw new RuntimeException(); }
  public  void awaitTermination ()  { throw new RuntimeException(); }
  public  boolean awaitTermination (long timeoutMs)  { throw new RuntimeException(); }
  /** Expose for tests */
  public  java.lang.String explainInternal (boolean extended)  { throw new RuntimeException(); }
  public  void explain (boolean extended)  { throw new RuntimeException(); }
  public  void explain ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  private  java.lang.String toDebugString (boolean includeLogicalPlan)  { throw new RuntimeException(); }
}
