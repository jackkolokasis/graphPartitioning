package org.apache.spark.sql.catalyst.expressions;
public  class Cast$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Cast$ MODULE$ = null;
  public   Cast$ ()  { throw new RuntimeException(); }
  /**
   * Returns true iff we can cast <code>from</code> type to <code>to</code> type.
   * @param from (undocumented)
   * @param to (undocumented)
   * @return (undocumented)
   */
  public  boolean canCast (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  /**
   * Return true iff we may truncate during casting <code>from</code> type to <code>to</code> type. e.g. long -> int,
   * timestamp -> date.
   * @param from (undocumented)
   * @param to (undocumented)
   * @return (undocumented)
   */
  public  boolean mayTruncate (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  private  boolean illegalNumericPrecedence (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  public  boolean forceNullable (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  private  boolean resolvableNullability (boolean from, boolean to)  { throw new RuntimeException(); }
}
