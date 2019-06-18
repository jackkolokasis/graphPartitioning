package org.apache.spark.sql.execution.streaming.state;
/**
 * Base trait for a versioned key-value store used for streaming aggregations
 */
public  interface StateStore {
  /**
   * Runs the <code>task</code> periodically and automatically cancels it if there is an exception. <code>onError</code>
   * will be called when an exception happens.
   */
  static public  class MaintenanceTask {
    public   MaintenanceTask (long periodMs, scala.Function0<scala.runtime.BoxedUnit> task, scala.Function0<scala.runtime.BoxedUnit> onError)  { throw new RuntimeException(); }
    private  java.util.concurrent.ScheduledExecutorService executor ()  { throw new RuntimeException(); }
    private  java.lang.Object runnable ()  { throw new RuntimeException(); }
    private  java.util.concurrent.ScheduledFuture<?> future ()  { throw new RuntimeException(); }
    public  void stop ()  { throw new RuntimeException(); }
    public  boolean isRunning ()  { throw new RuntimeException(); }
  }
  /** Unique identifier of the store */
  public  org.apache.spark.sql.execution.streaming.state.StateStoreId id ()  ;
  /** Version of the data in this store before committing updates. */
  public  long version ()  ;
  /** Get the current value of a key. */
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.UnsafeRow> get (org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  ;
  /**
   * Return an iterator of key-value pairs that satisfy a certain condition.
   * Note that the iterator must be fail-safe towards modification to the store, that is,
   * it must be based on the snapshot of store the time of this call, and any change made to the
   * store while iterating through iterator should not cause the iterator to fail or have
   * any affect on the values in the iterator.
   * @param condition (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow>> filter (scala.Function2<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow, java.lang.Object> condition)  ;
  /** Put a new value for a key. */
  public  void put (org.apache.spark.sql.catalyst.expressions.UnsafeRow key, org.apache.spark.sql.catalyst.expressions.UnsafeRow value)  ;
  /**
   * Remove keys that match the following condition.
   * @param condition (undocumented)
   */
  public  void remove (scala.Function1<org.apache.spark.sql.catalyst.expressions.UnsafeRow, java.lang.Object> condition)  ;
  /**
   * Remove a single key.
   * @param key (undocumented)
   */
  public  void remove (org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  ;
  /**
   * Commit all the updates that have been made to the store, and return the new version.
   * @return (undocumented)
   */
  public  long commit ()  ;
  /** Abort all the updates that have been made to the store. */
  public  void abort ()  ;
  /**
   * Iterator of store data after a set of updates have been committed.
   * This can be called only after committing all the updates made in the current thread.
   * @return (undocumented)
   */
  public  scala.collection.Iterator<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow>> iterator ()  ;
  /**
   * Iterator of the updates that have been committed.
   * This can be called only after committing all the updates made in the current thread.
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.StoreUpdate> updates ()  ;
  /** Number of keys in the state store */
  public  long numKeys ()  ;
  /**
   * Whether all updates have been committed
   * @return (undocumented)
   */
    boolean hasCommitted ()  ;
}
