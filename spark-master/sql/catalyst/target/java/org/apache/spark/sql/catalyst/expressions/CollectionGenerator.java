package org.apache.spark.sql.catalyst.expressions;
/**
 * A collection producing {@link Generator}. This trait provides a different path for code generation,
 * by allowing code generation to return either an {@link ArrayData} or a {@link MapData} object.
 */
public  interface CollectionGenerator extends org.apache.spark.sql.catalyst.expressions.Generator {
  /** The position of an element within the collection should also be returned. */
  public  boolean position ()  ;
  /** Rows will be inlined during generation. */
  public  boolean inline ()  ;
  /** The type of the returned collection object. */
  public  org.apache.spark.sql.types.DataType collectionType ()  ;
}
