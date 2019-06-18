package org.apache.spark.sql.execution.datasources;
/**
 * A rule to do various checks before inserting into or writing to a data source table.
 */
public  class PreWriteCheck {
  static public  void failAnalysis (java.lang.String msg)  { throw new RuntimeException(); }
  static public  void apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> scala.Function1<A, R> compose (scala.Function1<A, T1> g)  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> scala.Function1<T1, A> andThen (scala.Function1<R, A> g)  { throw new RuntimeException(); }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
}
