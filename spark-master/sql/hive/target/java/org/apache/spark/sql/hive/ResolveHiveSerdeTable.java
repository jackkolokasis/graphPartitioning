package org.apache.spark.sql.hive;
/**
 * Determine the database, serde/format and schema of the Hive serde table, according to the storage
 * properties.
 */
public  class ResolveHiveSerdeTable extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  public   ResolveHiveSerdeTable (org.apache.spark.sql.SparkSession session)  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.catalog.CatalogTable determineHiveSerde (org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
