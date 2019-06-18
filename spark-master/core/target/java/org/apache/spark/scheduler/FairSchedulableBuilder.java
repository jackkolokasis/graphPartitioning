package org.apache.spark.scheduler;
  class FairSchedulableBuilder implements org.apache.spark.scheduler.SchedulableBuilder, org.apache.spark.internal.Logging {
  public  org.apache.spark.scheduler.Pool rootPool ()  { throw new RuntimeException(); }
  // not preceding
  public   FairSchedulableBuilder (org.apache.spark.scheduler.Pool rootPool, org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  public  java.lang.String SCHEDULER_ALLOCATION_FILE_PROPERTY ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> schedulerAllocFile ()  { throw new RuntimeException(); }
  public  java.lang.String DEFAULT_SCHEDULER_FILE ()  { throw new RuntimeException(); }
  public  java.lang.String FAIR_SCHEDULER_PROPERTIES ()  { throw new RuntimeException(); }
  public  java.lang.String DEFAULT_POOL_NAME ()  { throw new RuntimeException(); }
  public  java.lang.String MINIMUM_SHARES_PROPERTY ()  { throw new RuntimeException(); }
  public  java.lang.String SCHEDULING_MODE_PROPERTY ()  { throw new RuntimeException(); }
  public  java.lang.String WEIGHT_PROPERTY ()  { throw new RuntimeException(); }
  public  java.lang.String POOL_NAME_PROPERTY ()  { throw new RuntimeException(); }
  public  java.lang.String POOLS_PROPERTY ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value DEFAULT_SCHEDULING_MODE ()  { throw new RuntimeException(); }
  public  int DEFAULT_MINIMUM_SHARE ()  { throw new RuntimeException(); }
  public  int DEFAULT_WEIGHT ()  { throw new RuntimeException(); }
  public  void buildPools ()  { throw new RuntimeException(); }
  private  void buildDefaultPool ()  { throw new RuntimeException(); }
  private  void buildFairSchedulerPool (java.io.InputStream is, java.lang.String fileName)  { throw new RuntimeException(); }
  private  scala.Enumeration.Value getSchedulingModeValue (scala.xml.Node poolNode, java.lang.String poolName, scala.Enumeration.Value defaultValue, java.lang.String fileName)  { throw new RuntimeException(); }
  private  int getIntValue (scala.xml.Node poolNode, java.lang.String poolName, java.lang.String propertyName, int defaultValue, java.lang.String fileName)  { throw new RuntimeException(); }
  public  void addTaskSetManager (org.apache.spark.scheduler.Schedulable manager, java.util.Properties properties)  { throw new RuntimeException(); }
}
