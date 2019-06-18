package org.apache.spark.sql.catalyst.optimizer;
/**
 * Reorder the joins using a dynamic programming algorithm. This implementation is based on the
 * paper: Access Path Selection in a Relational Database Management System.
 * http://www.inf.ed.ac.uk/teaching/courses/adbs/AccessPath.pdf
 * <p>
 * First we put all items (basic joined nodes) into level 0, then we build all two-way joins
 * at level 1 from plans at level 0 (single items), then build all 3-way joins from plans
 * at previous levels (two-way joins and single items), then 4-way joins ... etc, until we
 * build all n-way joins and pick the best plan among them.
 * <p>
 * When building m-way joins, we only keep the best plan (with the lowest cost) for the same set
 * of m items. E.g., for 3-way joins, we keep only the best plan for items {A, B, C} among
 * plans (A J B) J C, (A J C) J B and (B J C) J A.
 * We also prune cartesian product candidates when building a new plan if there exists no join
 * condition involving references from both left and right. This pruning strategy significantly
 * reduces the search space.
 * E.g., given A J B J C J D with join conditions A.k1 = B.k1 and B.k2 = C.k2 and C.k3 = D.k3,
 * plans maintained for each level are as follows:
 * level 0: p({A}), p({B}), p({C}), p({D})
 * level 1: p({A, B}), p({B, C}), p({C, D})
 * level 2: p({A, B, C}), p({B, C, D})
 * level 3: p({A, B, C, D})
 * where p({A, B, C, D}) is the final output plan.
 * <p>
 * For cost evaluation, since physical costs for operators are not available currently, we use
 * cardinalities and sizes to compute costs.
 */
public  class JoinReorderDP {
  /**
   * Partial join order in a specific level.
   * <p>
   * param:  itemIds Set of item ids participating in this partial plan.
   * param:  plan The plan tree with the lowest cost for these items found so far.
   * param:  joinConds Join conditions included in the plan.
   * param:  planCost The cost of this plan tree is the sum of costs of all intermediate joins.
   */
  static public  class JoinPlan implements scala.Product, scala.Serializable {
    public  scala.collection.immutable.Set<java.lang.Object> itemIds ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan ()  { throw new RuntimeException(); }
    public  scala.collection.immutable.Set<org.apache.spark.sql.catalyst.expressions.Expression> joinConds ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.optimizer.Cost planCost ()  { throw new RuntimeException(); }
    // not preceding
    public   JoinPlan (scala.collection.immutable.Set<java.lang.Object> itemIds, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, scala.collection.immutable.Set<org.apache.spark.sql.catalyst.expressions.Expression> joinConds, org.apache.spark.sql.catalyst.optimizer.Cost planCost)  { throw new RuntimeException(); }
    /** Get the cost of the root node of this plan tree. */
    public  org.apache.spark.sql.catalyst.optimizer.Cost rootCost (org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
    public  boolean betterThan (org.apache.spark.sql.catalyst.optimizer.JoinReorderDP.JoinPlan other, org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  }
  static public  class JoinPlan$ extends scala.runtime.AbstractFunction4<scala.collection.immutable.Set<java.lang.Object>, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.collection.immutable.Set<org.apache.spark.sql.catalyst.expressions.Expression>, org.apache.spark.sql.catalyst.optimizer.Cost, org.apache.spark.sql.catalyst.optimizer.JoinReorderDP.JoinPlan> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final JoinPlan$ MODULE$ = null;
    public   JoinPlan$ ()  { throw new RuntimeException(); }
  }
  static public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan search (org.apache.spark.sql.internal.SQLConf conf, scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> items, scala.collection.immutable.Set<org.apache.spark.sql.catalyst.expressions.Expression> conditions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output)  { throw new RuntimeException(); }
  /** Find all possible plans at the next level, based on existing levels. */
  static private  scala.collection.immutable.Map<scala.collection.immutable.Set<java.lang.Object>, org.apache.spark.sql.catalyst.optimizer.JoinReorderDP.JoinPlan> searchLevel (scala.collection.Seq<scala.collection.immutable.Map<scala.collection.immutable.Set<java.lang.Object>, org.apache.spark.sql.catalyst.optimizer.JoinReorderDP.JoinPlan>> existingLevels, org.apache.spark.sql.internal.SQLConf conf, scala.collection.immutable.Set<org.apache.spark.sql.catalyst.expressions.Expression> conditions, org.apache.spark.sql.catalyst.expressions.AttributeSet topOutput)  { throw new RuntimeException(); }
  /**
   * Builds a new JoinPlan when both conditions hold:
   * - the sets of items contained in left and right sides do not overlap.
   * - there exists at least one join condition involving references from both sides.
   * @param oneJoinPlan One side JoinPlan for building a new JoinPlan.
   * @param otherJoinPlan The other side JoinPlan for building a new join node.
   * @param conf SQLConf for statistics computation.
   * @param conditions The overall set of join conditions.
   * @param topOutput The output attributes of the final plan.
   * @return Builds and returns a new JoinPlan if both conditions hold. Otherwise, returns None.
   */
  static private  scala.Option<org.apache.spark.sql.catalyst.optimizer.JoinReorderDP.JoinPlan> buildJoin (org.apache.spark.sql.catalyst.optimizer.JoinReorderDP.JoinPlan oneJoinPlan, org.apache.spark.sql.catalyst.optimizer.JoinReorderDP.JoinPlan otherJoinPlan, org.apache.spark.sql.internal.SQLConf conf, scala.collection.immutable.Set<org.apache.spark.sql.catalyst.expressions.Expression> conditions, org.apache.spark.sql.catalyst.expressions.AttributeSet topOutput)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> splitConjunctivePredicates (org.apache.spark.sql.catalyst.expressions.Expression condition)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> splitDisjunctivePredicates (org.apache.spark.sql.catalyst.expressions.Expression condition)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.Expression replaceAlias (org.apache.spark.sql.catalyst.expressions.Expression condition, org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Expression> aliases)  { throw new RuntimeException(); }
  static protected  boolean canEvaluate (org.apache.spark.sql.catalyst.expressions.Expression expr, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static protected  boolean canEvaluateWithinJoin (org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
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
}
