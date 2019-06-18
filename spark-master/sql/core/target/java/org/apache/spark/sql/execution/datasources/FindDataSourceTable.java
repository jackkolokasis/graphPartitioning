package org.apache.spark.sql.execution.datasources;
/**
 * Replaces {@link CatalogRelation} with data source table if its table provider is not hive.
 */
public  class FindDataSourceTable extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  public   FindDataSourceTable (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan readDataSourceTable (org.apache.spark.sql.catalyst.catalog.CatalogRelation r)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
