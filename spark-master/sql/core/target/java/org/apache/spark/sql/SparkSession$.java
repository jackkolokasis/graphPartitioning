package org.apache.spark.sql;
public  class SparkSession$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SparkSession$ MODULE$ = null;
  public   SparkSession$ ()  { throw new RuntimeException(); }
  /**
   * Creates a {@link SparkSession.Builder} for constructing a {@link SparkSession}.
   * <p>
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.SparkSession.Builder builder ()  { throw new RuntimeException(); }
  /**
   * Changes the SparkSession that will be returned in this thread and its children when
   * SparkSession.getOrCreate() is called. This can be used to ensure that a given thread receives
   * a SparkSession with an isolated session, instead of the global (first created) context.
   * <p>
   * @since 2.0.0
   * @param session (undocumented)
   */
  public  void setActiveSession (org.apache.spark.sql.SparkSession session)  { throw new RuntimeException(); }
  /**
   * Clears the active SparkSession for current thread. Subsequent calls to getOrCreate will
   * return the first created context instead of a thread-local override.
   * <p>
   * @since 2.0.0
   */
  public  void clearActiveSession ()  { throw new RuntimeException(); }
  /**
   * Sets the default SparkSession that is returned by the builder.
   * <p>
   * @since 2.0.0
   * @param session (undocumented)
   */
  public  void setDefaultSession (org.apache.spark.sql.SparkSession session)  { throw new RuntimeException(); }
  /**
   * Clears the default SparkSession that is returned by the builder.
   * <p>
   * @since 2.0.0
   */
  public  void clearDefaultSession ()  { throw new RuntimeException(); }
  /**
   * Returns the active SparkSession for the current thread, returned by the builder.
   * <p>
   * @since 2.2.0
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.SparkSession> getActiveSession ()  { throw new RuntimeException(); }
  /**
   * Returns the default SparkSession that is returned by the builder.
   * <p>
   * @since 2.2.0
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.SparkSession> getDefaultSession ()  { throw new RuntimeException(); }
  /** A global SQL listener used for the SQL UI. */
    java.util.concurrent.atomic.AtomicReference<org.apache.spark.sql.execution.ui.SQLListener> sqlListener ()  { throw new RuntimeException(); }
  /** The active SparkSession for the current thread. */
  private  java.lang.InheritableThreadLocal<org.apache.spark.sql.SparkSession> activeThreadSession ()  { throw new RuntimeException(); }
  /** Reference to the root SparkSession. */
  private  java.util.concurrent.atomic.AtomicReference<org.apache.spark.sql.SparkSession> defaultSession ()  { throw new RuntimeException(); }
  private  java.lang.String HIVE_SESSION_STATE_BUILDER_CLASS_NAME ()  { throw new RuntimeException(); }
  private  java.lang.String sessionStateClassName (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  /**
   * Helper method to create an instance of <code>SessionState</code> based on <code>className</code> from conf.
   * The result is either <code>SessionState</code> or a Hive based <code>SessionState</code>.
   * @param className (undocumented)
   * @param sparkSession (undocumented)
   * @return (undocumented)
   */
  private  org.apache.spark.sql.internal.SessionState instantiateSessionState (java.lang.String className, org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  /**
   * @return true if Hive classes can be loaded, otherwise false.
   */
    boolean hiveClassesArePresent ()  { throw new RuntimeException(); }
}
