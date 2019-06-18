package org.apache.spark.sql.catalyst.expressions;
public  class GenArrayData {
  /**
   * Return Java code pieces based on DataType and isPrimitive to allocate ArrayData class
   * <p>
   * @param ctx a {@link CodegenContext}
   * @param elementType data type of underlying array elements
   * @param elementsCode a set of {@link ExprCode} for each element of an underlying array
   * @param isMapKey if true, throw an exception when the element is null
   * @return (code pre-assignments, assignments to each array elements, code post-assignments,
   *           arrayData name)
   */
  static public  scala.Tuple4<java.lang.String, scala.collection.Seq<java.lang.String>, java.lang.String, java.lang.String> genCodeToCreateArrayData (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.types.DataType elementType, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> elementsCode, boolean isMapKey)  { throw new RuntimeException(); }
}
