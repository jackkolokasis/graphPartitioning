package org.apache.spark.sql.catalyst.parser;
/**
 * Interface for a parser.
 */
public  interface ParserInterface {
  /** Creates LogicalPlan for a given SQL string. */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan parsePlan (java.lang.String sqlText)  ;
  /** Creates Expression for a given SQL string. */
  public  org.apache.spark.sql.catalyst.expressions.Expression parseExpression (java.lang.String sqlText)  ;
  /** Creates TableIdentifier for a given SQL string. */
  public  org.apache.spark.sql.catalyst.TableIdentifier parseTableIdentifier (java.lang.String sqlText)  ;
  /**
   * Creates StructType for a given SQL string, which is a comma separated list of field
   * definitions which will preserve the correct Hive metadata.
   * @param sqlText (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType parseTableSchema (java.lang.String sqlText)  ;
}
