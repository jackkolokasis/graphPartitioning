package org.apache.spark.status.api.v1;
  class ApplicationListResource {
  public   ApplicationListResource (org.apache.spark.status.api.v1.UIRoot uiRoot)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.status.api.v1.ApplicationInfo> appList (java.util.List<org.apache.spark.status.api.v1.ApplicationStatus> status, org.apache.spark.status.api.v1.SimpleDateParam minDate, org.apache.spark.status.api.v1.SimpleDateParam maxDate, org.apache.spark.status.api.v1.SimpleDateParam minEndDate, org.apache.spark.status.api.v1.SimpleDateParam maxEndDate, java.lang.Integer limit)  { throw new RuntimeException(); }
  private  boolean isAttemptInRange (org.apache.spark.status.api.v1.ApplicationAttemptInfo attempt, org.apache.spark.status.api.v1.SimpleDateParam minStartDate, org.apache.spark.status.api.v1.SimpleDateParam maxStartDate, org.apache.spark.status.api.v1.SimpleDateParam minEndDate, org.apache.spark.status.api.v1.SimpleDateParam maxEndDate, boolean anyRunning)  { throw new RuntimeException(); }
}
