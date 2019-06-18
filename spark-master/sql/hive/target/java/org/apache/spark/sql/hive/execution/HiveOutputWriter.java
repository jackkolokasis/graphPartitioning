package org.apache.spark.sql.hive.execution;
public  class HiveOutputWriter extends org.apache.spark.sql.execution.datasources.OutputWriter implements org.apache.spark.sql.hive.HiveInspectors {
  public   HiveOutputWriter (java.lang.String path, org.apache.spark.sql.hive.HiveShim.ShimFileSinkDesc fileSinkConf, org.apache.hadoop.mapred.JobConf jobConf, org.apache.spark.sql.types.StructType dataSchema)  { throw new RuntimeException(); }
  private  org.apache.hadoop.hive.ql.plan.TableDesc tableDesc ()  { throw new RuntimeException(); }
  private  org.apache.hadoop.hive.serde2.Serializer serializer ()  { throw new RuntimeException(); }
  private  org.apache.hadoop.hive.ql.exec.FileSinkOperator.RecordWriter hiveWriter ()  { throw new RuntimeException(); }
  private  org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector standardOI ()  { throw new RuntimeException(); }
  private  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector[] fieldOIs ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.types.DataType[] dataTypes ()  { throw new RuntimeException(); }
  private  scala.Function1<java.lang.Object, java.lang.Object>[] wrappers ()  { throw new RuntimeException(); }
  private  java.lang.Object[] outputData ()  { throw new RuntimeException(); }
  public  void write (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
}
