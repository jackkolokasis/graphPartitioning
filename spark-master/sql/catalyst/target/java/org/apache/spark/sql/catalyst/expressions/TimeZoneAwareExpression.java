package org.apache.spark.sql.catalyst.expressions;
/**
 * Common base class for time zone aware expressions.
 */
public  interface TimeZoneAwareExpression {
  /** the timezone ID to be used to evaluate value. */
  public  scala.Option<java.lang.String> timeZoneId ()  ;
  /** Returns a copy of this expression with the specified timeZoneId. */
  public  org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression withTimeZone (java.lang.String timeZoneId)  ;
  public  java.util.TimeZone timeZone ()  ;
}
