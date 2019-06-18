package org.apache.spark.status.api.v1.streaming;
  class ApiStreamingRootResource {
  static public  org.apache.spark.streaming.ui.StreamingJobProgressListener getListener (org.apache.spark.ui.SparkUI ui)  { throw new RuntimeException(); }
  public   ApiStreamingRootResource (org.apache.spark.ui.SparkUI ui)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.streaming.StreamingStatisticsResource getStreamingStatistics ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.streaming.AllReceiversResource getReceivers ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.streaming.OneReceiverResource getReceiver ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.streaming.AllBatchesResource getBatches ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.streaming.OneBatchResource getBatch ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.streaming.AllOutputOperationsResource getOutputOperations ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.streaming.OneOutputOperationResource getOutputOperation ()  { throw new RuntimeException(); }
}
