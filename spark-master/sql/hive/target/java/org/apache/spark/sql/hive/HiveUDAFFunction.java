package org.apache.spark.sql.hive;
/**
 * While being evaluated by Spark SQL, the aggregation state of a Hive UDAF may be in the following
 * three formats:
 * <p>
 *  1. An instance of some concrete <code>GenericUDAFEvaluator.AggregationBuffer</code> class
 * <p>
 *     This is the native Hive representation of an aggregation state. Hive <code>GenericUDAFEvaluator</code>
 *     methods like <code>iterate()</code>, <code>merge()</code>, <code>terminatePartial()</code>, and <code>terminate()</code> use this format.
 *     We call these methods to evaluate Hive UDAFs.
 * <p>
 *  2. A Java object that can be inspected using the <code>ObjectInspector</code> returned by the
 *     <code>GenericUDAFEvaluator.init()</code> method.
 * <p>
 *     Hive uses this format to produce a serializable aggregation state so that it can shuffle
 *     partial aggregation results. Whenever we need to convert a Hive <code>AggregationBuffer</code> instance
 *     into a Spark SQL value, we have to convert it to this format first and then do the conversion
 *     with the help of <code>ObjectInspector</code>s.
 * <p>
 *  3. A Spark SQL value
 * <p>
 *     We use this format for serializing Hive UDAF aggregation states on Spark side. To be more
 *     specific, we convert <code>AggregationBuffer</code>s into equivalent Spark SQL values, write them into
 *     <code>UnsafeRow</code>s, and then retrieve the byte array behind those <code>UnsafeRow</code>s as serialization
 *     results.
 * <p>
 * We may use the following methods to convert the aggregation state back and forth:
 * <p>
 *  - <code>wrap()</code>/<code>wrapperFor()</code>: from 3 to 1
 *  - <code>unwrap()</code>/<code>unwrapperFor()</code>: from 1 to 3
 *  - <code>GenericUDAFEvaluator.terminatePartial()</code>: from 2 to 3
 */
  class HiveUDAFFunction extends org.apache.spark.sql.catalyst.expressions.aggregate.TypedImperativeAggregate<org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer> implements org.apache.spark.sql.hive.HiveInspectors, scala.Product, scala.Serializable {
  private  class AggregationBufferSerDe {
    public   AggregationBufferSerDe ()  { throw new RuntimeException(); }
    private  scala.Function1<java.lang.Object, java.lang.Object> partialResultUnwrapper ()  { throw new RuntimeException(); }
    private  scala.Function1<java.lang.Object, java.lang.Object> partialResultWrapper ()  { throw new RuntimeException(); }
    private  org.apache.spark.sql.catalyst.expressions.UnsafeProjection projection ()  { throw new RuntimeException(); }
    private  org.apache.spark.sql.catalyst.expressions.GenericInternalRow mutableRow ()  { throw new RuntimeException(); }
    public  byte[] serialize (org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer buffer)  { throw new RuntimeException(); }
    public  org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer deserialize (byte[] bytes)  { throw new RuntimeException(); }
  }
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
  static public  BaseType makeCopy (java.lang.Object[] newArgs)  { throw new RuntimeException(); }
  static public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  static protected  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
  static public  java.lang.String argString ()  { throw new RuntimeException(); }
  static public  java.lang.String verboseStringWithSuffix ()  { throw new RuntimeException(); }
  static public  java.lang.String treeString ()  { throw new RuntimeException(); }
  static public  java.lang.String treeString (boolean verbose, boolean addSuffix)  { throw new RuntimeException(); }
  static public  java.lang.String numberedTreeString ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.trees.TreeNode<?> apply (int number)  { throw new RuntimeException(); }
  static public  BaseType p (int number)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.trees.TreeNode<?>> innerChildren ()  { throw new RuntimeException(); }
  static public  scala.collection.mutable.StringBuilder generateTreeString (int depth, scala.collection.Seq<java.lang.Object> lastChildren, scala.collection.mutable.StringBuilder builder, boolean verbose, java.lang.String prefix, boolean addSuffix)  { throw new RuntimeException(); }
  static public  java.lang.String asCode ()  { throw new RuntimeException(); }
  static public  java.lang.String toJSON ()  { throw new RuntimeException(); }
  static public  java.lang.String prettyJson ()  { throw new RuntimeException(); }
  static protected  scala.collection.immutable.List<scala.Tuple2<java.lang.String, org.json4s.JsonAST.JValue>> jsonFields ()  { throw new RuntimeException(); }
  static public  boolean treeString$default$2 ()  { throw new RuntimeException(); }
  static public  java.lang.String generateTreeString$default$5 ()  { throw new RuntimeException(); }
  static public  boolean generateTreeString$default$6 ()  { throw new RuntimeException(); }
  static public  boolean deterministic ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode genCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  { throw new RuntimeException(); }
  static public  boolean resolved ()  { throw new RuntimeException(); }
  static public  boolean childrenResolved ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression canonicalized ()  { throw new RuntimeException(); }
  static public  boolean semanticEquals (org.apache.spark.sql.catalyst.expressions.Expression other)  { throw new RuntimeException(); }
  static public  int semanticHash ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  static protected  scala.collection.Iterator<java.lang.Object> flatArguments ()  { throw new RuntimeException(); }
  static public final  java.lang.String verboseString ()  { throw new RuntimeException(); }
  static public  java.lang.String simpleString ()  { throw new RuntimeException(); }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.InternalRow eval$default$1 ()  { throw new RuntimeException(); }
  static public final  boolean foldable ()  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.catalyst.expressions.Literal> defaultResult ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression toAggregateExpression ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression toAggregateExpression (boolean isDistinct)  { throw new RuntimeException(); }
  static public  java.lang.String toAggString (boolean isDistinct)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  static public final  void initialize (org.apache.spark.sql.catalyst.InternalRow buffer)  { throw new RuntimeException(); }
  static public final  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes ()  { throw new RuntimeException(); }
  static public final  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> inputAggBufferAttributes ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.sql.types.StructType aggBufferSchema ()  { throw new RuntimeException(); }
  static public final  void serializeAggregateBufferInPlace (org.apache.spark.sql.catalyst.InternalRow buffer)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.DataType javaTypeToDataType (java.lang.reflect.Type clz)  { throw new RuntimeException(); }
  static protected  scala.Function1<java.lang.Object, java.lang.Object> wrapperFor (org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector oi, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  scala.Function1<java.lang.Object, java.lang.Object> unwrapperFor (org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector objectInspector)  { throw new RuntimeException(); }
  static public  scala.Function3<java.lang.Object, org.apache.spark.sql.catalyst.InternalRow, java.lang.Object, scala.runtime.BoxedUnit> unwrapperFor (org.apache.hadoop.hive.serde2.objectinspector.StructField field)  { throw new RuntimeException(); }
  static public  java.lang.Object wrap (Object a, org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector oi, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.lang.Object[] wrap (org.apache.spark.sql.catalyst.InternalRow row, scala.Function1<java.lang.Object, java.lang.Object>[] wrappers, java.lang.Object[] cache, org.apache.spark.sql.types.DataType[] dataTypes)  { throw new RuntimeException(); }
  static public  java.lang.Object[] wrap (scala.collection.Seq<java.lang.Object> row, scala.Function1<java.lang.Object, java.lang.Object>[] wrappers, java.lang.Object[] cache, org.apache.spark.sql.types.DataType[] dataTypes)  { throw new RuntimeException(); }
  static public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector toInspector (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector toInspector (org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.DataType inspectorToDataType (org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector inspector)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.hive.HiveInspectors.typeInfoConversions typeInfoConversions (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.hive.HiveShim.HiveFunctionWrapper funcWrapper ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean isUDAFBridgeRequired ()  { throw new RuntimeException(); }
  public  int mutableAggBufferOffset ()  { throw new RuntimeException(); }
  public  int inputAggBufferOffset ()  { throw new RuntimeException(); }
  // not preceding
  public   HiveUDAFFunction (java.lang.String name, org.apache.spark.sql.hive.HiveShim.HiveFunctionWrapper funcWrapper, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children, boolean isUDAFBridgeRequired, int mutableAggBufferOffset, int inputAggBufferOffset)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewMutableAggBufferOffset (int newMutableAggBufferOffset)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewInputAggBufferOffset (int newInputAggBufferOffset)  { throw new RuntimeException(); }
  private  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector[] inputInspectors ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.types.DataType[] inputDataTypes ()  { throw new RuntimeException(); }
  private  org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator newEvaluator ()  { throw new RuntimeException(); }
  private  org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator partial1ModeEvaluator ()  { throw new RuntimeException(); }
  private  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector partialResultInspector ()  { throw new RuntimeException(); }
  private  org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator partial2ModeEvaluator ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.types.DataType partialResultDataType ()  { throw new RuntimeException(); }
  private  org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator finalModeEvaluator ()  { throw new RuntimeException(); }
  private  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector returnInspector ()  { throw new RuntimeException(); }
  private  scala.Function1<java.lang.Object, java.lang.Object>[] inputWrappers ()  { throw new RuntimeException(); }
  private  scala.Function1<java.lang.Object, java.lang.Object> resultUnwrapper ()  { throw new RuntimeException(); }
  private  java.lang.Object[] cached ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.hive.HiveUDAFFunction.AggregationBufferSerDe aggBufferSerDe ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  java.lang.String sql (boolean isDistinct)  { throw new RuntimeException(); }
  public  org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer createAggregationBuffer ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.expressions.UnsafeProjection inputProjection ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer update (org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer buffer, org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer merge (org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer buffer, org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer input)  { throw new RuntimeException(); }
  public  Object eval (org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer buffer)  { throw new RuntimeException(); }
  public  byte[] serialize (org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer buffer)  { throw new RuntimeException(); }
  public  org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer deserialize (byte[] bytes)  { throw new RuntimeException(); }
}
