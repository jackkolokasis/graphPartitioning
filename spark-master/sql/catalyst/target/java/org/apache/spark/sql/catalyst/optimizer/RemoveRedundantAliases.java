package org.apache.spark.sql.catalyst.optimizer;
/**
 * Remove redundant aliases from a query plan. A redundant alias is an alias that does not change
 * the name or metadata of a column, and does not deduplicate it.
 */
public  class RemoveRedundantAliases {
  /**
   * Create an attribute mapping from the old to the new attributes. This function will only
   * return the attribute pairs that have changed.
   * @param current (undocumented)
   * @param next (undocumented)
   * @return (undocumented)
   */
  static private  scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Attribute, org.apache.spark.sql.catalyst.expressions.Attribute>> createAttributeMapping (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan current, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan next)  { throw new RuntimeException(); }
  /**
   * Remove the top-level alias from an expression when it is redundant.
   * @param e (undocumented)
   * @param blacklist (undocumented)
   * @return (undocumented)
   */
  static private  org.apache.spark.sql.catalyst.expressions.Expression removeRedundantAlias (org.apache.spark.sql.catalyst.expressions.Expression e, org.apache.spark.sql.catalyst.expressions.AttributeSet blacklist)  { throw new RuntimeException(); }
  /**
   * Remove redundant alias expression from a LogicalPlan and its subtree. A blacklist is used to
   * prevent the removal of seemingly redundant aliases used to deduplicate the input for a (self)
   * join or to prevent the removal of top-level subquery attributes.
   * @param plan (undocumented)
   * @param blacklist (undocumented)
   * @return (undocumented)
   */
  static private  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan removeRedundantAliases (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, org.apache.spark.sql.catalyst.expressions.AttributeSet blacklist)  { throw new RuntimeException(); }
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
