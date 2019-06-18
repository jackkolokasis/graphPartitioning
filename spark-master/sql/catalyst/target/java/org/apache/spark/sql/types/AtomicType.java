package org.apache.spark.sql.types;
/**
 * An internal type used to represent everything that is not null, UDTs, arrays, structs, and maps.
 */
 abstract class AtomicType extends org.apache.spark.sql.types.DataType {
  /**
   * Enables matching against AtomicType for expressions:
   * <pre><code>
   *   case Cast(child &#64; AtomicType(), StringType) =&gt;
   *     ...
   * </code></pre>
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  boolean unapply (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  static public abstract  int defaultSize ()  ;
  static public  java.lang.String typeName ()  { throw new RuntimeException(); }
  static   org.json4s.JsonAST.JValue jsonValue ()  { throw new RuntimeException(); }
  static public  java.lang.String json ()  { throw new RuntimeException(); }
  static public  java.lang.String prettyJson ()  { throw new RuntimeException(); }
  static public  java.lang.String simpleString ()  { throw new RuntimeException(); }
  static public  java.lang.String catalogString ()  { throw new RuntimeException(); }
  static   java.lang.String simpleString (int maxNumberFields)  { throw new RuntimeException(); }
  static public  java.lang.String sql ()  { throw new RuntimeException(); }
  static   boolean sameType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  static  abstract  org.apache.spark.sql.types.DataType asNullable ()  ;
  static   boolean existsRecursively (scala.Function1<org.apache.spark.sql.types.DataType, java.lang.Object> f)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
  static   boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  public   AtomicType ()  { throw new RuntimeException(); }
   abstract  scala.reflect.api.TypeTags.TypeTag<java.lang.Object> tag ()  ;
   abstract  scala.math.Ordering<java.lang.Object> ordering ()  ;
}
