package org.apache.spark.sql.catalyst;
/**
 * A SQLConf that can be used for local testing. This class is only here to minimize the change
 * for ticket SPARK-19944 (moves SQLConf from sql/core to sql/catalyst). This class should
 * eventually be removed (test cases should just create SQLConf and set values appropriately).
 */
public  class SimpleCatalystConf extends org.apache.spark.sql.internal.SQLConf implements scala.Product, scala.Serializable {
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
  static protected  java.util.Map<java.lang.String, java.lang.String> settings ()  { throw new RuntimeException(); }
  static public  int stateStoreMinDeltasForSnapshot ()  { throw new RuntimeException(); }
  static public  scala.Option<java.lang.String> checkpointLocation ()  { throw new RuntimeException(); }
  static public  boolean isUnsupportedOperationCheckEnabled ()  { throw new RuntimeException(); }
  static public  java.lang.String streamingFileCommitProtocolClass ()  { throw new RuntimeException(); }
  static public  boolean fileSinkLogDeletion ()  { throw new RuntimeException(); }
  static public  int fileSinkLogCompactInterval ()  { throw new RuntimeException(); }
  static public  long fileSinkLogCleanupDelay ()  { throw new RuntimeException(); }
  static public  boolean fileSourceLogDeletion ()  { throw new RuntimeException(); }
  static public  int fileSourceLogCompactInterval ()  { throw new RuntimeException(); }
  static public  long fileSourceLogCleanupDelay ()  { throw new RuntimeException(); }
  static public  boolean streamingSchemaInference ()  { throw new RuntimeException(); }
  static public  long streamingPollingDelay ()  { throw new RuntimeException(); }
  static public  long streamingNoDataProgressEventInterval ()  { throw new RuntimeException(); }
  static public  boolean streamingMetricsEnabled ()  { throw new RuntimeException(); }
  static public  int streamingProgressRetention ()  { throw new RuntimeException(); }
  static public  long filesMaxPartitionBytes ()  { throw new RuntimeException(); }
  static public  long filesOpenCostInBytes ()  { throw new RuntimeException(); }
  static public  boolean ignoreCorruptFiles ()  { throw new RuntimeException(); }
  static public  long maxRecordsPerFile ()  { throw new RuntimeException(); }
  static public  boolean useCompression ()  { throw new RuntimeException(); }
  static public  java.lang.String parquetCompressionCodec ()  { throw new RuntimeException(); }
  static public  boolean parquetCacheMetadata ()  { throw new RuntimeException(); }
  static public  boolean parquetVectorizedReaderEnabled ()  { throw new RuntimeException(); }
  static public  int columnBatchSize ()  { throw new RuntimeException(); }
  static public  int numShufflePartitions ()  { throw new RuntimeException(); }
  static public  long targetPostShuffleInputSize ()  { throw new RuntimeException(); }
  static public  boolean adaptiveExecutionEnabled ()  { throw new RuntimeException(); }
  static public  int minNumPostShufflePartitions ()  { throw new RuntimeException(); }
  static public  int minBatchesToRetain ()  { throw new RuntimeException(); }
  static public  boolean parquetFilterPushDown ()  { throw new RuntimeException(); }
  static public  boolean orcFilterPushDown ()  { throw new RuntimeException(); }
  static public  boolean verifyPartitionPath ()  { throw new RuntimeException(); }
  static public  boolean metastorePartitionPruning ()  { throw new RuntimeException(); }
  static public  boolean manageFilesourcePartitions ()  { throw new RuntimeException(); }
  static public  long filesourcePartitionFileCacheSize ()  { throw new RuntimeException(); }
  static public  scala.Enumeration.Value caseSensitiveInferenceMode ()  { throw new RuntimeException(); }
  static public  boolean gatherFastStats ()  { throw new RuntimeException(); }
  static public  boolean optimizerMetadataOnly ()  { throw new RuntimeException(); }
  static public  boolean wholeStageEnabled ()  { throw new RuntimeException(); }
  static public  int wholeStageMaxNumFields ()  { throw new RuntimeException(); }
  static public  boolean wholeStageFallback ()  { throw new RuntimeException(); }
  static public  boolean exchangeReuseEnabled ()  { throw new RuntimeException(); }
  static public  scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver ()  { throw new RuntimeException(); }
  static public  boolean subexpressionEliminationEnabled ()  { throw new RuntimeException(); }
  static public  long autoBroadcastJoinThreshold ()  { throw new RuntimeException(); }
  static public  int limitScaleUpFactor ()  { throw new RuntimeException(); }
  static public  boolean fallBackToHdfsForStatsEnabled ()  { throw new RuntimeException(); }
  static public  boolean preferSortMergeJoin ()  { throw new RuntimeException(); }
  static public  boolean enableRadixSort ()  { throw new RuntimeException(); }
  static public  long defaultSizeInBytes ()  { throw new RuntimeException(); }
  static public  boolean isParquetSchemaMergingEnabled ()  { throw new RuntimeException(); }
  static public  boolean isParquetSchemaRespectSummaries ()  { throw new RuntimeException(); }
  static public  java.lang.String parquetOutputCommitterClass ()  { throw new RuntimeException(); }
  static public  boolean isParquetBinaryAsString ()  { throw new RuntimeException(); }
  static public  boolean isParquetINT96AsTimestamp ()  { throw new RuntimeException(); }
  static public  boolean writeLegacyParquetFormat ()  { throw new RuntimeException(); }
  static public  boolean inMemoryPartitionPruning ()  { throw new RuntimeException(); }
  static public  java.lang.String columnNameOfCorruptRecord ()  { throw new RuntimeException(); }
  static public  int broadcastTimeout ()  { throw new RuntimeException(); }
  static public  java.lang.String defaultDataSourceName ()  { throw new RuntimeException(); }
  static public  boolean convertCTAS ()  { throw new RuntimeException(); }
  static public  boolean partitionColumnTypeInferenceEnabled ()  { throw new RuntimeException(); }
  static public  java.lang.String fileCommitProtocolClass ()  { throw new RuntimeException(); }
  static public  int parallelPartitionDiscoveryThreshold ()  { throw new RuntimeException(); }
  static public  int parallelPartitionDiscoveryParallelism ()  { throw new RuntimeException(); }
  static public  boolean bucketingEnabled ()  { throw new RuntimeException(); }
  static public  boolean dataFrameSelfJoinAutoResolveAmbiguity ()  { throw new RuntimeException(); }
  static public  boolean dataFrameRetainGroupColumns ()  { throw new RuntimeException(); }
  static public  int dataFramePivotMaxValues ()  { throw new RuntimeException(); }
  static public  boolean enableTwoLevelAggMap ()  { throw new RuntimeException(); }
  static public  boolean useObjectHashAggregation ()  { throw new RuntimeException(); }
  static public  int objectAggSortBasedFallbackThreshold ()  { throw new RuntimeException(); }
  static public  boolean variableSubstituteEnabled ()  { throw new RuntimeException(); }
  static public  int variableSubstituteDepth ()  { throw new RuntimeException(); }
  static public  boolean hiveThriftServerSingleSession ()  { throw new RuntimeException(); }
  static public  double ndvMaxError ()  { throw new RuntimeException(); }
  static public  double joinReorderCardWeight ()  { throw new RuntimeException(); }
  static public  int windowExecBufferSpillThreshold ()  { throw new RuntimeException(); }
  static public  int sortMergeJoinExecBufferSpillThreshold ()  { throw new RuntimeException(); }
  static public  int cartesianProductExecBufferSpillThreshold ()  { throw new RuntimeException(); }
  static public  double starSchemaFTRatio ()  { throw new RuntimeException(); }
  static public  void setConf (java.util.Properties props)  { throw new RuntimeException(); }
  static public  void setConfString (java.lang.String key, java.lang.String value)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> void setConf (org.apache.spark.internal.config.ConfigEntry<T> entry, T value)  { throw new RuntimeException(); }
  static public  java.lang.String getConfString (java.lang.String key) throws java.util.NoSuchElementException { throw new RuntimeException(); }
  static public <T extends java.lang.Object> T getConf (org.apache.spark.internal.config.ConfigEntry<T> entry, T defaultValue)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> T getConf (org.apache.spark.internal.config.ConfigEntry<T> entry)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> scala.Option<T> getConf (org.apache.spark.internal.config.OptionalConfigEntry<T> entry)  { throw new RuntimeException(); }
  static public  java.lang.String getConfString (java.lang.String key, java.lang.String defaultValue)  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Map<java.lang.String, java.lang.String> getAllConfs ()  { throw new RuntimeException(); }
  static public  scala.collection.Seq<scala.Tuple3<java.lang.String, java.lang.String, java.lang.String>> getAllDefinedConfs ()  { throw new RuntimeException(); }
  static public  boolean contains (java.lang.String key)  { throw new RuntimeException(); }
  static public  void unsetConf (java.lang.String key)  { throw new RuntimeException(); }
  static public  void unsetConf (org.apache.spark.internal.config.ConfigEntry<?> entry)  { throw new RuntimeException(); }
  static public  void clear ()  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  boolean caseSensitiveAnalysis ()  { throw new RuntimeException(); }
  public  boolean orderByOrdinal ()  { throw new RuntimeException(); }
  public  boolean groupByOrdinal ()  { throw new RuntimeException(); }
  public  int optimizerMaxIterations ()  { throw new RuntimeException(); }
  public  int optimizerInSetConversionThreshold ()  { throw new RuntimeException(); }
  public  int maxCaseBranchesForCodegen ()  { throw new RuntimeException(); }
  public  int tableRelationCacheSize ()  { throw new RuntimeException(); }
  public  boolean runSQLonFile ()  { throw new RuntimeException(); }
  public  boolean crossJoinEnabled ()  { throw new RuntimeException(); }
  public  boolean cboEnabled ()  { throw new RuntimeException(); }
  public  boolean joinReorderEnabled ()  { throw new RuntimeException(); }
  public  int joinReorderDPThreshold ()  { throw new RuntimeException(); }
  public  boolean starSchemaDetection ()  { throw new RuntimeException(); }
  public  java.lang.String warehousePath ()  { throw new RuntimeException(); }
  public  java.lang.String sessionLocalTimeZone ()  { throw new RuntimeException(); }
  public  int maxNestedViewDepth ()  { throw new RuntimeException(); }
  public  boolean constraintPropagationEnabled ()  { throw new RuntimeException(); }
  // not preceding
  public   SimpleCatalystConf (boolean caseSensitiveAnalysis, boolean orderByOrdinal, boolean groupByOrdinal, int optimizerMaxIterations, int optimizerInSetConversionThreshold, int maxCaseBranchesForCodegen, int tableRelationCacheSize, boolean runSQLonFile, boolean crossJoinEnabled, boolean cboEnabled, boolean joinReorderEnabled, int joinReorderDPThreshold, boolean starSchemaDetection, java.lang.String warehousePath, java.lang.String sessionLocalTimeZone, int maxNestedViewDepth, boolean constraintPropagationEnabled)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.SimpleCatalystConf clone ()  { throw new RuntimeException(); }
}
