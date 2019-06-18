package org.apache.spark.sql.execution.datasources.json;
public  class WholeFileJsonDataSource$ extends org.apache.spark.sql.execution.datasources.json.JsonDataSource {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final WholeFileJsonDataSource$ MODULE$ = null;
  public   WholeFileJsonDataSource$ ()  { throw new RuntimeException(); }
  public  boolean isSplitable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType infer (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.catalyst.json.JSONOptions parsedOptions)  { throw new RuntimeException(); }
  private  org.apache.spark.rdd.RDD<org.apache.spark.input.PortableDataStream> createBaseRdd (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths)  { throw new RuntimeException(); }
  private  com.fasterxml.jackson.core.JsonParser createParser (com.fasterxml.jackson.core.JsonFactory jsonFactory, org.apache.spark.input.PortableDataStream record)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> readFile (org.apache.hadoop.conf.Configuration conf, org.apache.spark.sql.execution.datasources.PartitionedFile file, org.apache.spark.sql.catalyst.json.JacksonParser parser, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
}
