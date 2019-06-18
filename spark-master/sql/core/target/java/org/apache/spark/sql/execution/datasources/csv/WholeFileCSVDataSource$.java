package org.apache.spark.sql.execution.datasources.csv;
public  class WholeFileCSVDataSource$ extends org.apache.spark.sql.execution.datasources.csv.CSVDataSource {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final WholeFileCSVDataSource$ MODULE$ = null;
  public   WholeFileCSVDataSource$ ()  { throw new RuntimeException(); }
  public  boolean isSplitable ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> readFile (org.apache.hadoop.conf.Configuration conf, org.apache.spark.sql.execution.datasources.PartitionedFile file, org.apache.spark.sql.execution.datasources.csv.UnivocityParser parser, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType infer (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.execution.datasources.csv.CSVOptions parsedOptions)  { throw new RuntimeException(); }
  private  org.apache.spark.rdd.RDD<org.apache.spark.input.PortableDataStream> createBaseRdd (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.execution.datasources.csv.CSVOptions options)  { throw new RuntimeException(); }
}
