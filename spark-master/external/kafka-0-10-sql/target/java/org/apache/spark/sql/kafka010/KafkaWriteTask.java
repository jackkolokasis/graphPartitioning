package org.apache.spark.sql.kafka010;
/**
 * A simple trait for writing out data in a single Spark task, without any concerns about how
 * to commit or abort tasks. Exceptions thrown by the implementation of this class will
 * automatically trigger task aborts.
 */
  class KafkaWriteTask {
  public   KafkaWriteTask (java.util.Map<java.lang.String, java.lang.Object> producerConfiguration, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema, scala.Option<java.lang.String> topic)  { throw new RuntimeException(); }
  private  java.lang.Exception failedWrite ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.expressions.UnsafeProjection projection ()  { throw new RuntimeException(); }
  private  org.apache.kafka.clients.producer.KafkaProducer<byte[], byte[]> producer ()  { throw new RuntimeException(); }
  /**
   * Writes key value data out to topics.
   * @param iterator (undocumented)
   */
  public  void execute (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> iterator)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.expressions.UnsafeProjection createProjection ()  { throw new RuntimeException(); }
  private  void checkForErrors ()  { throw new RuntimeException(); }
}
