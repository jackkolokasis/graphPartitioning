package org.apache.spark.sql.catalyst.optimizer;
/**
 * Remove redundant aliases from a query plan. A redundant alias is an alias that does not change
 * the name or metadata of a column, and does not deduplicate it.
 */
public  class RemoveRedundantAliases$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RemoveRedundantAliases$ MODULE$ = null;
  public   RemoveRedundantAliases$ ()  { throw new RuntimeException(); }
  /**
   * Create an attribute mapping from the old to the new attributes. This function will only
   * return the attribute pairs that have changed.
   * @param current (undocumented)
   * @param next (undocumented)
   * @return (undocumented)
   */
  private  scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Attribute, org.apache.spark.sql.catalyst.expressions.Attribute>> createAttributeMapping (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan current, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan next)  { throw new RuntimeException(); }
  /**
   * Remove the top-level alias from an expression when it is redundant.
   * @param e (undocumented)
   * @param blacklist (undocumented)
   * @return (undocumented)
   */
  private  org.apache.spark.sql.catalyst.expressions.Expression removeRedundantAlias (org.apache.spark.sql.catalyst.expressions.Expression e, org.apache.spark.sql.catalyst.expressions.AttributeSet blacklist)  { throw new RuntimeException(); }
  /**
   * Remove redundant alias expression from a LogicalPlan and its subtree. A blacklist is used to
   * prevent the removal of seemingly redundant aliases used to deduplicate the input for a (self)
   * join or to prevent the removal of top-level subquery attributes.
   * @param plan (undocumented)
   * @param blacklist (undocumented)
   * @return (undocumented)
   */
  private  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan removeRedundantAliases (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, org.apache.spark.sql.catalyst.expressions.AttributeSet blacklist)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
