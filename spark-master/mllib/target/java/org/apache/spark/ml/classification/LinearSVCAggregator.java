package org.apache.spark.ml.classification;
/**
 * LinearSVCAggregator computes the gradient and loss for hinge loss function, as used
 * in binary classification for instances in sparse or dense vector in an online fashion.
 * <p>
 * Two LinearSVCAggregator can be merged together to have a summary of loss and gradient of
 * the corresponding joint dataset.
 * <p>
 * This class standardizes feature values during computation using bcFeaturesStd.
 * <p>
 * param:  bcCoefficients The coefficients corresponding to the features.
 * param:  fitIntercept Whether to fit an intercept term.
 * param:  bcFeaturesStd The standard deviation values of the features.
 */
public  class LinearSVCAggregator implements scala.Serializable {
  public   LinearSVCAggregator (org.apache.spark.broadcast.Broadcast<org.apache.spark.ml.linalg.Vector> bcCoefficients, org.apache.spark.broadcast.Broadcast<double[]> bcFeaturesStd, boolean fitIntercept)  { throw new RuntimeException(); }
  private  int numFeatures ()  { throw new RuntimeException(); }
  private  int numFeaturesPlusIntercept ()  { throw new RuntimeException(); }
  private  double weightSum ()  { throw new RuntimeException(); }
  private  double lossSum ()  { throw new RuntimeException(); }
  private  double[] coefficientsArray ()  { throw new RuntimeException(); }
  private  double[] gradientSumArray ()  { throw new RuntimeException(); }
  /**
   * Add a new training instance to this LinearSVCAggregator, and update the loss and gradient
   * of the objective function.
   * <p>
   * @param instance The instance of data point to be added.
   * @return This LinearSVCAggregator object.
   */
  public  org.apache.spark.ml.classification.LinearSVCAggregator add (org.apache.spark.ml.feature.Instance instance)  { throw new RuntimeException(); }
  /**
   * Merge another LinearSVCAggregator, and update the loss and gradient
   * of the objective function.
   * (Note that it's in place merging; as a result, <code>this</code> object will be modified.)
   * <p>
   * @param other The other LinearSVCAggregator to be merged.
   * @return This LinearSVCAggregator object.
   */
  public  org.apache.spark.ml.classification.LinearSVCAggregator merge (org.apache.spark.ml.classification.LinearSVCAggregator other)  { throw new RuntimeException(); }
  public  double loss ()  { throw new RuntimeException(); }
  public  org.apache.spark.ml.linalg.Vector gradient ()  { throw new RuntimeException(); }
}
