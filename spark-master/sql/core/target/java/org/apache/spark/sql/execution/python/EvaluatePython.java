package org.apache.spark.sql.execution.python;
public  class EvaluatePython {
  /**
   * Pickler for StructType
   */
  static private  class StructTypePickler implements net.razorvine.pickle.IObjectPickler {
    public   StructTypePickler ()  { throw new RuntimeException(); }
    private  java.lang.Class<org.apache.spark.sql.types.StructType> cls ()  { throw new RuntimeException(); }
    public  void register ()  { throw new RuntimeException(); }
    public  void pickle (java.lang.Object obj, java.io.OutputStream out, net.razorvine.pickle.Pickler pickler)  { throw new RuntimeException(); }
  }
  /**
   * Pickler for external row.
   */
  static private  class RowPickler implements net.razorvine.pickle.IObjectPickler {
    public   RowPickler ()  { throw new RuntimeException(); }
    private  java.lang.Class<org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema> cls ()  { throw new RuntimeException(); }
    public  void register ()  { throw new RuntimeException(); }
    public  void pickle (java.lang.Object obj, java.io.OutputStream out, net.razorvine.pickle.Pickler pickler)  { throw new RuntimeException(); }
  }
  static public  boolean needConversionInPython (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Helper for converting from Catalyst type to java type suitable for Pyrolite.
   * @param obj (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  static public  Object toJava (Object obj, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Converts <code>obj</code> to the type specified by the data type, or returns null if the type of obj is
   * unexpected. Because Python doesn't enforce the type.
   * @param obj (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  static public  Object fromJava (Object obj, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static private  java.lang.String module ()  { throw new RuntimeException(); }
  /**
   * This should be called before trying to serialize any above classes un cluster mode,
   * this should be put in the closure
   */
  static public  void registerPicklers ()  { throw new RuntimeException(); }
  /**
   * Convert an RDD of Java objects to an RDD of serialized Python objects, that is usable by
   * PySpark.
   * @param rdd (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.rdd.RDD<byte[]> javaToPython (org.apache.spark.rdd.RDD<java.lang.Object> rdd)  { throw new RuntimeException(); }
}
