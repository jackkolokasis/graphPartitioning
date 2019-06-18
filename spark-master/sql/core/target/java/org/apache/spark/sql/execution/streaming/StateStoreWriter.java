package org.apache.spark.sql.execution.streaming;
/** An operator that writes to a StateStore. */
public  interface StateStoreWriter extends org.apache.spark.sql.execution.streaming.StatefulOperator {
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  ;
}
