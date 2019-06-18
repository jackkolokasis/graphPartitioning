package org.apache.spark.ml.classification;
/** Params for linear SVM Classifier. */
  interface LinearSVCParams extends org.apache.spark.ml.classification.ClassifierParams, org.apache.spark.ml.param.shared.HasRegParam, org.apache.spark.ml.param.shared.HasMaxIter, org.apache.spark.ml.param.shared.HasFitIntercept, org.apache.spark.ml.param.shared.HasTol, org.apache.spark.ml.param.shared.HasStandardization, org.apache.spark.ml.param.shared.HasWeightCol, org.apache.spark.ml.param.shared.HasThreshold, org.apache.spark.ml.param.shared.HasAggregationDepth {
}
