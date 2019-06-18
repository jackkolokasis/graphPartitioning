package org.apache.spark.sql.execution;
public  class SparkOptimizer extends org.apache.spark.sql.catalyst.optimizer.Optimizer {
  public   SparkOptimizer (org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog, org.apache.spark.sql.internal.SQLConf conf, org.apache.spark.sql.ExperimentalMethods experimentalMethods)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.RuleExecutor<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>.Batch> batches ()  { throw new RuntimeException(); }
  /**
   * Optimization batches that are executed after the regular optimization batches, but before the
   * batch executing the {@link ExperimentalMethods} optimizer rules. This hook can be used to add
   * custom optimizer batches to the Spark optimizer.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.RuleExecutor<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>.Batch> postHocOptimizationBatches ()  { throw new RuntimeException(); }
}
