package org.apache.spark.sql.catalyst.analysis;
/**
 * An analyzer rule that replaces {@link UnresolvedInlineTable} with {@link LocalRelation}.
 */
public  class ResolveInlineTables extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements scala.Product, scala.Serializable {
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
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
  // not preceding
  public   ResolveInlineTables (org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Validates the input data dimension:
   * 1. All rows have the same cardinality.
   * 2. The number of column aliases defined is consistent with the number of columns in data.
   * <p>
   * This is package visible for unit testing.
   * @param table (undocumented)
   */
    void validateInputDimension (org.apache.spark.sql.catalyst.analysis.UnresolvedInlineTable table)  { throw new RuntimeException(); }
  /**
   * Validates that all inline table data are valid expressions that can be evaluated
   * (in this they must be foldable).
   * <p>
   * This is package visible for unit testing.
   * @param table (undocumented)
   */
    void validateInputEvaluable (org.apache.spark.sql.catalyst.analysis.UnresolvedInlineTable table)  { throw new RuntimeException(); }
  /**
   * Convert a valid (with right shape and foldable inputs) {@link UnresolvedInlineTable}
   * into a {@link LocalRelation}.
   * <p>
   * This function attempts to coerce inputs into consistent types.
   * <p>
   * This is package visible for unit testing.
   * @param table (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.catalyst.plans.logical.LocalRelation convert (org.apache.spark.sql.catalyst.analysis.UnresolvedInlineTable table)  { throw new RuntimeException(); }
}
