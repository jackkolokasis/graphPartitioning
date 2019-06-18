package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * A base class for collect_list and collect_set aggregate functions.
 * <p>
 * We have to store all the collected elements in memory, and so notice that too many elements
 * can cause GC paused and eventually OutOfMemory Errors.
 */
public abstract class Collect<T extends scala.collection.generic.Growable<java.lang.Object>> extends org.apache.spark.sql.catalyst.expressions.aggregate.TypedImperativeAggregate<T> {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree().setOriginal(CompoundTypeTree(Template(List(AppliedTypeTree(Ident(TypeName("Growable")), List(Ident(TypeName("Any")))), AppliedTypeTree(Ident(TypeName("Iterable")), List(Ident(TypeName("Any"))))), noSelfType, List())))))
  public   Collect ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.catalyst.expressions.Expression child ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean deterministic ()  { throw new RuntimeException(); }
  public  T update (T buffer, org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  T merge (T buffer, T other)  { throw new RuntimeException(); }
  public  Object eval (T buffer)  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.expressions.UnsafeProjection projection ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.expressions.UnsafeRow row ()  { throw new RuntimeException(); }
  public  byte[] serialize (T obj)  { throw new RuntimeException(); }
  public  T deserialize (byte[] bytes)  { throw new RuntimeException(); }
}
