package org.apache.spark.sql.execution;
/**
 * Physical plan node for scanning data from HadoopFsRelations.
 * <p>
 * param:  relation The file-based relation to scan.
 * param:  output Output attributes of the scan.
 * param:  outputSchema Output schema of the scan.
 * param:  partitionFilters Predicates to use for partition pruning.
 * param:  dataFilters Filters on non-partition columns.
 * param:  metastoreTableIdentifier identifier for the table in the metastore.
 */
public  class FileSourceScanExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.DataSourceScanExec, org.apache.spark.sql.execution.ColumnarBatchScan, scala.Product, scala.Serializable {
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.trees.Origin origin ()  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Set<org.apache.spark.sql.catalyst.trees.TreeNode<?>> containsChild ()  { throw new RuntimeException(); }
  static public  int hashCode ()  { throw new RuntimeException(); }
  static public  boolean fastEquals (org.apache.spark.sql.catalyst.trees.TreeNode<?> other)  { throw new RuntimeException(); }
  static public  scala.Option<BaseType> find (scala.Function1<BaseType, java.lang.Object> f)  { throw new RuntimeException(); }
  static public  void foreach (scala.Function1<BaseType, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  static public  void foreachUp (scala.Function1<BaseType, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> scala.collection.Seq<A> map (scala.Function1<BaseType, A> f)  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> scala.collection.Seq<A> flatMap (scala.Function1<BaseType, scala.collection.TraversableOnce<A>> f)  { throw new RuntimeException(); }
  static public <B extends java.lang.Object> scala.collection.Seq<B> collect (scala.PartialFunction<BaseType, B> pf)  { throw new RuntimeException(); }
  static public  scala.collection.Seq<BaseType> collectLeaves ()  { throw new RuntimeException(); }
  static public <B extends java.lang.Object> scala.Option<B> collectFirst (scala.PartialFunction<BaseType, B> pf)  { throw new RuntimeException(); }
  static protected <B extends java.lang.Object> java.lang.Object mapProductIterator (scala.Function1<java.lang.Object, B> f, scala.reflect.ClassTag<B> evidence$1)  { throw new RuntimeException(); }
  static public  BaseType withNewChildren (scala.collection.Seq<BaseType> newChildren)  { throw new RuntimeException(); }
  static public  BaseType transform (scala.PartialFunction<BaseType, BaseType> rule)  { throw new RuntimeException(); }
  static public  BaseType transformDown (scala.PartialFunction<BaseType, BaseType> rule)  { throw new RuntimeException(); }
  static public  BaseType transformUp (scala.PartialFunction<BaseType, BaseType> rule)  { throw new RuntimeException(); }
  static public  BaseType mapChildren (scala.Function1<BaseType, BaseType> f)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<java.lang.Object> otherCopyArgs ()  { throw new RuntimeException(); }
  static protected  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
  static public  java.lang.String argString ()  { throw new RuntimeException(); }
  static public  java.lang.String verboseStringWithSuffix ()  { throw new RuntimeException(); }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  static public  java.lang.String treeString ()  { throw new RuntimeException(); }
  static public  java.lang.String numberedTreeString ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.trees.TreeNode<?> apply (int number)  { throw new RuntimeException(); }
  static public  BaseType p (int number)  { throw new RuntimeException(); }
  static public  scala.collection.mutable.StringBuilder generateTreeString (int depth, scala.collection.Seq<java.lang.Object> lastChildren, scala.collection.mutable.StringBuilder builder, boolean verbose, java.lang.String prefix, boolean addSuffix)  { throw new RuntimeException(); }
  static public  java.lang.String asCode ()  { throw new RuntimeException(); }
  static public  java.lang.String toJSON ()  { throw new RuntimeException(); }
  static public  java.lang.String prettyJson ()  { throw new RuntimeException(); }
  static protected  scala.collection.immutable.List<scala.Tuple2<java.lang.String, org.json4s.JsonAST.JValue>> jsonFields ()  { throw new RuntimeException(); }
  static public  boolean treeString$default$2 ()  { throw new RuntimeException(); }
  static public  java.lang.String generateTreeString$default$5 ()  { throw new RuntimeException(); }
  static public  boolean generateTreeString$default$6 ()  { throw new RuntimeException(); }
  static protected  scala.collection.immutable.Set<org.apache.spark.sql.catalyst.expressions.Expression> getRelevantConstraints (scala.collection.immutable.Set<org.apache.spark.sql.catalyst.expressions.Expression> constraints)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.ExpressionSet constraints ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.catalyst.expressions.ExpressionSet getConstraints (boolean constraintPropagationEnabled)  { throw new RuntimeException(); }
  static protected  scala.collection.immutable.Set<org.apache.spark.sql.catalyst.expressions.Expression> validConstraints ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSet outputSet ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSet inputSet ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSet missingInput ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.QueryPlan<PlanType> transformExpressions (scala.PartialFunction<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> rule)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.QueryPlan<PlanType> transformExpressionsDown (scala.PartialFunction<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> rule)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.QueryPlan<PlanType> transformExpressionsUp (scala.PartialFunction<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> rule)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.QueryPlan<PlanType> mapExpressions (scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> f)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.QueryPlan<PlanType> transformAllExpressions (scala.PartialFunction<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> rule)  { throw new RuntimeException(); }
  static public final  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  static public  java.lang.String schemaString ()  { throw new RuntimeException(); }
  static public  void printSchema ()  { throw new RuntimeException(); }
  static protected  java.lang.String statePrefix ()  { throw new RuntimeException(); }
  static public  scala.collection.Seq<PlanType> subqueries ()  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.QueryPlan<?>> innerChildren ()  { throw new RuntimeException(); }
  static protected  PlanType canonicalized ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSeq allAttributes ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.Expression cleanExpression (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<java.lang.Object> cleanArgs ()  { throw new RuntimeException(); }
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
  static public final  org.apache.spark.sql.SQLContext sqlContext ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.SparkContext sparkContext ()  { throw new RuntimeException(); }
  static public  boolean subexpressionEliminationEnabled ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.SparkPlan makeCopy (java.lang.Object[] newArgs)  { throw new RuntimeException(); }
  static public  void resetMetrics ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.metric.SQLMetric longMetric (java.lang.String name)  { throw new RuntimeException(); }
  static public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  static public  scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>> requiredChildOrdering ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> execute ()  { throw new RuntimeException(); }
  static public final <T extends java.lang.Object> org.apache.spark.broadcast.Broadcast<T> executeBroadcast ()  { throw new RuntimeException(); }
  static protected final <T extends java.lang.Object> T executeQuery (scala.Function0<T> query)  { throw new RuntimeException(); }
  static protected  void prepareSubqueries ()  { throw new RuntimeException(); }
  static protected  void waitForSubqueries ()  { throw new RuntimeException(); }
  static public final  void prepare ()  { throw new RuntimeException(); }
  static protected  void doPrepare ()  { throw new RuntimeException(); }
  static protected <T extends java.lang.Object> org.apache.spark.broadcast.Broadcast<T> doExecuteBroadcast ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.InternalRow[] executeCollect ()  { throw new RuntimeException(); }
  static public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> executeToIterator ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Row[] executeCollectPublic ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.InternalRow[] executeTake (int n)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.MutableProjection newMutableProjection (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema, boolean useSubexprElimination)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.codegen.Predicate newPredicate (org.apache.spark.sql.catalyst.expressions.Expression expression, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  static protected  scala.math.Ordering<org.apache.spark.sql.catalyst.InternalRow> newOrdering (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> order, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  static protected  scala.math.Ordering<org.apache.spark.sql.catalyst.InternalRow> newNaturalAscendingOrdering (scala.collection.Seq<org.apache.spark.sql.types.DataType> dataTypes)  { throw new RuntimeException(); }
  static protected  boolean newMutableProjection$default$3 ()  { throw new RuntimeException(); }
  static public final  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> children ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  { throw new RuntimeException(); }
  static public  java.lang.String metricTerm (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, java.lang.String name)  { throw new RuntimeException(); }
  static public  boolean supportCodegen ()  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.execution.CodegenSupport parent ()  { throw new RuntimeException(); }
  static protected  void parent_$eq (org.apache.spark.sql.execution.CodegenSupport x$1)  { throw new RuntimeException(); }
  static public final  java.lang.String produce (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.execution.CodegenSupport parent)  { throw new RuntimeException(); }
  static public final  java.lang.String consume (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> outputVars, java.lang.String row)  { throw new RuntimeException(); }
  static protected  java.lang.String evaluateVariables (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> variables)  { throw new RuntimeException(); }
  static protected  java.lang.String evaluateRequiredVariables (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> variables, org.apache.spark.sql.catalyst.expressions.AttributeSet required)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSet usedInputs ()  { throw new RuntimeException(); }
  static public  java.lang.String doConsume (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode row)  { throw new RuntimeException(); }
  static public  boolean isShouldStopRequired ()  { throw new RuntimeException(); }
  static protected  boolean shouldStopRequired ()  { throw new RuntimeException(); }
  static public final  java.lang.String consume$default$3 ()  { throw new RuntimeException(); }
  static public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  static public  java.lang.String simpleString ()  { throw new RuntimeException(); }
  static public  java.lang.String verboseString ()  { throw new RuntimeException(); }
  static public  java.lang.String treeString (boolean verbose, boolean addSuffix)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.columnar.InMemoryTableScanExec inMemoryTableScan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.HadoopFsRelation relation ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType outputSchema ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionFilters ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> dataFilters ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.TableIdentifier> metastoreTableIdentifier ()  { throw new RuntimeException(); }
  // not preceding
  public   FileSourceScanExec (org.apache.spark.sql.execution.datasources.HadoopFsRelation relation, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.types.StructType outputSchema, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionFilters, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> dataFilters, scala.Option<org.apache.spark.sql.catalyst.TableIdentifier> metastoreTableIdentifier)  { throw new RuntimeException(); }
  public  boolean supportsBatch ()  { throw new RuntimeException(); }
  public  boolean needsUnsafeRowConversion ()  { throw new RuntimeException(); }
  private  scala.collection.Seq<org.apache.spark.sql.execution.datasources.PartitionDirectory> selectedPartitions ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  private  scala.collection.Seq<org.apache.spark.sql.sources.Filter> pushedDownFilters ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> metadata ()  { throw new RuntimeException(); }
  private  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> inputRDD ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow>> inputRDDs ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public  java.lang.String nodeNamePrefix ()  { throw new RuntimeException(); }
  protected  java.lang.String doProduce (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an RDD for bucketed reads.
   * The non-bucketed variant of this function is {@link createNonBucketedReadRDD}.
   * <p>
   * The algorithm is pretty simple: each RDD partition being returned should include all the files
   * with the same bucket id from all the given Hive partitions.
   * <p>
   * @param bucketSpec the bucketing spec.
   * @param readFile a function to read each (part of a) file.
   * @param selectedPartitions Hive-style partition that are part of the read.
   * @param fsRelation {@link HadoopFsRelation} associated with the read.
   * @return (undocumented)
   */
  private  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> createBucketedReadRDD (org.apache.spark.sql.catalyst.catalog.BucketSpec bucketSpec, scala.Function1<org.apache.spark.sql.execution.datasources.PartitionedFile, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>> readFile, scala.collection.Seq<org.apache.spark.sql.execution.datasources.PartitionDirectory> selectedPartitions, org.apache.spark.sql.execution.datasources.HadoopFsRelation fsRelation)  { throw new RuntimeException(); }
  /**
   * Create an RDD for non-bucketed reads.
   * The bucketed variant of this function is {@link createBucketedReadRDD}.
   * <p>
   * @param readFile a function to read each (part of a) file.
   * @param selectedPartitions Hive-style partition that are part of the read.
   * @param fsRelation {@link HadoopFsRelation} associated with the read.
   * @return (undocumented)
   */
  private  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> createNonBucketedReadRDD (scala.Function1<org.apache.spark.sql.execution.datasources.PartitionedFile, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>> readFile, scala.collection.Seq<org.apache.spark.sql.execution.datasources.PartitionDirectory> selectedPartitions, org.apache.spark.sql.execution.datasources.HadoopFsRelation fsRelation)  { throw new RuntimeException(); }
  private  org.apache.hadoop.fs.BlockLocation[] getBlockLocations (org.apache.hadoop.fs.FileStatus file)  { throw new RuntimeException(); }
  private  java.lang.String[] getBlockHosts (org.apache.hadoop.fs.BlockLocation[] blockLocations, long offset, long length)  { throw new RuntimeException(); }
  public  boolean sameResult (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
