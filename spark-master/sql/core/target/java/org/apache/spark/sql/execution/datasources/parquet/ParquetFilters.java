package org.apache.spark.sql.execution.datasources.parquet;
/**
 * Some utility function to convert Spark data source filters to Parquet filters.
 */
public  class ParquetFilters {
  static private  scala.PartialFunction<org.apache.spark.sql.types.DataType, scala.Function2<java.lang.String, java.lang.Object, org.apache.parquet.filter2.predicate.FilterPredicate>> makeEq ()  { throw new RuntimeException(); }
  static private  scala.PartialFunction<org.apache.spark.sql.types.DataType, scala.Function2<java.lang.String, java.lang.Object, org.apache.parquet.filter2.predicate.FilterPredicate>> makeNotEq ()  { throw new RuntimeException(); }
  static private  scala.PartialFunction<org.apache.spark.sql.types.DataType, scala.Function2<java.lang.String, java.lang.Object, org.apache.parquet.filter2.predicate.FilterPredicate>> makeLt ()  { throw new RuntimeException(); }
  static private  scala.PartialFunction<org.apache.spark.sql.types.DataType, scala.Function2<java.lang.String, java.lang.Object, org.apache.parquet.filter2.predicate.FilterPredicate>> makeLtEq ()  { throw new RuntimeException(); }
  static private  scala.PartialFunction<org.apache.spark.sql.types.DataType, scala.Function2<java.lang.String, java.lang.Object, org.apache.parquet.filter2.predicate.FilterPredicate>> makeGt ()  { throw new RuntimeException(); }
  static private  scala.PartialFunction<org.apache.spark.sql.types.DataType, scala.Function2<java.lang.String, java.lang.Object, org.apache.parquet.filter2.predicate.FilterPredicate>> makeGtEq ()  { throw new RuntimeException(); }
  /**
   * Returns a map from name of the column to the data type, if predicate push down applies.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  static private  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.types.DataType> getFieldMap (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Converts data sources filters to Parquet filter predicates.
   * @param schema (undocumented)
   * @param predicate (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<org.apache.parquet.filter2.predicate.FilterPredicate> createFilter (org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.sources.Filter predicate)  { throw new RuntimeException(); }
}
