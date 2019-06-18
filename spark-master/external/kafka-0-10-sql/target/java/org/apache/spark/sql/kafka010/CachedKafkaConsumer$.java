package org.apache.spark.sql.kafka010;
public  class CachedKafkaConsumer$ implements org.apache.spark.internal.Logging, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CachedKafkaConsumer$ MODULE$ = null;
  public   CachedKafkaConsumer$ ()  { throw new RuntimeException(); }
  private  long UNKNOWN_OFFSET ()  { throw new RuntimeException(); }
  private  java.util.LinkedHashMap<org.apache.spark.sql.kafka010.CachedKafkaConsumer.CacheKey, org.apache.spark.sql.kafka010.CachedKafkaConsumer> cache ()  { throw new RuntimeException(); }
  public  void releaseKafkaConsumer (java.lang.String topic, int partition, java.util.Map<java.lang.String, java.lang.Object> kafkaParams)  { throw new RuntimeException(); }
  /**
   * Removes (and closes) the Kafka Consumer for the given topic, partition and group id.
   * @param topic (undocumented)
   * @param partition (undocumented)
   * @param kafkaParams (undocumented)
   */
  public  void removeKafkaConsumer (java.lang.String topic, int partition, java.util.Map<java.lang.String, java.lang.Object> kafkaParams)  { throw new RuntimeException(); }
  /**
   * Get a cached consumer for groupId, assigned to topic and partition.
   * If matching consumer doesn't already exist, will be created using kafkaParams.
   * @param topic (undocumented)
   * @param partition (undocumented)
   * @param kafkaParams (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.kafka010.CachedKafkaConsumer getOrCreate (java.lang.String topic, int partition, java.util.Map<java.lang.String, java.lang.Object> kafkaParams)  { throw new RuntimeException(); }
  private  void reportDataLoss0 (boolean failOnDataLoss, java.lang.String finalMessage, java.lang.Throwable cause)  { throw new RuntimeException(); }
}
