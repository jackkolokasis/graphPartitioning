package org.apache.spark.mllib.regression;
/**
 * Isotonic regression.
 * Currently implemented using parallelized pool adjacent violators algorithm.
 * Only univariate (single feature) algorithm supported.
 * <p>
 * Sequential PAV implementation based on:
 * Grotzinger, S. J., and C. Witzgall.
 *   "Projections onto order simplexes." Applied mathematics and Optimization 12.1 (1984): 247-270.
 * <p>
 * Sequential PAV parallelization based on:
 * Kearsley, Anthony J., Richard A. Tapia, and Michael W. Trosset.
 *   "An approach to parallelizing isotonic regression."
 *   Applied Mathematics and Parallel Computing. Physica-Verlag HD, 1996. 141-147.
 *   Available from <a href="http://softlib.rice.edu/pub/CRPC-TRs/reports/CRPC-TR96640.pdf">here</a>
 * <p>
 * @see <a href="http://en.wikipedia.org/wiki/Isotonic_regression">Isotonic regression
 * (Wikipedia)</a>
 */
public  class IsotonicRegression implements java.io.Serializable {
  private  boolean isotonic ()  { throw new RuntimeException(); }
  // not preceding
  private   IsotonicRegression (boolean isotonic)  { throw new RuntimeException(); }
  /**
   * Constructs IsotonicRegression instance with default parameter isotonic = true.
   */
  public   IsotonicRegression ()  { throw new RuntimeException(); }
  /**
   * Sets the isotonic parameter.
   * <p>
   * @param isotonic Isotonic (increasing) or antitonic (decreasing) sequence.
   * @return This instance of IsotonicRegression.
   */
  public  org.apache.spark.mllib.regression.IsotonicRegression setIsotonic (boolean isotonic)  { throw new RuntimeException(); }
  /**
   * Run IsotonicRegression algorithm to obtain isotonic regression model.
   * <p>
   * @param input RDD of tuples (label, feature, weight) where label is dependent variable
   *              for which we calculate isotonic regression, feature is independent variable
   *              and weight represents number of measures with default 1.
   *              If multiple labels share the same feature value then they are ordered before
   *              the algorithm is executed.
   * @return Isotonic regression model.
   */
  public  org.apache.spark.mllib.regression.IsotonicRegressionModel run (org.apache.spark.rdd.RDD<scala.Tuple3<java.lang.Object, java.lang.Object, java.lang.Object>> input)  { throw new RuntimeException(); }
  /**
   * Run pool adjacent violators algorithm to obtain isotonic regression model.
   * <p>
   * @param input JavaRDD of tuples (label, feature, weight) where label is dependent variable
   *              for which we calculate isotonic regression, feature is independent variable
   *              and weight represents number of measures with default 1.
   *              If multiple labels share the same feature value then they are ordered before
   *              the algorithm is executed.
   * @return Isotonic regression model.
   */
  public  org.apache.spark.mllib.regression.IsotonicRegressionModel run (org.apache.spark.api.java.JavaRDD<scala.Tuple3<java.lang.Double, java.lang.Double, java.lang.Double>> input)  { throw new RuntimeException(); }
  /**
   * Performs a pool adjacent violators algorithm (PAV). Implements the algorithm originally
   * described in [1], using the formulation from [2, 3]. Uses an array to keep track of start
   * and end indices of blocks.
   * <p>
   * [1] Grotzinger, S. J., and C. Witzgall. "Projections onto order simplexes." Applied
   * mathematics and Optimization 12.1 (1984): 247-270.
   * <p>
   * [2] Best, Michael J., and Nilotpal Chakravarti. "Active set algorithms for isotonic
   * regression; a unifying framework." Mathematical Programming 47.1-3 (1990): 425-439.
   * <p>
   * [3] Best, Michael J., Nilotpal Chakravarti, and Vasant A. Ubhaya. "Minimizing separable convex
   * functions subject to simple chain constraints." SIAM Journal on Optimization 10.3 (2000):
   * 658-672.
   * <p>
   * @param input Input data of tuples (label, feature, weight). Weights must
   be non-negative.
   * @return Result tuples (label, feature, weight) where labels were updated
   *         to form a monotone sequence as per isotonic regression definition.
   */
  private  scala.Tuple3<java.lang.Object, java.lang.Object, java.lang.Object>[] poolAdjacentViolators (scala.Tuple3<java.lang.Object, java.lang.Object, java.lang.Object>[] input)  { throw new RuntimeException(); }
  /**
   * Performs parallel pool adjacent violators algorithm.
   * Performs Pool adjacent violators algorithm on each partition and then again on the result.
   * <p>
   * @param input Input data of tuples (label, feature, weight).
   * @return Result tuples (label, feature, weight) where labels were updated
   *         to form a monotone sequence as per isotonic regression definition.
   */
  private  scala.Tuple3<java.lang.Object, java.lang.Object, java.lang.Object>[] parallelPoolAdjacentViolators (org.apache.spark.rdd.RDD<scala.Tuple3<java.lang.Object, java.lang.Object, java.lang.Object>> input)  { throw new RuntimeException(); }
}
