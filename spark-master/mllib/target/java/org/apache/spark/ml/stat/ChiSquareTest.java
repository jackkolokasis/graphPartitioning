package org.apache.spark.ml.stat;
/**
 * :: Experimental ::
 * <p>
 * Chi-square hypothesis testing for categorical data.
 * <p>
 * See <a href="http://en.wikipedia.org/wiki/Chi-squared_test">Wikipedia</a> for more information
 * on the Chi-squared test.
 */
public  class ChiSquareTest {
  /** Used to construct output schema of tests */
  static private  class ChiSquareResult implements scala.Product, scala.Serializable {
    public  org.apache.spark.ml.linalg.Vector pValues ()  { throw new RuntimeException(); }
    public  int[] degreesOfFreedom ()  { throw new RuntimeException(); }
    public  org.apache.spark.ml.linalg.Vector statistics ()  { throw new RuntimeException(); }
    // not preceding
    public   ChiSquareResult (org.apache.spark.ml.linalg.Vector pValues, int[] degreesOfFreedom, org.apache.spark.ml.linalg.Vector statistics)  { throw new RuntimeException(); }
  }
  static private  class ChiSquareResult$ extends scala.runtime.AbstractFunction3<org.apache.spark.ml.linalg.Vector, int[], org.apache.spark.ml.linalg.Vector, org.apache.spark.ml.stat.ChiSquareTest.ChiSquareResult> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final ChiSquareResult$ MODULE$ = null;
    public   ChiSquareResult$ ()  { throw new RuntimeException(); }
  }
  /**
   * Conduct Pearson's independence test for every feature against the label. For each feature, the
   * (feature, label) pairs are converted into a contingency matrix for which the Chi-squared
   * statistic is computed. All label and feature values must be categorical.
   * <p>
   * The null hypothesis is that the occurrence of the outcomes is statistically independent.
   * <p>
   * @param dataset  DataFrame of categorical labels and categorical features.
   *                 Real-valued features will be treated as categorical for each distinct value.
   * @param featuresCol  Name of features column in dataset, of type <code>Vector</code> (<code>VectorUDT</code>)
   * @param labelCol  Name of label column in dataset, of any numerical type
   * @return DataFrame containing the test result for every feature against the label.
   *         This DataFrame will contain a single Row with the following fields:
   *          - <code>pValues: Vector</code>
   *          - <code>degreesOfFreedom: Array[Int]</code>
   *          - <code>statistics: Vector</code>
   *         Each of these fields has one value per feature.
   */
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> test (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> dataset, java.lang.String featuresCol, java.lang.String labelCol)  { throw new RuntimeException(); }
}
