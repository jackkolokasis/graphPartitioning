package org.apache.spark.sql.internal;
/**
 * Concrete implementation of a {@link SessionStateBuilder}.
 */
public  class SessionStateBuilder extends org.apache.spark.sql.internal.BaseSessionStateBuilder {
  static public  org.apache.spark.sql.SparkSession session ()  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.internal.SessionState> parentState ()  { throw new RuntimeException(); }
  static protected  void mergeSparkConf (org.apache.spark.sql.internal.SQLConf sqlConf, org.apache.spark.SparkConf sparkConf)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.analysis.FunctionRegistry functionRegistry ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.ExperimentalMethods experimentalMethods ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.parser.ParserInterface sqlParser ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.internal.SessionResourceLoader resourceLoader ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.UDFRegistration udfRegistration ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.analysis.Analyzer analyzer ()  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> customResolutionRules ()  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> customPostHocResolutionRules ()  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<scala.Function1<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.runtime.BoxedUnit>> customCheckRules ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.optimizer.Optimizer optimizer ()  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> customOperatorOptimizationRules ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.execution.SparkPlanner planner ()  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.execution.SparkStrategy> customPlanningStrategies ()  { throw new RuntimeException(); }
  static protected  scala.Function1<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.execution.QueryExecution> createQueryExecution ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.streaming.StreamingQueryManager streamingQueryManager ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.util.ExecutionListenerManager listenerManager ()  { throw new RuntimeException(); }
  static protected  scala.Function2<org.apache.spark.sql.SparkSession, org.apache.spark.sql.internal.SessionState, org.apache.spark.sql.internal.SessionState> createClone ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.internal.SessionState build ()  { throw new RuntimeException(); }
  public   SessionStateBuilder (org.apache.spark.sql.SparkSession session, scala.Option<org.apache.spark.sql.internal.SessionState> parentState)  { throw new RuntimeException(); }
  protected  scala.Function2<org.apache.spark.sql.SparkSession, scala.Option<org.apache.spark.sql.internal.SessionState>, org.apache.spark.sql.internal.BaseSessionStateBuilder> newBuilder ()  { throw new RuntimeException(); }
}
