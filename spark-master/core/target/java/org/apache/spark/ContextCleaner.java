package org.apache.spark;
/**
 * An asynchronous cleaner for RDD, shuffle, and broadcast state.
 * <p>
 * This maintains a weak reference for each RDD, ShuffleDependency, and Broadcast of interest,
 * to be processed when the associated object goes out of scope of the application. Actual
 * cleanup is performed in a separate daemon thread.
 */
  class ContextCleaner implements org.apache.spark.internal.Logging {
  static private  int REF_QUEUE_POLL_TIMEOUT ()  { throw new RuntimeException(); }
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
  public   ContextCleaner (org.apache.spark.SparkContext sc)  { throw new RuntimeException(); }
  /**
   * A buffer to ensure that <code>CleanupTaskWeakReference</code>s are not garbage collected as long as they
   * have not been handled by the reference queue.
   * @return (undocumented)
   */
  private  java.util.Set<org.apache.spark.CleanupTaskWeakReference> referenceBuffer ()  { throw new RuntimeException(); }
  private  java.lang.ref.ReferenceQueue<java.lang.Object> referenceQueue ()  { throw new RuntimeException(); }
  private  java.util.concurrent.ConcurrentLinkedQueue<org.apache.spark.CleanerListener> listeners ()  { throw new RuntimeException(); }
  private  java.lang.Thread cleaningThread ()  { throw new RuntimeException(); }
  private  java.util.concurrent.ScheduledExecutorService periodicGCService ()  { throw new RuntimeException(); }
  /**
   * How often to trigger a garbage collection in this JVM.
   * <p>
   * This context cleaner triggers cleanups only when weak references are garbage collected.
   * In long-running applications with large driver JVMs, where there is little memory pressure
   * on the driver, this may happen very occasionally or not at all. Not cleaning at all may
   * lead to executors running out of disk space after a while.
   * @return (undocumented)
   */
  private  long periodicGCInterval ()  { throw new RuntimeException(); }
  /**
   * Whether the cleaning thread will block on cleanup tasks (other than shuffle, which
   * is controlled by the <code>spark.cleaner.referenceTracking.blocking.shuffle</code> parameter).
   * <p>
   * Due to SPARK-3015, this is set to true by default. This is intended to be only a temporary
   * workaround for the issue, which is ultimately caused by the way the BlockManager endpoints
   * issue inter-dependent blocking RPC messages to each other at high frequencies. This happens,
   * for instance, when the driver performs a GC and cleans up all broadcast blocks that are no
   * longer in scope.
   * @return (undocumented)
   */
  private  boolean blockOnCleanupTasks ()  { throw new RuntimeException(); }
  /**
   * Whether the cleaning thread will block on shuffle cleanup tasks.
   * <p>
   * When context cleaner is configured to block on every delete request, it can throw timeout
   * exceptions on cleanup of shuffle blocks, as reported in SPARK-3139. To avoid that, this
   * parameter by default disables blocking on shuffle cleanups. Note that this does not affect
   * the cleanup of RDDs and broadcasts. This is intended to be a temporary workaround,
   * until the real RPC issue (referred to in the comment above <code>blockOnCleanupTasks</code>) is
   * resolved.
   * @return (undocumented)
   */
  private  boolean blockOnShuffleCleanupTasks ()  { throw new RuntimeException(); }
  private  boolean stopped ()  { throw new RuntimeException(); }
  /** Attach a listener object to get information of when objects are cleaned. */
  public  void attachListener (org.apache.spark.CleanerListener listener)  { throw new RuntimeException(); }
  /** Start the cleaner. */
  public  void start ()  { throw new RuntimeException(); }
  /**
   * Stop the cleaning thread and wait until the thread has finished running its current task.
   */
  public  void stop ()  { throw new RuntimeException(); }
  /** Register an RDD for cleanup when it is garbage collected. */
  public  void registerRDDForCleanup (org.apache.spark.rdd.RDD<?> rdd)  { throw new RuntimeException(); }
  public  void registerAccumulatorForCleanup (org.apache.spark.util.AccumulatorV2<?, ?> a)  { throw new RuntimeException(); }
  /** Register a ShuffleDependency for cleanup when it is garbage collected. */
  public  void registerShuffleForCleanup (org.apache.spark.ShuffleDependency<?, ?, ?> shuffleDependency)  { throw new RuntimeException(); }
  /** Register a Broadcast for cleanup when it is garbage collected. */
  public <T extends java.lang.Object> void registerBroadcastForCleanup (org.apache.spark.broadcast.Broadcast<T> broadcast)  { throw new RuntimeException(); }
  /** Register a RDDCheckpointData for cleanup when it is garbage collected. */
  public <T extends java.lang.Object> void registerRDDCheckpointDataForCleanup (org.apache.spark.rdd.RDD<?> rdd, int parentId)  { throw new RuntimeException(); }
  /** Register an object for cleanup. */
  private  void registerForCleanup (java.lang.Object objectForCleanup, org.apache.spark.CleanupTask task)  { throw new RuntimeException(); }
  /** Keep cleaning RDD, shuffle, and broadcast state. */
  private  void keepCleaning ()  { throw new RuntimeException(); }
  /** Perform RDD cleanup. */
  public  void doCleanupRDD (int rddId, boolean blocking)  { throw new RuntimeException(); }
  /** Perform shuffle cleanup. */
  public  void doCleanupShuffle (int shuffleId, boolean blocking)  { throw new RuntimeException(); }
  /** Perform broadcast cleanup. */
  public  void doCleanupBroadcast (long broadcastId, boolean blocking)  { throw new RuntimeException(); }
  /** Perform accumulator cleanup. */
  public  void doCleanupAccum (long accId, boolean blocking)  { throw new RuntimeException(); }
  /**
   * Clean up checkpoint files written to a reliable storage.
   * Locally checkpointed files are cleaned up separately through RDD cleanups.
   * @param rddId (undocumented)
   */
  public  void doCleanCheckpoint (int rddId)  { throw new RuntimeException(); }
  private  org.apache.spark.storage.BlockManagerMaster blockManagerMaster ()  { throw new RuntimeException(); }
  private  org.apache.spark.broadcast.BroadcastManager broadcastManager ()  { throw new RuntimeException(); }
  private  org.apache.spark.MapOutputTrackerMaster mapOutputTrackerMaster ()  { throw new RuntimeException(); }
}
