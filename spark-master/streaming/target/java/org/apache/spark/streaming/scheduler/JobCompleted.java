package org.apache.spark.streaming.scheduler;
  class JobCompleted implements org.apache.spark.streaming.scheduler.JobSchedulerEvent, scala.Product, scala.Serializable {
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  org.apache.spark.streaming.scheduler.Job job ()  { throw new RuntimeException(); }
  public  long completedTime ()  { throw new RuntimeException(); }
  // not preceding
  public   JobCompleted (org.apache.spark.streaming.scheduler.Job job, long completedTime)  { throw new RuntimeException(); }
}
