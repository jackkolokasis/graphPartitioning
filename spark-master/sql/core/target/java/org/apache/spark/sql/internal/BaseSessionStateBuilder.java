package org.apache.spark.sql.internal;
/**
 * Builder class that coordinates construction of a new {@link SessionState}.
 * <p>
 * The builder explicitly defines all components needed by the session state, and creates a session
 * state when <code>build</code> is called. Components should only be initialized once. This is not a problem
 * for most components as they are only used in the <code>build</code> function. However some components
 * (<code>conf</code>, <code>catalog</code>, <code>functionRegistry</code>, <code>experimentalMethods</code> &amp; <code>sqlParser</code>) are as dependencies
 * for other components and are shared as a result. These components are defined as lazy vals to
 * make sure the component is created only once.
 * <p>
 * A developer can modify the builder by providing custom versions of components, or by using the
 * hooks provided for the analyzer, optimizer &amp; planner. There are some dependencies between the
 * components (they are documented per dependency), a developer should respect these when making
 * modifications in order to prevent initialization problems.
 * <p>
 * A parent {@link SessionState} can be used to initialize the new {@link SessionState}. The new session
 * state will clone the parent sessions state's <code>conf</code>, <code>functionRegistry</code>, <code>experimentalMethods</code>
 * and <code>catalog</code> fields. Note that the state is cloned when <code>build</code> is called, and not before.
 */
public abstract class BaseSessionStateBuilder {
  public  org.apache.spark.sql.SparkSession session ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.internal.SessionState> parentState ()  { throw new RuntimeException(); }
  // not preceding
  public   BaseSessionStateBuilder (org.apache.spark.sql.SparkSession session, scala.Option<org.apache.spark.sql.internal.SessionState> parentState)  { throw new RuntimeException(); }
  /**
   * Function that produces a new instance of the SessionStateBuilder. This is used by the
   * {@link SessionState}'s clone functionality. Make sure to override this when implementing your own
   * {@link SessionStateBuilder}.
   * @return (undocumented)
   */
  protected abstract  scala.Function2<org.apache.spark.sql.SparkSession, scala.Option<org.apache.spark.sql.internal.SessionState>, org.apache.spark.sql.internal.BaseSessionStateBuilder> newBuilder ()  ;
  /**
   * Extract entries from <code>SparkConf</code> and put them in the <code>SQLConf</code>
   * @param sqlConf (undocumented)
   * @param sparkConf (undocumented)
   */
  protected  void mergeSparkConf (org.apache.spark.sql.internal.SQLConf sqlConf, org.apache.spark.SparkConf sparkConf)  { throw new RuntimeException(); }
  /**
   * SQL-specific key-value configurations.
   * <p>
   * These either get cloned from a pre-existing instance or newly created. The conf is always
   * merged with its {@link SparkConf}.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
  /**
   * Internal catalog managing functions registered by the user.
   * <p>
   * This either gets cloned from a pre-existing version or cloned from the built-in registry.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.analysis.FunctionRegistry functionRegistry ()  { throw new RuntimeException(); }
  /**
   * Experimental methods that can be used to define custom optimization rules and custom planning
   * strategies.
   * <p>
   * This either gets cloned from a pre-existing version or newly created.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.ExperimentalMethods experimentalMethods ()  { throw new RuntimeException(); }
  /**
   * Parser that extracts expressions, plans, table identifiers etc. from SQL texts.
   * <p>
   * Note: this depends on the <code>conf</code> field.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.parser.ParserInterface sqlParser ()  { throw new RuntimeException(); }
  /**
   * ResourceLoader that is used to load function resources and jars.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.internal.SessionResourceLoader resourceLoader ()  { throw new RuntimeException(); }
  /**
   * Catalog for managing table and database states. If there is a pre-existing catalog, the state
   * of that catalog (temp tables &amp; current database) will be copied into the new catalog.
   * <p>
   * Note: this depends on the <code>conf</code>, <code>functionRegistry</code> and <code>sqlParser</code> fields.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog ()  { throw new RuntimeException(); }
  /**
   * Interface exposed to the user for registering user-defined functions.
   * <p>
   * Note 1: The user-defined functions must be deterministic.
   * Note 2: This depends on the <code>functionRegistry</code> field.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.UDFRegistration udfRegistration ()  { throw new RuntimeException(); }
  /**
   * Logical query plan analyzer for resolving unresolved attributes and relations.
   * <p>
   * Note: this depends on the <code>conf</code> and <code>catalog</code> fields.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.analysis.Analyzer analyzer ()  { throw new RuntimeException(); }
  /**
   * Custom resolution rules to add to the Analyzer. Prefer overriding this instead of creating
   * your own Analyzer.
   * <p>
   * Note that this may NOT depend on the <code>analyzer</code> function.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> customResolutionRules ()  { throw new RuntimeException(); }
  /**
   * Custom post resolution rules to add to the Analyzer. Prefer overriding this instead of
   * creating your own Analyzer.
   * <p>
   * Note that this may NOT depend on the <code>analyzer</code> function.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> customPostHocResolutionRules ()  { throw new RuntimeException(); }
  /**
   * Custom check rules to add to the Analyzer. Prefer overriding this instead of creating
   * your own Analyzer.
   * <p>
   * Note that this may NOT depend on the <code>analyzer</code> function.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<scala.Function1<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.runtime.BoxedUnit>> customCheckRules ()  { throw new RuntimeException(); }
  /**
   * Logical query plan optimizer.
   * <p>
   * Note: this depends on the <code>conf</code>, <code>catalog</code> and <code>experimentalMethods</code> fields.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.optimizer.Optimizer optimizer ()  { throw new RuntimeException(); }
  /**
   * Custom operator optimization rules to add to the Optimizer. Prefer overriding this instead
   * of creating your own Optimizer.
   * <p>
   * Note that this may NOT depend on the <code>optimizer</code> function.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> customOperatorOptimizationRules ()  { throw new RuntimeException(); }
  /**
   * Planner that converts optimized logical plans to physical plans.
   * <p>
   * Note: this depends on the <code>conf</code> and <code>experimentalMethods</code> fields.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.execution.SparkPlanner planner ()  { throw new RuntimeException(); }
  /**
   * Custom strategies to add to the planner. Prefer overriding this instead of creating
   * your own Planner.
   * <p>
   * Note that this may NOT depend on the <code>planner</code> function.
   * @return (undocumented)
   */
  protected  scala.collection.Seq<org.apache.spark.sql.execution.SparkStrategy> customPlanningStrategies ()  { throw new RuntimeException(); }
  /**
   * Create a query execution object.
   * @return (undocumented)
   */
  protected  scala.Function1<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.execution.QueryExecution> createQueryExecution ()  { throw new RuntimeException(); }
  /**
   * Interface to start and stop streaming queries.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.streaming.StreamingQueryManager streamingQueryManager ()  { throw new RuntimeException(); }
  /**
   * An interface to register custom {@link org.apache.spark.sql.util.QueryExecutionListener}s
   * that listen for execution metrics.
   * <p>
   * This gets cloned from parent if available, otherwise is a new instance is created.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.util.ExecutionListenerManager listenerManager ()  { throw new RuntimeException(); }
  /**
   * Function used to make clones of the session state.
   * @return (undocumented)
   */
  protected  scala.Function2<org.apache.spark.sql.SparkSession, org.apache.spark.sql.internal.SessionState, org.apache.spark.sql.internal.SessionState> createClone ()  { throw new RuntimeException(); }
  /**
   * Build the {@link SessionState}.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.internal.SessionState build ()  { throw new RuntimeException(); }
}
