package org.apache.spark.sql.catalyst.catalog;
/**
 * A table defined in the catalog.
 * <p>
 * Note that Hive's metastore also tracks skewed columns. We should consider adding that in the
 * future once we have a better understanding of how we want to handle skewed columns.
 * <p>
 * param:  provider the name of the data source provider for this table, e.g. parquet, json, etc.
 *                 Can be None if this table is a View, should be "hive" for hive serde tables.
 * param:  unsupportedFeatures is a list of string descriptions of features that are used by the
 *        underlying table but not supported by Spark SQL yet.
 * param:  tracksPartitionsInCatalog whether this table's partition metadata is stored in the
 *                                  catalog. If false, it is inferred automatically based on file
 *                                  structure.
 * param:  schemaPreservesCase Whether or not the schema resolved for this table is case-sensitive.
 *                           When using a Hive Metastore, this flag is set to false if a case-
 *                           sensitive schema was unable to be read from the table properties.
 *                           Used to trigger case-sensitive schema inference at query time, when
 *                           configured.
 */
public  class CatalogTable implements scala.Product, scala.Serializable {
  static public  java.lang.String VIEW_DEFAULT_DATABASE ()  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_QUERY_OUTPUT_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_QUERY_OUTPUT_NUM_COLUMNS ()  { throw new RuntimeException(); }
  static public  java.lang.String VIEW_QUERY_OUTPUT_COLUMN_NAME_PREFIX ()  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier identifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTableType tableType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat storage ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> provider ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> partitionColumnNames ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec ()  { throw new RuntimeException(); }
  public  java.lang.String owner ()  { throw new RuntimeException(); }
  public  long createTime ()  { throw new RuntimeException(); }
  public  long lastAccessTime ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> properties ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> stats ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> viewText ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> comment ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> unsupportedFeatures ()  { throw new RuntimeException(); }
  public  boolean tracksPartitionsInCatalog ()  { throw new RuntimeException(); }
  public  boolean schemaPreservesCase ()  { throw new RuntimeException(); }
  // not preceding
  public   CatalogTable (org.apache.spark.sql.catalyst.TableIdentifier identifier, org.apache.spark.sql.catalyst.catalog.CatalogTableType tableType, org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat storage, org.apache.spark.sql.types.StructType schema, scala.Option<java.lang.String> provider, scala.collection.Seq<java.lang.String> partitionColumnNames, scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec, java.lang.String owner, long createTime, long lastAccessTime, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties, scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> stats, scala.Option<java.lang.String> viewText, scala.Option<java.lang.String> comment, scala.collection.Seq<java.lang.String> unsupportedFeatures, boolean tracksPartitionsInCatalog, boolean schemaPreservesCase)  { throw new RuntimeException(); }
  /**
   * schema of this table's partition columns
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType partitionSchema ()  { throw new RuntimeException(); }
  /**
   * schema of this table's data columns
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType dataSchema ()  { throw new RuntimeException(); }
  /** Return the database this table was specified to belong to, assuming it exists. */
  public  java.lang.String database ()  { throw new RuntimeException(); }
  /** Return the table location, assuming it is specified. */
  public  java.net.URI location ()  { throw new RuntimeException(); }
  /** Return the fully qualified name of this table, assuming the database was specified. */
  public  java.lang.String qualifiedName ()  { throw new RuntimeException(); }
  /**
   * Return the default database name we use to resolve a view, should be None if the CatalogTable
   * is not a View or created by older versions of Spark(before 2.2.0).
   * @return (undocumented)
   */
  public  scala.Option<java.lang.String> viewDefaultDatabase ()  { throw new RuntimeException(); }
  /**
   * Return the output column names of the query that creates a view, the column names are used to
   * resolve a view, should be empty if the CatalogTable is not a View or created by older versions
   * of Spark(before 2.2.0).
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> viewQueryColumnNames ()  { throw new RuntimeException(); }
  /** Syntactic sugar to update a field in `storage`. */
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable withNewStorage (scala.Option<java.net.URI> locationUri, scala.Option<java.lang.String> inputFormat, scala.Option<java.lang.String> outputFormat, boolean compressed, scala.Option<java.lang.String> serde, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
