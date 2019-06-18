package org.apache.spark.sql.catalyst.expressions;
public abstract class StringRegexExpression extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant {
  public   StringRegexExpression ()  { throw new RuntimeException(); }
  public abstract  java.lang.String escape (java.lang.String v)  ;
  public abstract  boolean matches (java.util.regex.Pattern regex, java.lang.String str)  ;
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypes ()  { throw new RuntimeException(); }
  private  java.util.regex.Pattern cache ()  { throw new RuntimeException(); }
  protected  java.util.regex.Pattern compile (java.lang.String str)  { throw new RuntimeException(); }
  protected  java.util.regex.Pattern pattern (java.lang.String str)  { throw new RuntimeException(); }
  protected  Object nullSafeEval (Object input1, Object input2)  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
