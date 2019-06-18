package org.apache.spark.storage;
public  class BlockReplicationUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final BlockReplicationUtils$ MODULE$ = null;
  public   BlockReplicationUtils$ ()  { throw new RuntimeException(); }
  /**
   * Uses sampling algorithm by Robert Floyd. Finds a random sample in O(n) while
   * minimizing space usage. Please see <a href="http://math.stackexchange.com/questions/178690/whats-the-proof-of-correctness-for-robert-floyds-algorithm-for-selecting-a-sin">
   * here</a>.
   * <p>
   * @param n total number of indices
   * @param m number of samples needed
   * @param r random number generator
   * @return list of m random unique indices
   */
  private  scala.collection.immutable.List<java.lang.Object> getSampleIds (int n, int m, scala.util.Random r)  { throw new RuntimeException(); }
  /**
   * Get a random sample of size m from the elems
   * <p>
   * @param elems
   * @param m number of samples needed
   * @param r random number generator
   * @tparam T
   * @return a random list of size m. If there are fewer than m elements in elems, we just
   *         randomly shuffle elems
   */
  public <T extends java.lang.Object> scala.collection.immutable.List<T> getRandomSample (scala.collection.Seq<T> elems, int m, scala.util.Random r)  { throw new RuntimeException(); }
}
