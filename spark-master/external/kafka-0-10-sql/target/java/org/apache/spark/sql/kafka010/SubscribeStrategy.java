package org.apache.spark.sql.kafka010;
/**
 * Subscribe to a fixed collection of topics.
 */
public  class SubscribeStrategy implements org.apache.spark.sql.kafka010.ConsumerStrategy, scala.Product, scala.Serializable {
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> topics ()  { throw new RuntimeException(); }
  // not preceding
  public   SubscribeStrategy (scala.collection.Seq<java.lang.String> topics)  { throw new RuntimeException(); }
  public  org.apache.kafka.clients.consumer.Consumer<byte[], byte[]> createConsumer (java.util.Map<java.lang.String, java.lang.Object> kafkaParams)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
