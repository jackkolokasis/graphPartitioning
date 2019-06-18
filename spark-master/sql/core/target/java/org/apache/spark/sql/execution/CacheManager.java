package org.apache.spark.sql.execution;
/**
 * Provides support in a SQLContext for caching query results and automatically using these cached
 * results when subsequent queries are executed.  Data is cached using byte buffers stored in an
 * InMemoryRelation.  This relation is automatically substituted query plans that return the
 * <code>sameResult</code> as the originally cached query.
 * <p>
 * Internal to Spark SQL.
 */
public  class CacheManager implements org.apache.spark.internal.Logging {
  public   CacheManager ()  { throw new RuntimeException(); }
  private  java.util.LinkedList<org.apache.spark.sql.execution.CachedData> cachedData ()  { throw new RuntimeException(); }
  private  java.util.concurrent.locks.ReentrantReadWriteLock cacheLock ()  { throw new RuntimeException(); }
  /** Acquires a read lock on the cache for the duration of `f`. */
  private <A extends java.lang.Object> A readLock (scala.Function0<A> f)  { throw new RuntimeException(); }
  /** Acquires a write lock on the cache for the duration of `f`. */
  private <A extends java.lang.Object> A writeLock (scala.Function0<A> f)  { throw new RuntimeException(); }
  /** Clears all cached tables. */
  public  void clearCache ()  { throw new RuntimeException(); }
  /** Checks if the cache is empty. */
  public  boolean isEmpty ()  { throw new RuntimeException(); }
  /**
   * Caches the data produced by the logical representation of the given {@link Dataset}.
   * Unlike <code>RDD.cache()</code>, the default storage level is set to be <code>MEMORY_AND_DISK</code> because
   * recomputing the in-memory columnar representation of the underlying table is expensive.
   * @param query (undocumented)
   * @param tableName (undocumented)
   * @param storageLevel (undocumented)
   */
  public  void cacheQuery (org.apache.spark.sql.Dataset<?> query, scala.Option<java.lang.String> tableName, org.apache.spark.storage.StorageLevel storageLevel)  { throw new RuntimeException(); }
  /**
   * Un-cache all the cache entries that refer to the given plan.
   * @param query (undocumented)
   * @param blocking (undocumented)
   */
  public  void uncacheQuery (org.apache.spark.sql.Dataset<?> query, boolean blocking)  { throw new RuntimeException(); }
  /**
   * Un-cache all the cache entries that refer to the given plan.
   * @param spark (undocumented)
   * @param plan (undocumented)
   * @param blocking (undocumented)
   */
  public  void uncacheQuery (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, boolean blocking)  { throw new RuntimeException(); }
  /**
   * Tries to re-cache all the cache entries that refer to the given plan.
   * @param spark (undocumented)
   * @param plan (undocumented)
   */
  public  void recacheByPlan (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  private  void recacheByCondition (org.apache.spark.sql.SparkSession spark, scala.Function1<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, java.lang.Object> condition)  { throw new RuntimeException(); }
  /** Optionally returns cached data for the given {@link Dataset} */
  public  scala.Option<org.apache.spark.sql.execution.CachedData> lookupCachedData (org.apache.spark.sql.Dataset<?> query)  { throw new RuntimeException(); }
  /** Optionally returns cached data for the given {@link LogicalPlan}. */
  public  scala.Option<org.apache.spark.sql.execution.CachedData> lookupCachedData (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /** Replaces segments of the given logical plan with cached versions where possible. */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan useCachedData (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Tries to re-cache all the cache entries that contain <code>resourcePath</code> in one or more
   * <code>HadoopFsRelation</code> node(s) as part of its logical plan.
   * @param spark (undocumented)
   * @param resourcePath (undocumented)
   */
  public  void recacheByPath (org.apache.spark.sql.SparkSession spark, java.lang.String resourcePath)  { throw new RuntimeException(); }
  /**
   * Traverses a given <code>plan</code> and searches for the occurrences of <code>qualifiedPath</code> in the
   * {@link org.apache.spark.sql.execution.datasources.FileIndex} of any {@link HadoopFsRelation} nodes
   * in the plan. If found, we refresh the metadata and return true. Otherwise, this method returns
   * false.
   * @param plan (undocumented)
   * @param fs (undocumented)
   * @param qualifiedPath (undocumented)
   * @return (undocumented)
   */
  private  boolean lookupAndRefresh (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path qualifiedPath)  { throw new RuntimeException(); }
}
