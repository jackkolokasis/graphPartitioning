package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
public  class Range$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Range$ MODULE$ = null;
  public   Range$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.statsEstimation.Range apply (scala.Option<java.lang.Object> min, scala.Option<java.lang.Object> max, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public  boolean isIntersected (org.apache.spark.sql.catalyst.plans.logical.statsEstimation.Range r1, org.apache.spark.sql.catalyst.plans.logical.statsEstimation.Range r2)  { throw new RuntimeException(); }
  /**
   * Intersected results of two ranges. This is only for two overlapped ranges.
   * The outputs are the intersected min/max values.
   * @param r1 (undocumented)
   * @param r2 (undocumented)
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple2<scala.Option<java.lang.Object>, scala.Option<java.lang.Object>> intersect (org.apache.spark.sql.catalyst.plans.logical.statsEstimation.Range r1, org.apache.spark.sql.catalyst.plans.logical.statsEstimation.Range r2, org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * For simplicity we use decimal to unify operations of numeric types, the two methods below
   * are the contract of conversion.
   * @param min (undocumented)
   * @param max (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  private  org.apache.spark.sql.catalyst.plans.logical.statsEstimation.NumericRange toNumericRange (Object min, Object max, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  private  scala.Tuple2<java.lang.Object, java.lang.Object> fromNumericRange (org.apache.spark.sql.catalyst.plans.logical.statsEstimation.NumericRange n, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
}
