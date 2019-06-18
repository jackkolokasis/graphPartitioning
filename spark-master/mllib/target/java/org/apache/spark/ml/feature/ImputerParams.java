package org.apache.spark.ml.feature;
/**
 * Params for {@link Imputer} and {@link ImputerModel}.
 */
  interface ImputerParams extends org.apache.spark.ml.param.Params, org.apache.spark.ml.param.shared.HasInputCols {
  /**
   * The imputation strategy.
   * If "mean", then replace missing values using the mean value of the feature.
   * If "median", then replace missing values using the approximate median value of the feature.
   * Default: mean
   * <p>
   * @group param
   * @return (undocumented)
   */
  public  org.apache.spark.ml.param.Param<java.lang.String> strategy ()  ;
  /** @group getParam */
  public  java.lang.String getStrategy ()  ;
  /**
   * The placeholder for the missing values. All occurrences of missingValue will be imputed.
   * Note that null values are always treated as missing.
   * Default: Double.NaN
   * <p>
   * @group param
   * @return (undocumented)
   */
  public  org.apache.spark.ml.param.DoubleParam missingValue ()  ;
  /** @group getParam */
  public  double getMissingValue ()  ;
  /**
   * Param for output column names.
   * @group param
   * @return (undocumented)
   */
  public  org.apache.spark.ml.param.StringArrayParam outputCols ()  ;
  /** @group getParam */
  public  java.lang.String[] getOutputCols ()  ;
  /** Validates and transforms the input schema. */
  public  org.apache.spark.sql.types.StructType validateAndTransformSchema (org.apache.spark.sql.types.StructType schema)  ;
}
