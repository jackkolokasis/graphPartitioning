package org.apache.spark.sql.kafka010;
/**
 * The provider class for the {@link KafkaSource}. This provider is designed such that it throws
 * IllegalArgumentException when the Kafka Dataset is created, so that it can catch
 * missing options even before the query is started.
 */
  class KafkaSourceProvider implements org.apache.spark.sql.sources.DataSourceRegister, org.apache.spark.sql.sources.StreamSourceProvider, org.apache.spark.sql.sources.StreamSinkProvider, org.apache.spark.sql.sources.RelationProvider, org.apache.spark.sql.sources.CreatableRelationProvider, org.apache.spark.internal.Logging {
  /** Class to conveniently update Kafka config params, while logging the changes */
  private  class ConfigUpdater implements scala.Product, scala.Serializable {
    public  java.lang.String module ()  { throw new RuntimeException(); }
    public  scala.collection.immutable.Map<java.lang.String, java.lang.String> kafkaParams ()  { throw new RuntimeException(); }
    // not preceding
    public   ConfigUpdater (java.lang.String module, scala.collection.immutable.Map<java.lang.String, java.lang.String> kafkaParams)  { throw new RuntimeException(); }
    private  java.util.HashMap<java.lang.String, java.lang.Object> map ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.kafka010.KafkaSourceProvider.ConfigUpdater set (java.lang.String key, java.lang.Object value)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.kafka010.KafkaSourceProvider.ConfigUpdater setIfUnset (java.lang.String key, java.lang.Object value)  { throw new RuntimeException(); }
    public  java.util.Map<java.lang.String, java.lang.Object> build ()  { throw new RuntimeException(); }
  }
  private  class ConfigUpdater$ extends scala.runtime.AbstractFunction2<java.lang.String, scala.collection.immutable.Map<java.lang.String, java.lang.String>, org.apache.spark.sql.kafka010.KafkaSourceProvider.ConfigUpdater> implements scala.Serializable {
    public   ConfigUpdater$ ()  { throw new RuntimeException(); }
  }
  static private  scala.collection.immutable.Set<java.lang.String> STRATEGY_OPTION_KEYS ()  { throw new RuntimeException(); }
  static   java.lang.String STARTING_OFFSETS_OPTION_KEY ()  { throw new RuntimeException(); }
  static   java.lang.String ENDING_OFFSETS_OPTION_KEY ()  { throw new RuntimeException(); }
  static private  java.lang.String FAIL_ON_DATA_LOSS_OPTION_KEY ()  { throw new RuntimeException(); }
  static public  java.lang.String TOPIC_OPTION_KEY ()  { throw new RuntimeException(); }
  static private  java.lang.String deserClassName ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.kafka010.KafkaOffsetRangeLimit getKafkaOffsetRangeLimit (scala.collection.immutable.Map<java.lang.String, java.lang.String> params, java.lang.String offsetOptionKey, org.apache.spark.sql.kafka010.KafkaOffsetRangeLimit defaultOffsets)  { throw new RuntimeException(); }
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
  public   KafkaSourceProvider ()  { throw new RuntimeException(); }
  public  java.lang.String shortName ()  { throw new RuntimeException(); }
  /**
   * Returns the name and schema of the source. In addition, it also verifies whether the options
   * are correct and sufficient to create the {@link KafkaSource} when the query is started.
   * @param sqlContext (undocumented)
   * @param schema (undocumented)
   * @param providerName (undocumented)
   * @param parameters (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple2<java.lang.String, org.apache.spark.sql.types.StructType> sourceSchema (org.apache.spark.sql.SQLContext sqlContext, scala.Option<org.apache.spark.sql.types.StructType> schema, java.lang.String providerName, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.Source createSource (org.apache.spark.sql.SQLContext sqlContext, java.lang.String metadataPath, scala.Option<org.apache.spark.sql.types.StructType> schema, java.lang.String providerName, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  /**
   * Returns a new base relation with the given parameters.
   * <p>
   * @note The parameters' keywords are case insensitive and this insensitivity is enforced
   *       by the Map that is passed to the function.
   * @param sqlContext (undocumented)
   * @param parameters (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.sources.BaseRelation createRelation (org.apache.spark.sql.SQLContext sqlContext, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.Sink createSink (org.apache.spark.sql.SQLContext sqlContext, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, scala.collection.Seq<java.lang.String> partitionColumns, org.apache.spark.sql.streaming.OutputMode outputMode)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.BaseRelation createRelation (org.apache.spark.sql.SQLContext outerSQLContext, org.apache.spark.sql.SaveMode mode, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> data)  { throw new RuntimeException(); }
  private  scala.collection.immutable.Map<java.lang.String, java.lang.String> kafkaParamsForProducer (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  private  java.util.Map<java.lang.String, java.lang.Object> kafkaParamsForDriver (scala.collection.immutable.Map<java.lang.String, java.lang.String> specifiedKafkaParams)  { throw new RuntimeException(); }
  private  java.util.Map<java.lang.String, java.lang.Object> kafkaParamsForExecutors (scala.collection.immutable.Map<java.lang.String, java.lang.String> specifiedKafkaParams, java.lang.String uniqueGroupId)  { throw new RuntimeException(); }
  private  scala.Product strategy (scala.collection.immutable.Map<java.lang.String, java.lang.String> caseInsensitiveParams)  { throw new RuntimeException(); }
  private  boolean failOnDataLoss (scala.collection.immutable.Map<java.lang.String, java.lang.String> caseInsensitiveParams)  { throw new RuntimeException(); }
  private  void validateGeneralOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  private  void validateStreamOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> caseInsensitiveParams)  { throw new RuntimeException(); }
  private  void validateBatchOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> caseInsensitiveParams)  { throw new RuntimeException(); }
}
