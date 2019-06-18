package org.apache.spark.status.api.v1;
/**
 * Main entry point for serving spark application metrics as json, using JAX-RS.
 * <p>
 * Each resource should have endpoints that return **public** classes defined in api.scala.  Mima
 * binary compatibility checks ensure that we don't inadvertently make changes that break the api.
 * The returned objects are automatically converted to json by jackson with JacksonMessageWriter.
 * In addition, there are a number of tests in HistoryServerSuite that compare the json to "golden
 * files".  Any changes and additions should be reflected there as well -- see the notes in
 * HistoryServerSuite.
 */
  class ApiRootResource implements org.apache.spark.status.api.v1.ApiRequestContext {
  static public  org.eclipse.jetty.servlet.ServletContextHandler getServletHandler (org.apache.spark.status.api.v1.UIRoot uiRoot)  { throw new RuntimeException(); }
  static protected  javax.servlet.ServletContext servletContext ()  { throw new RuntimeException(); }
  static protected  void servletContext_$eq (javax.servlet.ServletContext x$1)  { throw new RuntimeException(); }
  static protected  javax.servlet.http.HttpServletRequest httpRequest ()  { throw new RuntimeException(); }
  static protected  void httpRequest_$eq (javax.servlet.http.HttpServletRequest x$1)  { throw new RuntimeException(); }
  static public  org.apache.spark.status.api.v1.UIRoot uiRoot ()  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> T withSparkUI (java.lang.String appId, scala.Option<java.lang.String> attemptId, scala.Function1<org.apache.spark.ui.SparkUI, T> f)  { throw new RuntimeException(); }
  public   ApiRootResource ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.ApplicationListResource getApplicationList ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.OneApplicationResource getApplication ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.AllJobsResource getJobs (java.lang.String appId, java.lang.String attemptId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.AllJobsResource getJobs (java.lang.String appId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.OneJobResource getJob (java.lang.String appId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.OneJobResource getJob (java.lang.String appId, java.lang.String attemptId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.ExecutorListResource getExecutors (java.lang.String appId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.AllExecutorListResource getAllExecutors (java.lang.String appId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.ExecutorListResource getExecutors (java.lang.String appId, java.lang.String attemptId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.AllExecutorListResource getAllExecutors (java.lang.String appId, java.lang.String attemptId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.AllStagesResource getStages (java.lang.String appId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.AllStagesResource getStages (java.lang.String appId, java.lang.String attemptId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.OneStageResource getStage (java.lang.String appId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.OneStageResource getStage (java.lang.String appId, java.lang.String attemptId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.AllRDDResource getRdds (java.lang.String appId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.AllRDDResource getRdds (java.lang.String appId, java.lang.String attemptId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.OneRDDResource getRdd (java.lang.String appId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.OneRDDResource getRdd (java.lang.String appId, java.lang.String attemptId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.EventLogDownloadResource getEventLogs (java.lang.String appId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.EventLogDownloadResource getEventLogs (java.lang.String appId, java.lang.String attemptId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.VersionResource getVersion ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.ApplicationEnvironmentResource getEnvironment (java.lang.String appId)  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.ApplicationEnvironmentResource getEnvironment (java.lang.String appId, java.lang.String attemptId)  { throw new RuntimeException(); }
}
