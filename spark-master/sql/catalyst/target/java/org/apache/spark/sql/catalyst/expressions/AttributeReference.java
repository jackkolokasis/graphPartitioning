package org.apache.spark.sql.catalyst.expressions;
/**
 * A reference to an attribute produced by another operator in the tree.
 * <p>
 * param:  name The name of this attribute, should only be used during analysis or for debugging.
 * param:  dataType The {@link DataType} of this attribute.
 * param:  nullable True if null is a valid value for this attribute.
 * param:  metadata The metadata of this attribute.
 * param:  exprId A globally unique id used to check if different AttributeReferences refer to the
 *               same attribute.
 * param:  qualifier An optional string that can be used to referred to this attribute in a fully
 *                  qualified way. Consider the examples tableName.name, subQueryAlias.name.
 *                  tableName and subQueryAlias are possible qualifiers.
 * param:  isGenerated A flag to indicate if this reference is generated by Catalyst
 */
public  class AttributeReference extends org.apache.spark.sql.catalyst.expressions.Attribute implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.trees.Origin origin ()  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Set<org.apache.spark.sql.catalyst.trees.TreeNode<?>> containsChild ()  { throw new RuntimeException(); }
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
  static public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode genCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  { throw new RuntimeException(); }
  static public  boolean resolved ()  { throw new RuntimeException(); }
  static public  boolean childrenResolved ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression canonicalized ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  static public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  static protected  scala.collection.Iterator<java.lang.Object> flatArguments ()  { throw new RuntimeException(); }
  static public final  java.lang.String verboseString ()  { throw new RuntimeException(); }
  static public final  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  static public  boolean foldable ()  { throw new RuntimeException(); }
  static public  java.lang.String qualifiedName ()  { throw new RuntimeException(); }
  static protected  java.lang.String typeSuffix ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Attribute toAttribute ()  { throw new RuntimeException(); }
  static public final  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  static protected final  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  static public final  org.apache.spark.sql.catalyst.InternalRow eval$default$1 ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Metadata metadata ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> qualifier ()  { throw new RuntimeException(); }
  public  java.lang.Boolean isGenerated ()  { throw new RuntimeException(); }
  // not preceding
  public   AttributeReference (java.lang.String name, org.apache.spark.sql.types.DataType dataType, boolean nullable, org.apache.spark.sql.types.Metadata metadata, org.apache.spark.sql.catalyst.expressions.ExprId exprId, scala.Option<java.lang.String> qualifier, java.lang.Boolean isGenerated)  { throw new RuntimeException(); }
  /**
   * Returns true iff the expression id is the same for both attributes.
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  boolean sameRef (org.apache.spark.sql.catalyst.expressions.AttributeReference other)  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  boolean semanticEquals (org.apache.spark.sql.catalyst.expressions.Expression other)  { throw new RuntimeException(); }
  public  int semanticHash ()  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference newInstance ()  { throw new RuntimeException(); }
  /**
   * Returns a copy of this {@link AttributeReference} with changed nullability.
   * @param newNullability (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference withNullability (boolean newNullability)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference withName (java.lang.String newName)  { throw new RuntimeException(); }
  /**
   * Returns a copy of this {@link AttributeReference} with new qualifier.
   * @param newQualifier (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference withQualifier (scala.Option<java.lang.String> newQualifier)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference withExprId (org.apache.spark.sql.catalyst.expressions.ExprId newExprId)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute withMetadata (org.apache.spark.sql.types.Metadata newMetadata)  { throw new RuntimeException(); }
  protected final  scala.collection.Seq<java.lang.Object> otherCopyArgs ()  { throw new RuntimeException(); }
  /** Used to signal the column used to calculate an eventTime watermark (e.g. a#1-T{delayMs}) */
  private  java.lang.String delaySuffix ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
