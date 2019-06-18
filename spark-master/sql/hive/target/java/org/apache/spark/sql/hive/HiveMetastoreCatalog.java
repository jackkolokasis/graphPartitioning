package org.apache.spark.sql.hive;
/**
 * Legacy catalog for interacting with the Hive metastore.
 * <p>
 * This is still used for things like creating data source tables, but in the future will be
 * cleaned up to integrate more nicely with {@link HiveExternalCatalog}.
 */
  class HiveMetastoreCatalog implements org.apache.spark.internal.Logging {
  /**
   * When scanning or writing to non-partitioned Metastore Parquet tables, convert them to Parquet
   * data source relations for better performance.
   */
  public  class ParquetConversions$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
    public   ParquetConversions$ ()  { throw new RuntimeException(); }
    private  boolean shouldConvertMetastoreParquet (org.apache.spark.sql.catalyst.catalog.CatalogRelation relation)  { throw new RuntimeException(); }
    private  org.apache.spark.sql.execution.datasources.LogicalRelation convertToParquetRelation (org.apache.spark.sql.catalyst.catalog.CatalogRelation relation)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  }
  /**
   * When scanning Metastore ORC tables, convert them to ORC data source relations
   * for better performance.
   */
  public  class OrcConversions$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
    public   OrcConversions$ ()  { throw new RuntimeException(); }
    private  boolean shouldConvertMetastoreOrc (org.apache.spark.sql.catalyst.catalog.CatalogRelation relation)  { throw new RuntimeException(); }
    private  org.apache.spark.sql.execution.datasources.LogicalRelation convertToOrcRelation (org.apache.spark.sql.catalyst.catalog.CatalogRelation relation)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  }
  static public  org.apache.spark.sql.types.StructType mergeWithMetastoreSchema (org.apache.spark.sql.types.StructType metastoreSchema, org.apache.spark.sql.types.StructType inferredSchema)  { throw new RuntimeException(); }
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
  public   HiveMetastoreCatalog (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  private  org.apache.spark.sql.internal.SessionState sessionState ()  { throw new RuntimeException(); }
  private  com.google.common.cache.Cache<org.apache.spark.sql.catalyst.QualifiedTableName, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> tableRelationCache ()  { throw new RuntimeException(); }
  private  java.lang.String getCurrentDatabase ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.QualifiedTableName getQualifiedTableName (org.apache.spark.sql.catalyst.TableIdentifier tableIdent)  { throw new RuntimeException(); }
  /** These locks guard against multiple attempts to instantiate a table, which wastes memory. */
  private  com.google.common.util.concurrent.Striped<java.util.concurrent.locks.Lock> tableCreationLocks ()  { throw new RuntimeException(); }
  /** Acquires a lock on the table cache for the duration of `f`. */
  private <A extends java.lang.Object> A withTableCreationLock (org.apache.spark.sql.catalyst.QualifiedTableName tableName, scala.Function0<A> f)  { throw new RuntimeException(); }
  public  java.lang.String hiveDefaultTableFilePath (org.apache.spark.sql.catalyst.TableIdentifier tableIdent)  { throw new RuntimeException(); }
  private  scala.Option<org.apache.spark.sql.execution.datasources.LogicalRelation> getCached (org.apache.spark.sql.catalyst.QualifiedTableName tableIdentifier, scala.collection.Seq<org.apache.hadoop.fs.Path> pathsInMetastore, org.apache.spark.sql.types.StructType schemaInMetastore, java.lang.Class<? extends org.apache.spark.sql.execution.datasources.FileFormat> expectedFileFormat, scala.Option<org.apache.spark.sql.types.StructType> partitionSchema)  { throw new RuntimeException(); }
  private  org.apache.spark.sql.execution.datasources.LogicalRelation convertToLogicalRelation (org.apache.spark.sql.catalyst.catalog.CatalogRelation relation, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, java.lang.Class<? extends org.apache.spark.sql.execution.datasources.FileFormat> fileFormatClass, java.lang.String fileType)  { throw new RuntimeException(); }
  private  scala.Tuple2<org.apache.spark.sql.types.StructType, org.apache.spark.sql.catalyst.catalog.CatalogTable> inferIfNeeded (org.apache.spark.sql.catalyst.catalog.CatalogRelation relation, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.execution.datasources.FileFormat fileFormat, scala.Option<org.apache.spark.sql.execution.datasources.FileIndex> fileIndexOpt)  { throw new RuntimeException(); }
  private  void updateCatalogSchema (org.apache.spark.sql.catalyst.TableIdentifier identifier, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Accessor for nested Scala object
   * @return (undocumented)
   */
  public  org.apache.spark.sql.hive.HiveMetastoreCatalog.ParquetConversions$ ParquetConversions ()  { throw new RuntimeException(); }
  /**
   * Accessor for nested Scala object
   * @return (undocumented)
   */
  public  org.apache.spark.sql.hive.HiveMetastoreCatalog.OrcConversions$ OrcConversions ()  { throw new RuntimeException(); }
}
