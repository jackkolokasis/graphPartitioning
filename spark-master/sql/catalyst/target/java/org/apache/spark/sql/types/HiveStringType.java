package org.apache.spark.sql.types;
/**
 * A hive string type for compatibility. These datatypes should only used for parsing,
 * and should NOT be used anywhere else. Any instance of these data types should be
 * replaced by a {@link StringType} before analysis.
 */
public abstract class HiveStringType extends org.apache.spark.sql.types.AtomicType {
  static public  org.apache.spark.sql.types.DataType replaceCharType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  static   boolean unapply (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  static public  java.lang.String typeName ()  { throw new RuntimeException(); }
  static   org.json4s.JsonAST.JValue jsonValue ()  { throw new RuntimeException(); }
  static public  java.lang.String json ()  { throw new RuntimeException(); }
  static public  java.lang.String prettyJson ()  { throw new RuntimeException(); }
  static public  java.lang.String simpleString ()  { throw new RuntimeException(); }
  static public  java.lang.String catalogString ()  { throw new RuntimeException(); }
  static   java.lang.String simpleString (int maxNumberFields)  { throw new RuntimeException(); }
  static public  java.lang.String sql ()  { throw new RuntimeException(); }
  static   boolean sameType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  static   boolean existsRecursively (scala.Function1<org.apache.spark.sql.types.DataType, java.lang.Object> f)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
  static   boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  public   HiveStringType ()  { throw new RuntimeException(); }
    scala.math.Ordering<org.apache.spark.unsafe.types.UTF8String> ordering ()  { throw new RuntimeException(); }
    scala.reflect.api.TypeTags.TypeTag<org.apache.spark.unsafe.types.UTF8String> tag ()  { throw new RuntimeException(); }
  public  int defaultSize ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.HiveStringType asNullable ()  { throw new RuntimeException(); }
  public abstract  int length ()  ;
}
