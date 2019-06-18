package org.apache.spark.storage;
/**
 * Abstracts away how blocks are stored and provides different ways to read the underlying block
 * data. Callers should call {@link dispose()} when they're done with the block.
 */
  interface BlockData {
  public  java.io.InputStream toInputStream ()  ;
  /**
   * Returns a Netty-friendly wrapper for the block's data.
   * <p>
   * @see ManagedBuffer#convertToNetty()
   * @return (undocumented)
   */
  public  java.lang.Object toNetty ()  ;
  public  org.apache.spark.util.io.ChunkedByteBuffer toChunkedByteBuffer (scala.Function1<java.lang.Object, java.nio.ByteBuffer> allocator)  ;
  public  java.nio.ByteBuffer toByteBuffer ()  ;
  public  long size ()  ;
  public  void dispose ()  ;
}
