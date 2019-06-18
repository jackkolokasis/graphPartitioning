package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
/** Value range of a column. */
public  interface Range {
  public  boolean contains (org.apache.spark.sql.catalyst.expressions.Literal l)  ;
}
