package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
public  class InnerOuterEstimation implements org.apache.spark.internal.Logging, scala.Product, scala.Serializable {
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
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Join join ()  { throw new RuntimeException(); }
  // not preceding
  public   InnerOuterEstimation (org.apache.spark.sql.internal.SQLConf conf, org.apache.spark.sql.catalyst.plans.logical.Join join)  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.plans.logical.Statistics leftStats ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.plans.logical.Statistics rightStats ()  { throw new RuntimeException(); }
  /**
   * Estimate output size and number of rows after a join operator, and update output column stats.
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.Statistics> doEstimate ()  { throw new RuntimeException(); }
  /**
   * The number of rows of A inner join B on A.k1 = B.k1 is estimated by this basic formula:
   * T(A IJ B) = T(A) * T(B) / max(V(A.k1), V(B.k1)), where V is the number of distinct values of
   * that column. The underlying assumption for this formula is: each value of the smaller domain
   * is included in the larger domain.
   * Generally, inner join with multiple join keys can also be estimated based on the above
   * formula:
   * T(A IJ B) = T(A) * T(B) / (max(V(A.k1), V(B.k1)) * max(V(A.k2), V(B.k2)) * ... * max(V(A.kn), V(B.kn)))
   * However, the denominator can become very large and excessively reduce the result, so we use a
   * conservative strategy to take only the largest max(V(A.ki), V(B.ki)) as the denominator.
   * @param joinKeyPairs (undocumented)
   * @return (undocumented)
   */
  public  scala.math.BigDecimal joinSelectivity (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.AttributeReference, org.apache.spark.sql.catalyst.expressions.AttributeReference>> joinKeyPairs)  { throw new RuntimeException(); }
  /**
   * Propagate or update column stats for output attributes.
   * @param outputRows (undocumented)
   * @param attributes (undocumented)
   * @param oldAttrStats (undocumented)
   * @param joinKeyStats (undocumented)
   * @return (undocumented)
   */
  private  scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Attribute, org.apache.spark.sql.catalyst.plans.logical.ColumnStat>> updateAttrStats (scala.math.BigInt outputRows, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes, org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> oldAttrStats, org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> joinKeyStats)  { throw new RuntimeException(); }
  /** Get intersected column stats for join keys. */
  private  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> getIntersectedStats (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.AttributeReference, org.apache.spark.sql.catalyst.expressions.AttributeReference>> joinKeyPairs)  { throw new RuntimeException(); }
  private  scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.AttributeReference, org.apache.spark.sql.catalyst.expressions.AttributeReference>> extractJoinKeysWithColStats (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> leftKeys, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> rightKeys)  { throw new RuntimeException(); }
}
