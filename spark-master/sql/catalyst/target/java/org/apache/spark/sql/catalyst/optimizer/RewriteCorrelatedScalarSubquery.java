package org.apache.spark.sql.catalyst.optimizer;
/**
 * This rule rewrites correlated {@link ScalarSubquery} expressions into LEFT OUTER joins.
 */
public  class RewriteCorrelatedScalarSubquery {
  /**
   * Extract all correlated scalar subqueries from an expression. The subqueries are collected using
   * the given collector. The expression is rewritten and returned.
   * @param expression (undocumented)
   * @param subqueries (undocumented)
   * @return (undocumented)
   */
  static private <E extends org.apache.spark.sql.catalyst.expressions.Expression> E extractCorrelatedScalarSubqueries (E expression, scala.collection.mutable.ArrayBuffer<org.apache.spark.sql.catalyst.expressions.ScalarSubquery> subqueries)  { throw new RuntimeException(); }
  /**
   * Statically evaluate an expression containing zero or more placeholders, given a set
   * of bindings for placeholder values.
   * @param expr (undocumented)
   * @param bindings (undocumented)
   * @return (undocumented)
   */
  static private  scala.Option<java.lang.Object> evalExpr (org.apache.spark.sql.catalyst.expressions.Expression expr, scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.ExprId, scala.Option<java.lang.Object>> bindings)  { throw new RuntimeException(); }
  /**
   * Statically evaluate an expression containing one or more aggregates on an empty input.
   * @param expr (undocumented)
   * @return (undocumented)
   */
  static private  scala.Option<java.lang.Object> evalAggOnZeroTups (org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
  /**
   * Statically evaluate a scalar subquery on an empty input.
   * <p>
   * <b>WARNING:</b> This method only covers subqueries that pass the checks under
   * {@link org.apache.spark.sql.catalyst.analysis.CheckAnalysis}. If the checks in
   * CheckAnalysis become less restrictive, this method will need to change.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  static private  scala.Option<java.lang.Object> evalSubqueryOnZeroTups (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Split the plan for a scalar subquery into the parts above the innermost query block
   * (first part of returned value), the HAVING clause of the innermost query block
   * (optional second part) and the parts below the HAVING CLAUSE (third part).
   * @param plan (undocumented)
   * @return (undocumented)
   */
  static private  scala.Tuple3<scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>, scala.Option<org.apache.spark.sql.catalyst.plans.logical.Filter>, org.apache.spark.sql.catalyst.plans.logical.Aggregate> splitSubquery (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static public  java.lang.String ALWAYS_TRUE_COLNAME ()  { throw new RuntimeException(); }
  /**
   * Construct a new child plan by left joining the given subqueries to a base plan.
   * @param child (undocumented)
   * @param subqueries (undocumented)
   * @return (undocumented)
   */
  static private  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan constructLeftJoins (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, scala.collection.mutable.ArrayBuffer<org.apache.spark.sql.catalyst.expressions.ScalarSubquery> subqueries)  { throw new RuntimeException(); }
  /**
   * Rewrite {@link Filter}, {@link Project} and {@link Aggregate} plans containing correlated scalar
   * subqueries.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static public  java.lang.String ruleName ()  { throw new RuntimeException(); }
}
