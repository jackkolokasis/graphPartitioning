package org.apache.spark.ml.linalg;
/**
 * Column-major dense matrix.
 * The entry values are stored in a single array of doubles with columns listed in sequence.
 * For example, the following matrix
 * <pre><code>
 *   1.0 2.0
 *   3.0 4.0
 *   5.0 6.0
 * </code></pre>
 * is stored as <code>[1.0, 3.0, 5.0, 2.0, 4.0, 6.0]</code>.
 * <p>
 * param:  numRows number of rows
 * param:  numCols number of columns
 * param:  values matrix entries in column major if not transposed or in row major otherwise
 * param:  isTransposed whether the matrix is transposed. If true, <code>values</code> stores the matrix in
 *                     row major.
 */
public  class DenseMatrix implements org.apache.spark.ml.linalg.Matrix {
  /**
   * Generate a <code>DenseMatrix</code> consisting of zeros.
   * @param numRows number of rows of the matrix
   * @param numCols number of columns of the matrix
   * @return <code>DenseMatrix</code> with size <code>numRows</code> x <code>numCols</code> and values of zeros
   */
  static public  org.apache.spark.ml.linalg.DenseMatrix zeros (int numRows, int numCols)  { throw new RuntimeException(); }
  /**
   * Generate a <code>DenseMatrix</code> consisting of ones.
   * @param numRows number of rows of the matrix
   * @param numCols number of columns of the matrix
   * @return <code>DenseMatrix</code> with size <code>numRows</code> x <code>numCols</code> and values of ones
   */
  static public  org.apache.spark.ml.linalg.DenseMatrix ones (int numRows, int numCols)  { throw new RuntimeException(); }
  /**
   * Generate an Identity Matrix in <code>DenseMatrix</code> format.
   * @param n number of rows and columns of the matrix
   * @return <code>DenseMatrix</code> with size <code>n</code> x <code>n</code> and values of ones on the diagonal
   */
  static public  org.apache.spark.ml.linalg.DenseMatrix eye (int n)  { throw new RuntimeException(); }
  /**
   * Generate a <code>DenseMatrix</code> consisting of <code>i.i.d.</code> uniform random numbers.
   * @param numRows number of rows of the matrix
   * @param numCols number of columns of the matrix
   * @param rng a random number generator
   * @return <code>DenseMatrix</code> with size <code>numRows</code> x <code>numCols</code> and values in U(0, 1)
   */
  static public  org.apache.spark.ml.linalg.DenseMatrix rand (int numRows, int numCols, java.util.Random rng)  { throw new RuntimeException(); }
  /**
   * Generate a <code>DenseMatrix</code> consisting of <code>i.i.d.</code> gaussian random numbers.
   * @param numRows number of rows of the matrix
   * @param numCols number of columns of the matrix
   * @param rng a random number generator
   * @return <code>DenseMatrix</code> with size <code>numRows</code> x <code>numCols</code> and values in N(0, 1)
   */
  static public  org.apache.spark.ml.linalg.DenseMatrix randn (int numRows, int numCols, java.util.Random rng)  { throw new RuntimeException(); }
  /**
   * Generate a diagonal matrix in <code>DenseMatrix</code> format from the supplied values.
   * @param vector a <code>Vector</code> that will form the values on the diagonal of the matrix
   * @return Square <code>DenseMatrix</code> with size <code>values.length</code> x <code>values.length</code> and <code>values</code>
   *         on the diagonal
   */
  static public  org.apache.spark.ml.linalg.DenseMatrix diag (org.apache.spark.ml.linalg.Vector vector)  { throw new RuntimeException(); }
  static   boolean isColMajor ()  { throw new RuntimeException(); }
  static   boolean isRowMajor ()  { throw new RuntimeException(); }
  static public  double[] toArray ()  { throw new RuntimeException(); }
  static public  scala.collection.Iterator<org.apache.spark.ml.linalg.Vector> rowIter ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.linalg.DenseMatrix multiply (org.apache.spark.ml.linalg.DenseMatrix y)  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.linalg.DenseVector multiply (org.apache.spark.ml.linalg.DenseVector y)  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.linalg.DenseVector multiply (org.apache.spark.ml.linalg.Vector y)  { throw new RuntimeException(); }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  static public  java.lang.String toString (int maxLines, int maxLineWidth)  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.linalg.SparseMatrix toSparseColMajor ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.linalg.SparseMatrix toSparseRowMajor ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.linalg.SparseMatrix toSparse ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.linalg.DenseMatrix toDense ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.linalg.DenseMatrix toDenseRowMajor ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.linalg.DenseMatrix toDenseColMajor ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.linalg.Matrix compressedColMajor ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.linalg.Matrix compressedRowMajor ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.linalg.Matrix compressed ()  { throw new RuntimeException(); }
  static   long getDenseSizeInBytes ()  { throw new RuntimeException(); }
  static   long getSparseSizeInBytes (boolean colMajor)  { throw new RuntimeException(); }
  public  int numRows ()  { throw new RuntimeException(); }
  public  int numCols ()  { throw new RuntimeException(); }
  public  double[] values ()  { throw new RuntimeException(); }
  public  boolean isTransposed ()  { throw new RuntimeException(); }
  // not preceding
  public   DenseMatrix (int numRows, int numCols, double[] values, boolean isTransposed)  { throw new RuntimeException(); }
  /**
   * Column-major dense matrix.
   * The entry values are stored in a single array of doubles with columns listed in sequence.
   * For example, the following matrix
   * <pre><code>
   *   1.0 2.0
   *   3.0 4.0
   *   5.0 6.0
   * </code></pre>
   * is stored as <code>[1.0, 3.0, 5.0, 2.0, 4.0, 6.0]</code>.
   * <p>
   * @param numRows number of rows
   * @param numCols number of columns
   * @param values matrix entries in column major
   */
  public   DenseMatrix (int numRows, int numCols, double[] values)  { throw new RuntimeException(); }
  public  boolean equals (Object o)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
    breeze.linalg.Matrix<java.lang.Object> asBreeze ()  { throw new RuntimeException(); }
    double apply (int i)  { throw new RuntimeException(); }
  public  double apply (int i, int j)  { throw new RuntimeException(); }
    int index (int i, int j)  { throw new RuntimeException(); }
    void update (int i, int j, double v)  { throw new RuntimeException(); }
  public  org.apache.spark.ml.linalg.DenseMatrix copy ()  { throw new RuntimeException(); }
    org.apache.spark.ml.linalg.DenseMatrix map (scala.Function1<java.lang.Object, java.lang.Object> f)  { throw new RuntimeException(); }
    org.apache.spark.ml.linalg.DenseMatrix update (scala.Function1<java.lang.Object, java.lang.Object> f)  { throw new RuntimeException(); }
  public  org.apache.spark.ml.linalg.DenseMatrix transpose ()  { throw new RuntimeException(); }
  public  void foreachActive (scala.Function3<java.lang.Object, java.lang.Object, java.lang.Object, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  public  int numNonzeros ()  { throw new RuntimeException(); }
  public  int numActives ()  { throw new RuntimeException(); }
  /**
   * Generate a <code>SparseMatrix</code> from the given <code>DenseMatrix</code>.
   * <p>
   * @param colMajor Whether the resulting <code>SparseMatrix</code> values will be in column major order.
   * @return (undocumented)
   */
    org.apache.spark.ml.linalg.SparseMatrix toSparseMatrix (boolean colMajor)  { throw new RuntimeException(); }
  /**
   * Generate a <code>DenseMatrix</code> from this <code>DenseMatrix</code>.
   * <p>
   * @param colMajor Whether the resulting <code>DenseMatrix</code> values will be in column major order.
   * @return (undocumented)
   */
    org.apache.spark.ml.linalg.DenseMatrix toDenseMatrix (boolean colMajor)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.ml.linalg.Vector> colIter ()  { throw new RuntimeException(); }
    long getSizeInBytes ()  { throw new RuntimeException(); }
}
