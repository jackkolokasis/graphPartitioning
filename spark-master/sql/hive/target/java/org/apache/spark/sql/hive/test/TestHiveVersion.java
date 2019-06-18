package org.apache.spark.sql.hive.test;
public  class TestHiveVersion extends org.apache.spark.sql.hive.test.TestHiveContext implements scala.Product, scala.Serializable {
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
  static   org.apache.spark.sql.internal.SessionState sessionState ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.internal.SharedState sharedState ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
  static public  org.apache.spark.SparkContext sparkContext ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.util.ExecutionListenerManager listenerManager ()  { throw new RuntimeException(); }
  static public  void setConf (java.util.Properties props)  { throw new RuntimeException(); }
  static  <T extends java.lang.Object> void setConf (org.apache.spark.internal.config.ConfigEntry<T> entry, T value)  { throw new RuntimeException(); }
  static public  void setConf (java.lang.String key, java.lang.String value)  { throw new RuntimeException(); }
  static public  java.lang.String getConf (java.lang.String key)  { throw new RuntimeException(); }
  static public  java.lang.String getConf (java.lang.String key, java.lang.String defaultValue)  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Map<java.lang.String, java.lang.String> getAllConfs ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.ExperimentalMethods experimental ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> emptyDataFrame ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.UDFRegistration udf ()  { throw new RuntimeException(); }
  static public  boolean isCached (java.lang.String tableName)  { throw new RuntimeException(); }
  static public  void cacheTable (java.lang.String tableName)  { throw new RuntimeException(); }
  static public  void uncacheTable (java.lang.String tableName)  { throw new RuntimeException(); }
  static public  void clearCache ()  { throw new RuntimeException(); }
  static public <A extends scala.Product> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createDataFrame (org.apache.spark.rdd.RDD<A> rdd, scala.reflect.api.TypeTags.TypeTag<A> evidence$1)  { throw new RuntimeException(); }
  static public <A extends scala.Product> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createDataFrame (scala.collection.Seq<A> data, scala.reflect.api.TypeTags.TypeTag<A> evidence$2)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> baseRelationToDataFrame (org.apache.spark.sql.sources.BaseRelation baseRelation)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createDataFrame (org.apache.spark.rdd.RDD<org.apache.spark.sql.Row> rowRDD, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createDataFrame (org.apache.spark.rdd.RDD<org.apache.spark.sql.Row> rowRDD, org.apache.spark.sql.types.StructType schema, boolean needsConversion)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> org.apache.spark.sql.Dataset<T> createDataset (scala.collection.Seq<T> data, org.apache.spark.sql.Encoder<T> evidence$3)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> org.apache.spark.sql.Dataset<T> createDataset (org.apache.spark.rdd.RDD<T> data, org.apache.spark.sql.Encoder<T> evidence$4)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> org.apache.spark.sql.Dataset<T> createDataset (java.util.List<T> data, org.apache.spark.sql.Encoder<T> evidence$5)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> internalCreateDataFrame (org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> catalystRows, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createDataFrame (org.apache.spark.api.java.JavaRDD<org.apache.spark.sql.Row> rowRDD, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createDataFrame (java.util.List<org.apache.spark.sql.Row> rows, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createDataFrame (org.apache.spark.rdd.RDD<?> rdd, java.lang.Class<?> beanClass)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createDataFrame (org.apache.spark.api.java.JavaRDD<?> rdd, java.lang.Class<?> beanClass)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createDataFrame (java.util.List<?> data, java.lang.Class<?> beanClass)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.DataFrameReader read ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.streaming.DataStreamReader readStream ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createExternalTable (java.lang.String tableName, java.lang.String path)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createExternalTable (java.lang.String tableName, java.lang.String path, java.lang.String source)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createExternalTable (java.lang.String tableName, java.lang.String source, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createExternalTable (java.lang.String tableName, java.lang.String source, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createExternalTable (java.lang.String tableName, java.lang.String source, org.apache.spark.sql.types.StructType schema, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createExternalTable (java.lang.String tableName, java.lang.String source, org.apache.spark.sql.types.StructType schema, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  static   void registerDataFrameAsTable (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df, java.lang.String tableName)  { throw new RuntimeException(); }
  static public  void dropTempTable (java.lang.String tableName)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> range (long end)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> range (long start, long end)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> range (long start, long end, long step)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> range (long start, long end, long step, int numPartitions)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> sql (java.lang.String sqlText)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> table (java.lang.String tableName)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> tables ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> tables (java.lang.String databaseName)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.streaming.StreamingQueryManager streams ()  { throw new RuntimeException(); }
  static public  java.lang.String[] tableNames ()  { throw new RuntimeException(); }
  static public  java.lang.String[] tableNames (java.lang.String databaseName)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> applySchema (org.apache.spark.rdd.RDD<org.apache.spark.sql.Row> rowRDD, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> applySchema (org.apache.spark.api.java.JavaRDD<org.apache.spark.sql.Row> rowRDD, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> applySchema (org.apache.spark.rdd.RDD<?> rdd, java.lang.Class<?> beanClass)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> applySchema (org.apache.spark.api.java.JavaRDD<?> rdd, java.lang.Class<?> beanClass)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> parquetFile (scala.collection.Seq<java.lang.String> paths)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jsonFile (java.lang.String path)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jsonFile (java.lang.String path, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jsonFile (java.lang.String path, double samplingRatio)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jsonRDD (org.apache.spark.rdd.RDD<java.lang.String> json)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jsonRDD (org.apache.spark.api.java.JavaRDD<java.lang.String> json)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jsonRDD (org.apache.spark.rdd.RDD<java.lang.String> json, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jsonRDD (org.apache.spark.api.java.JavaRDD<java.lang.String> json, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jsonRDD (org.apache.spark.rdd.RDD<java.lang.String> json, double samplingRatio)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jsonRDD (org.apache.spark.api.java.JavaRDD<java.lang.String> json, double samplingRatio)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> load (java.lang.String path)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> load (java.lang.String path, java.lang.String source)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> load (java.lang.String source, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> load (java.lang.String source, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> load (java.lang.String source, org.apache.spark.sql.types.StructType schema, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> load (java.lang.String source, org.apache.spark.sql.types.StructType schema, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jdbc (java.lang.String url, java.lang.String table)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jdbc (java.lang.String url, java.lang.String table, java.lang.String columnName, long lowerBound, long upperBound, int numPartitions)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> jdbc (java.lang.String url, java.lang.String table, java.lang.String[] theParts)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.hive.test.TestHiveSparkSession sparkSession ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.hive.test.TestHiveContext newSession ()  { throw new RuntimeException(); }
  static public  void setCacheTables (boolean c)  { throw new RuntimeException(); }
  static public  java.io.File getHiveFile (java.lang.String path)  { throw new RuntimeException(); }
  static public  void loadTestTable (java.lang.String name)  { throw new RuntimeException(); }
  static public  void reset ()  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.hive.client.HiveClient hiveClient ()  { throw new RuntimeException(); }
  // not preceding
  public   TestHiveVersion (org.apache.spark.sql.hive.client.HiveClient hiveClient)  { throw new RuntimeException(); }
}
