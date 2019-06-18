package org.apache.spark.sql.catalyst.analysis;
/**
 * Collection of rules related to hints. The only hint currently available is broadcast join hint.
 * <p>
 * Note that this is separately into two rules because in the future we might introduce new hint
 * rules that have different ordering requirements from broadcast.
 */
public  class ResolveHints {
  /**
   * Removes all the hints, used to remove invalid hints provided by the user.
   * This must be executed after all the other hint rules are executed.
   */
  static public  class RemoveAllHints$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final RemoveAllHints$ MODULE$ = null;
    public   RemoveAllHints$ ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  }
  /**
   * For broadcast hint, we accept "BROADCAST", "BROADCASTJOIN", and "MAPJOIN", and a sequence of
   * relation aliases can be specified in the hint. A broadcast hint plan node will be inserted
   * on top of any relation (that is not aliased differently), subquery, or common table expression
   * that match the specified name.
   * <p>
   * The hint resolution works by recursively traversing down the query plan to find a relation or
   * subquery that matches one of the specified broadcast aliases. The traversal does not go past
   * beyond any existing broadcast hints, subquery aliases.
   * <p>
   * This rule must happen before common table expressions.
   */
  static public  class ResolveBroadcastHints extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
    public   ResolveBroadcastHints (org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
    private  scala.collection.immutable.Set<java.lang.String> BROADCAST_HINT_NAMES ()  { throw new RuntimeException(); }
    public  scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver ()  { throw new RuntimeException(); }
    private  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan applyBroadcastHint (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, scala.collection.immutable.Set<java.lang.String> toBroadcast)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  }
}
