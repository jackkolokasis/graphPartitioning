package org.apache.spark.sql.execution.datasources.csv;
  class CsvOutputWriter extends org.apache.spark.sql.execution.datasources.OutputWriter implements org.apache.spark.internal.Logging {
  public   CsvOutputWriter (java.lang.String path, org.apache.spark.sql.types.StructType dataSchema, org.apache.hadoop.mapreduce.TaskAttemptContext context, org.apache.spark.sql.execution.datasources.csv.CSVOptions params)  { throw new RuntimeException(); }
  private  java.io.OutputStreamWriter writer ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.execution.datasources.csv.UnivocityGenerator gen ()  { throw new RuntimeException(); }
  public  void write (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
}
