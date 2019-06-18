package org.apache.spark.status.api.v1;
  interface ApiRequestContext {
  public  javax.servlet.ServletContext servletContext ()  ;
  public  javax.servlet.http.HttpServletRequest httpRequest ()  ;
  public  org.apache.spark.status.api.v1.UIRoot uiRoot ()  ;
  /**
   * Get the spark UI with the given appID, and apply a function
   * to it.  If there is no such app, throw an appropriate exception
   * @param appId (undocumented)
   * @param attemptId (undocumented)
   * @param f (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T withSparkUI (java.lang.String appId, scala.Option<java.lang.String> attemptId, scala.Function1<org.apache.spark.ui.SparkUI, T> f)  ;
}
