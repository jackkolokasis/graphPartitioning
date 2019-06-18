package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
public  class JoinEstimation$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final JoinEstimation$ MODULE$ = null;
  public   JoinEstimation$ ()  { throw new RuntimeException(); }
  /**
   * Estimate statistics after join. Return <code>None</code> if the join type is not supported, or we don't
   * have enough statistics for estimation.
   * @param conf (undocumented)
   * @param join (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.Statistics> estimate (org.apache.spark.sql.internal.SQLConf conf, org.apache.spark.sql.catalyst.plans.logical.Join join)  { throw new RuntimeException(); }
}
