package org.apache.spark.sql.kafka010;
/**
 * Represents the desire to bind to specific offsets. A offset == -1 binds to the
 * latest offset, and offset == -2 binds to the earliest offset.
 */
  class SpecificOffsetRangeLimit implements org.apache.spark.sql.kafka010.KafkaOffsetRangeLimit, scala.Product, scala.Serializable {
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<org.apache.kafka.common.TopicPartition, java.lang.Object> partitionOffsets ()  { throw new RuntimeException(); }
  // not preceding
  public   SpecificOffsetRangeLimit (scala.collection.immutable.Map<org.apache.kafka.common.TopicPartition, java.lang.Object> partitionOffsets)  { throw new RuntimeException(); }
}
