package org.apache.spark.sql.types;
/**
 * The data type representing <code>Double</code> values. Please use the singleton <code>DataTypes.DoubleType</code>.
 * <p>
 * @since 1.3.0
 */
public  class DoubleType extends org.apache.spark.sql.types.FractionalType {
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
  private   DoubleType ()  { throw new RuntimeException(); }
    scala.reflect.api.TypeTags.TypeTag<java.lang.Object> tag ()  { throw new RuntimeException(); }
    scala.math.Numeric<java.lang.Object> numeric ()  { throw new RuntimeException(); }
    scala.math.Fractional<java.lang.Object> fractional ()  { throw new RuntimeException(); }
    java.lang.Object ordering ()  { throw new RuntimeException(); }
    scala.math.Numeric.DoubleAsIfIntegral$ asIntegral ()  { throw new RuntimeException(); }
  /**
   * The default size of a value of the DoubleType is 8 bytes.
   * @return (undocumented)
   */
  public  int defaultSize ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DoubleType asNullable ()  { throw new RuntimeException(); }
}
