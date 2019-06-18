package org.apache.spark.scheduler;
public  class TaskDescription$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final TaskDescription$ MODULE$ = null;
  public   TaskDescription$ ()  { throw new RuntimeException(); }
  private  void serializeStringLongMap (scala.collection.mutable.Map<java.lang.String, java.lang.Object> map, java.io.DataOutputStream dataOut)  { throw new RuntimeException(); }
  public  java.nio.ByteBuffer encode (org.apache.spark.scheduler.TaskDescription taskDescription)  { throw new RuntimeException(); }
  private  scala.collection.mutable.HashMap<java.lang.String, java.lang.Object> deserializeStringLongMap (java.io.DataInputStream dataIn)  { throw new RuntimeException(); }
  public  org.apache.spark.scheduler.TaskDescription decode (java.nio.ByteBuffer byteBuffer)  { throw new RuntimeException(); }
}
