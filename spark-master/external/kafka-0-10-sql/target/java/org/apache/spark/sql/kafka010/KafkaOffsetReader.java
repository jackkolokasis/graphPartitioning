package org.apache.spark.sql.kafka010;
/**
 * This class uses Kafka's own {@link KafkaConsumer} API to read data offsets from Kafka.
 * The {@link ConsumerStrategy} class defines which Kafka topics and partitions should be read
 * by this source. These strategies directly correspond to the different consumption options
 * in. This class is designed to return a configured {@link KafkaConsumer} that is used by the
 * {@link KafkaSource} to query for the offsets. See the docs on
 * {@link org.apache.spark.sql.kafka010.ConsumerStrategy}
 * for more details.
 * <p>
 * Note: This class is not ThreadSafe
 */
  class KafkaOffsetReader implements org.apache.spark.internal.Logging {
  static public  org.apache.spark.sql.types.StructType kafkaSchema ()  { throw new RuntimeException(); }
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
  public   KafkaOffsetReader (org.apache.spark.sql.kafka010.ConsumerStrategy consumerStrategy, java.util.Map<java.lang.String, java.lang.Object> driverKafkaParams, scala.collection.immutable.Map<java.lang.String, java.lang.String> readerOptions, java.lang.String driverGroupIdPrefix)  { throw new RuntimeException(); }
  /**
   * Used to ensure execute fetch operations execute in an UninterruptibleThread
   * @return (undocumented)
   */
  public  java.util.concurrent.ExecutorService kafkaReaderThread ()  { throw new RuntimeException(); }
  public  scala.concurrent.ExecutionContextExecutorService execContext ()  { throw new RuntimeException(); }
  /**
   * Place {@link groupId} and {@link nextId} here so that they are initialized before any consumer is
   * created -- see SPARK-19564.
   * @return (undocumented)
   */
  private  java.lang.String groupId ()  { throw new RuntimeException(); }
  private  int nextId ()  { throw new RuntimeException(); }
  /**
   * A KafkaConsumer used in the driver to query the latest Kafka offsets. This only queries the
   * offsets and never commits them.
   * @return (undocumented)
   */
  protected  org.apache.kafka.clients.consumer.Consumer<byte[], byte[]> consumer ()  { throw new RuntimeException(); }
  private  int maxOffsetFetchAttempts ()  { throw new RuntimeException(); }
  private  long offsetFetchAttemptIntervalMs ()  { throw new RuntimeException(); }
  private  java.lang.String nextGroupId ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  /**
   * Closes the connection to Kafka, and cleans up state.
   */
  public  void close ()  { throw new RuntimeException(); }
  /**
   * @return The Set of TopicPartitions for a given topic
   */
  public  scala.collection.immutable.Set<org.apache.kafka.common.TopicPartition> fetchTopicPartitions ()  { throw new RuntimeException(); }
  /**
   * Resolves the specific offsets based on Kafka seek positions.
   * This method resolves offset value -1 to the latest and -2 to the
   * earliest Kafka seek position.
   * @param partitionOffsets (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<org.apache.kafka.common.TopicPartition, java.lang.Object> fetchSpecificOffsets (scala.collection.immutable.Map<org.apache.kafka.common.TopicPartition, java.lang.Object> partitionOffsets)  { throw new RuntimeException(); }
  /**
   * Fetch the earliest offsets for the topic partitions that are indicated
   * in the {@link ConsumerStrategy}.
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<org.apache.kafka.common.TopicPartition, java.lang.Object> fetchEarliestOffsets ()  { throw new RuntimeException(); }
  /**
   * Fetch the latest offsets for the topic partitions that are indicated
   * in the {@link ConsumerStrategy}.
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<org.apache.kafka.common.TopicPartition, java.lang.Object> fetchLatestOffsets ()  { throw new RuntimeException(); }
  /**
   * Fetch the earliest offsets for specific topic partitions.
   * The return result may not contain some partitions if they are deleted.
   * @param newPartitions (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<org.apache.kafka.common.TopicPartition, java.lang.Object> fetchEarliestOffsets (scala.collection.Seq<org.apache.kafka.common.TopicPartition> newPartitions)  { throw new RuntimeException(); }
  /**
   * This method ensures that the closure is called in an {@link UninterruptibleThread}.
   * This is required when communicating with the {@link KafkaConsumer}. In the case
   * of streaming queries, we are already running in an {@link UninterruptibleThread},
   * however for batch mode this is not the case.
   * @param body (undocumented)
   * @return (undocumented)
   */
  private <T extends java.lang.Object> T runUninterruptibly (scala.Function0<T> body)  { throw new RuntimeException(); }
  /**
   * Helper function that does multiple retries on a body of code that returns offsets.
   * Retries are needed to handle transient failures. For e.g. race conditions between getting
   * assignment and getting position while topics/partitions are deleted can cause NPEs.
   * <p>
   * This method also makes sure <code>body</code> won't be interrupted to workaround a potential issue in
   * <code>KafkaConsumer.poll</code>. (KAFKA-1894)
   * @param body (undocumented)
   * @return (undocumented)
   */
  private  scala.collection.immutable.Map<org.apache.kafka.common.TopicPartition, java.lang.Object> withRetriesWithoutInterrupt (scala.Function0<scala.collection.immutable.Map<org.apache.kafka.common.TopicPartition, java.lang.Object>> body)  { throw new RuntimeException(); }
  /**
   * Create a consumer using the new generated group id. We always use a new consumer to avoid
   * just using a broken consumer to retry on Kafka errors, which likely will fail again.
   * @return (undocumented)
   */
  private  org.apache.kafka.clients.consumer.Consumer<byte[], byte[]> createConsumer ()  { throw new RuntimeException(); }
  private  void resetConsumer ()  { throw new RuntimeException(); }
}
