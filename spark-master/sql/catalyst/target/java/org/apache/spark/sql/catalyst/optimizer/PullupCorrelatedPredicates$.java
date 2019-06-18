package org.apache.spark.sql.catalyst.optimizer;
/**
 * Pull out all (outer) correlated predicates from a given subquery. This method removes the
 * correlated predicates from subquery {@link Filter}s and adds the references of these predicates
 * to all intermediate {@link Project} and {@link Aggregate} clauses (if they are missing) in order to
 * be able to evaluate the predicates at the top level.
 * <p>
 * TODO: Look to merge this rule with RewritePredicateSubquery.
 */
public  class PullupCorrelatedPredicates$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PullupCorrelatedPredicates$ MODULE$ = null;
  public   PullupCorrelatedPredicates$ ()  { throw new RuntimeException(); }
  /**
   * Returns the correlated predicates and a updated plan that removes the outer references.
   * @param sub (undocumented)
   * @param outer (undocumented)
   * @return (undocumented)
   */
  private  scala.Tuple2<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>> pullOutCorrelatedPredicates (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan sub, scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> outer)  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan rewriteSubQueries (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> outerPlans)  { throw new RuntimeException(); }
  /**
   * Pull up the correlated predicates and rewrite all subqueries in an operator tree..
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
