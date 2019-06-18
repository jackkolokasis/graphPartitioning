package org.apache.spark.sql.execution.datasources.parquet;
public  class ParquetFileFormat implements org.apache.spark.sql.execution.datasources.FileFormat, org.apache.spark.sql.sources.DataSourceRegister, org.apache.spark.internal.Logging, scala.Serializable {
  public  class FileTypes implements scala.Product, scala.Serializable {
    public  scala.collection.Seq<org.apache.hadoop.fs.FileStatus> data ()  { throw new RuntimeException(); }
    public  scala.collection.Seq<org.apache.hadoop.fs.FileStatus> metadata ()  { throw new RuntimeException(); }
    public  scala.collection.Seq<org.apache.hadoop.fs.FileStatus> commonMetadata ()  { throw new RuntimeException(); }
    // not preceding
    public   FileTypes (scala.collection.Seq<org.apache.hadoop.fs.FileStatus> data, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> metadata, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> commonMetadata)  { throw new RuntimeException(); }
  }
  public  class FileTypes$ extends scala.runtime.AbstractFunction3<scala.collection.Seq<org.apache.hadoop.fs.FileStatus>, scala.collection.Seq<org.apache.hadoop.fs.FileStatus>, scala.collection.Seq<org.apache.hadoop.fs.FileStatus>, org.apache.spark.sql.execution.datasources.parquet.ParquetFileFormat.FileTypes> implements scala.Serializable {
    public   FileTypes$ ()  { throw new RuntimeException(); }
  }
  static   scala.Option<org.apache.spark.sql.types.StructType> readSchema (scala.collection.Seq<org.apache.parquet.hadoop.Footer> footers, org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  /**
   * Reads Parquet footers in multi-threaded manner.
   * If the config "spark.sql.files.ignoreCorruptFiles" is set to true, we will ignore the corrupted
   * files when reading footers.
   * @param conf (undocumented)
   * @param partFiles (undocumented)
   * @param ignoreCorruptFiles (undocumented)
   * @return (undocumented)
   */
  static   scala.collection.Seq<org.apache.parquet.hadoop.Footer> readParquetFootersInParallel (org.apache.hadoop.conf.Configuration conf, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> partFiles, boolean ignoreCorruptFiles)  { throw new RuntimeException(); }
  /**
   * Figures out a merged Parquet schema with a distributed Spark job.
   * <p>
   * Note that locality is not taken into consideration here because:
   * <p>
   *  1. For a single Parquet part-file, in most cases the footer only resides in the last block of
   *     that file.  Thus we only need to retrieve the location of the last block.  However, Hadoop
   *     <code>FileSystem</code> only provides API to retrieve locations of all blocks, which can be
   *     potentially expensive.
   * <p>
   *  2. This optimization is mainly useful for S3, where file metadata operations can be pretty
   *     slow.  And basically locality is not available when using S3 (you can't run computation on
   *     S3 nodes).
   * @param filesToTouch (undocumented)
   * @param sparkSession (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<org.apache.spark.sql.types.StructType> mergeSchemasInParallel (scala.collection.Seq<org.apache.hadoop.fs.FileStatus> filesToTouch, org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  /**
   * Reads Spark SQL schema from a Parquet footer.  If a valid serialized Spark SQL schema string
   * can be found in the file metadata, returns the deserialized {@link StructType}, otherwise, returns
   * a {@link StructType} converted from the {@link MessageType} stored in this footer.
   * @param footer (undocumented)
   * @param converter (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.types.StructType readSchemaFromFooter (org.apache.parquet.hadoop.Footer footer, org.apache.spark.sql.execution.datasources.parquet.ParquetSchemaConverter converter)  { throw new RuntimeException(); }
  static private  scala.Option<org.apache.spark.sql.types.StructType> deserializeSchemaString (java.lang.String schemaString)  { throw new RuntimeException(); }
  static protected  scala.Function1<org.apache.spark.sql.execution.datasources.PartitionedFile, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>> buildReader (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.types.StructType partitionSchema, org.apache.spark.sql.types.StructType requiredSchema, scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  public   ParquetFileFormat ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.execution.datasources.parquet.ParquetLogRedirector parquetLogRedirector ()  { throw new RuntimeException(); }
  public  java.lang.String shortName ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.OutputWriterFactory prepareWrite (org.apache.spark.sql.SparkSession sparkSession, org.apache.hadoop.mapreduce.Job job, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.types.StructType dataSchema)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.StructType> inferSchema (org.apache.spark.sql.SparkSession sparkSession, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> files)  { throw new RuntimeException(); }
  private  org.apache.spark.sql.execution.datasources.parquet.ParquetFileFormat.FileTypes splitFiles (scala.collection.Seq<org.apache.hadoop.fs.FileStatus> allFiles)  { throw new RuntimeException(); }
  private  boolean isSummaryFile (org.apache.hadoop.fs.Path file)  { throw new RuntimeException(); }
  /**
   * Returns whether the reader will return the rows as batch or not.
   * @param sparkSession (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  boolean supportBatch (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  public  boolean isSplitable (org.apache.spark.sql.SparkSession sparkSession, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  scala.Function1<org.apache.spark.sql.execution.datasources.PartitionedFile, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>> buildReaderWithPartitionValues (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.types.StructType partitionSchema, org.apache.spark.sql.types.StructType requiredSchema, scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
}
