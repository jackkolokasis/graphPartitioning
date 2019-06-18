package org.apache.spark.ml.classification;
/**
 * LinearSVCCostFun implements Breeze's DiffFunction[T] for hinge loss function
 */
public  class LinearSVCCostFun implements breeze.optimize.DiffFunction<breeze.linalg.DenseVector<java.lang.Object>> {
  public   LinearSVCCostFun (org.apache.spark.rdd.RDD<org.apache.spark.ml.feature.Instance> instances, boolean fitIntercept, boolean standardization, org.apache.spark.broadcast.Broadcast<double[]> bcFeaturesStd, double regParamL2, int aggregationDepth)  { throw new RuntimeException(); }
  public  scala.Tuple2<java.lang.Object, breeze.linalg.DenseVector<java.lang.Object>> calculate (breeze.linalg.DenseVector<java.lang.Object> coefficients)  { throw new RuntimeException(); }
}
