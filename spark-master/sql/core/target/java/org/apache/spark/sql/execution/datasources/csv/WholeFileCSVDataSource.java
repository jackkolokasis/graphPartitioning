package org.apache.spark.sql.execution.datasources.csv;
public  class WholeFileCSVDataSource {
  static public  boolean isSplitable ()  { throw new RuntimeException(); }
  static public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> readFile (org.apache.hadoop.conf.Configuration conf, org.apache.spark.sql.execution.datasources.PartitionedFile file, org.apache.spark.sql.execution.datasources.csv.UnivocityParser parser, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.StructType infer (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.execution.datasources.csv.CSVOptions parsedOptions)  { throw new RuntimeException(); }
  static private  org.apache.spark.rdd.RDD<org.apache.spark.input.PortableDataStream> createBaseRdd (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.execution.datasources.csv.CSVOptions options)  { throw new RuntimeException(); }
  static public final  scala.Option<org.apache.spark.sql.types.StructType> inferSchema (org.apache.spark.sql.SparkSession sparkSession, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> inputPaths, org.apache.spark.sql.execution.datasources.csv.CSVOptions parsedOptions)  { throw new RuntimeException(); }
  static protected  java.lang.String[] makeSafeHeader (java.lang.String[] row, boolean caseSensitive, org.apache.spark.sql.execution.datasources.csv.CSVOptions options)  { throw new RuntimeException(); }
}
