package org.apache.spark.sql.execution.datasources.csv;
public  class CSVUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CSVUtils$ MODULE$ = null;
  public   CSVUtils$ ()  { throw new RuntimeException(); }
  /**
   * Filter ignorable rows for CSV dataset (lines empty and starting with <code>comment</code>).
   * This is currently being used in CSV schema inference.
   * @param lines (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<java.lang.String> filterCommentAndEmpty (org.apache.spark.sql.Dataset<java.lang.String> lines, org.apache.spark.sql.execution.datasources.csv.CSVOptions options)  { throw new RuntimeException(); }
  /**
   * Filter ignorable rows for CSV iterator (lines empty and starting with <code>comment</code>).
   * This is currently being used in CSV reading path and CSV schema inference.
   * @param iter (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<java.lang.String> filterCommentAndEmpty (scala.collection.Iterator<java.lang.String> iter, org.apache.spark.sql.execution.datasources.csv.CSVOptions options)  { throw new RuntimeException(); }
  /**
   * Skip the given first line so that only data can remain in a dataset.
   * This is similar with <code>dropHeaderLine</code> below and currently being used in CSV schema inference.
   * @param iter (undocumented)
   * @param firstLine (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<java.lang.String> filterHeaderLine (scala.collection.Iterator<java.lang.String> iter, java.lang.String firstLine, org.apache.spark.sql.execution.datasources.csv.CSVOptions options)  { throw new RuntimeException(); }
  /**
   * Drop header line so that only data can remain.
   * This is similar with <code>filterHeaderLine</code> above and currently being used in CSV reading path.
   * @param iter (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<java.lang.String> dropHeaderLine (scala.collection.Iterator<java.lang.String> iter, org.apache.spark.sql.execution.datasources.csv.CSVOptions options)  { throw new RuntimeException(); }
  /**
   * Helper method that converts string representation of a character to actual character.
   * It handles some Java escaped strings and throws exception if given string is longer than one
   * character.
   * @param str (undocumented)
   * @return (undocumented)
   */
  public  char toChar (java.lang.String str) throws java.lang.IllegalArgumentException { throw new RuntimeException(); }
  /**
   * Verify if the schema is supported in CSV datasource.
   * @param schema (undocumented)
   */
  public  void verifySchema (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
}
