package org.apache.spark.sql.catalyst.analysis;
/**
 * Provides a way to keep state during the analysis, this enables us to decouple the concerns
 * of analysis environment from the catalog.
 * <p>
 * Note this is thread local.
 * <p>
 * param:  defaultDatabase The default database used in the view resolution, this overrules the
 *                        current catalog database.
 * param:  nestedViewDepth The nested depth in the view resolution, this enables us to limit the
 *                        depth of nested views.
 */
public  class AnalysisContext implements scala.Product, scala.Serializable {
  static private  java.lang.ThreadLocal<org.apache.spark.sql.catalyst.analysis.AnalysisContext> value ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.analysis.AnalysisContext get ()  { throw new RuntimeException(); }
  static private  void set (org.apache.spark.sql.catalyst.analysis.AnalysisContext context)  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> A withAnalysisContext (scala.Option<java.lang.String> database, scala.Function0<A> f)  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> defaultDatabase ()  { throw new RuntimeException(); }
  public  int nestedViewDepth ()  { throw new RuntimeException(); }
  // not preceding
  public   AnalysisContext (scala.Option<java.lang.String> defaultDatabase, int nestedViewDepth)  { throw new RuntimeException(); }
}
