package org.apache.spark.ml.regression;
/**
 * :: Experimental ::
 * Model produced by {@link GeneralizedLinearRegression}.
 */
public  class GeneralizedLinearRegressionModel extends org.apache.spark.ml.regression.RegressionModel<org.apache.spark.ml.linalg.Vector, org.apache.spark.ml.regression.GeneralizedLinearRegressionModel> implements org.apache.spark.ml.regression.GeneralizedLinearRegressionBase, org.apache.spark.ml.util.MLWritable {
  /** {@link MLWriter} instance for {@link GeneralizedLinearRegressionModel} */
  static   class GeneralizedLinearRegressionModelWriter extends org.apache.spark.ml.util.MLWriter implements org.apache.spark.internal.Logging {
    public   GeneralizedLinearRegressionModelWriter (org.apache.spark.ml.regression.GeneralizedLinearRegressionModel instance)  { throw new RuntimeException(); }
    private  class Data implements scala.Product, scala.Serializable {
      public  double intercept ()  { throw new RuntimeException(); }
      public  org.apache.spark.ml.linalg.Vector coefficients ()  { throw new RuntimeException(); }
      // not preceding
      public   Data (double intercept, org.apache.spark.ml.linalg.Vector coefficients)  { throw new RuntimeException(); }
    }
    private  class Data extends scala.runtime.AbstractFunction2<java.lang.Object, org.apache.spark.ml.linalg.Vector, org.apache.spark.ml.regression.GeneralizedLinearRegressionModel.GeneralizedLinearRegressionModelWriter.Data> implements scala.Serializable {
      public   Data ()  { throw new RuntimeException(); }
    }
    protected  void saveImpl (java.lang.String path)  { throw new RuntimeException(); }
  }
  static private  class GeneralizedLinearRegressionModelReader extends org.apache.spark.ml.util.MLReader<org.apache.spark.ml.regression.GeneralizedLinearRegressionModel> {
    public   GeneralizedLinearRegressionModelReader ()  { throw new RuntimeException(); }
    /** Checked against metadata when loading model */
    private  java.lang.String className ()  { throw new RuntimeException(); }
    public  org.apache.spark.ml.regression.GeneralizedLinearRegressionModel load (java.lang.String path)  { throw new RuntimeException(); }
  }
  static public  org.apache.spark.ml.util.MLReader<org.apache.spark.ml.regression.GeneralizedLinearRegressionModel> read ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.regression.GeneralizedLinearRegressionModel load (java.lang.String path)  { throw new RuntimeException(); }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.param.Param<?>[] params ()  { throw new RuntimeException(); }
  static public  java.lang.String explainParam (org.apache.spark.ml.param.Param<?> param)  { throw new RuntimeException(); }
  static public  java.lang.String explainParams ()  { throw new RuntimeException(); }
  static public final  boolean isSet (org.apache.spark.ml.param.Param<?> param)  { throw new RuntimeException(); }
  static public final  boolean isDefined (org.apache.spark.ml.param.Param<?> param)  { throw new RuntimeException(); }
  static public  boolean hasParam (java.lang.String paramName)  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.param.Param<java.lang.Object> getParam (java.lang.String paramName)  { throw new RuntimeException(); }
  static public final <T extends java.lang.Object> org.apache.spark.ml.param.Params set (org.apache.spark.ml.param.Param<T> param, T value)  { throw new RuntimeException(); }
  static protected final  org.apache.spark.ml.param.Params set (java.lang.String param, Object value)  { throw new RuntimeException(); }
  static protected final  org.apache.spark.ml.param.Params set (org.apache.spark.ml.param.ParamPair<?> paramPair)  { throw new RuntimeException(); }
  static public final <T extends java.lang.Object> scala.Option<T> get (org.apache.spark.ml.param.Param<T> param)  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.Params clear (org.apache.spark.ml.param.Param<?> param)  { throw new RuntimeException(); }
  static public final <T extends java.lang.Object> T getOrDefault (org.apache.spark.ml.param.Param<T> param)  { throw new RuntimeException(); }
  static protected final <T extends java.lang.Object> T $ (org.apache.spark.ml.param.Param<T> param)  { throw new RuntimeException(); }
  static protected final <T extends java.lang.Object> org.apache.spark.ml.param.Params setDefault (org.apache.spark.ml.param.Param<T> param, T value)  { throw new RuntimeException(); }
  static protected final  org.apache.spark.ml.param.Params setDefault (scala.collection.Seq<org.apache.spark.ml.param.ParamPair<?>> paramPairs)  { throw new RuntimeException(); }
  static public final <T extends java.lang.Object> scala.Option<T> getDefault (org.apache.spark.ml.param.Param<T> param)  { throw new RuntimeException(); }
  static public final <T extends java.lang.Object> boolean hasDefault (org.apache.spark.ml.param.Param<T> param)  { throw new RuntimeException(); }
  static protected final <T extends org.apache.spark.ml.param.Params> T defaultCopy (org.apache.spark.ml.param.ParamMap extra)  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.ParamMap extractParamMap (org.apache.spark.ml.param.ParamMap extra)  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.ParamMap extractParamMap ()  { throw new RuntimeException(); }
  static protected <T extends org.apache.spark.ml.param.Params> T copyValues (T to, org.apache.spark.ml.param.ParamMap extra)  { throw new RuntimeException(); }
  static protected <T extends org.apache.spark.ml.param.Params> org.apache.spark.ml.param.ParamMap copyValues$default$2 ()  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.types.StructType transformSchema (org.apache.spark.sql.types.StructType schema, boolean logging)  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.Estimator<M> parent ()  { throw new RuntimeException(); }
  static public  void parent_$eq (org.apache.spark.ml.Estimator<M> x$1)  { throw new RuntimeException(); }
  static public  M setParent (org.apache.spark.ml.Estimator<M> parent)  { throw new RuntimeException(); }
  static public  boolean hasParent ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.Param<java.lang.String> labelCol ()  { throw new RuntimeException(); }
  static public final  java.lang.String getLabelCol ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.Param<java.lang.String> featuresCol ()  { throw new RuntimeException(); }
  static public final  java.lang.String getFeaturesCol ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.Param<java.lang.String> predictionCol ()  { throw new RuntimeException(); }
  static public final  java.lang.String getPredictionCol ()  { throw new RuntimeException(); }
  static public  M setFeaturesCol (java.lang.String value)  { throw new RuntimeException(); }
  static public  M setPredictionCol (java.lang.String value)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.types.DataType featuresDataType ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.StructType transformSchema (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.BooleanParam fitIntercept ()  { throw new RuntimeException(); }
  static public final  boolean getFitIntercept ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.IntParam maxIter ()  { throw new RuntimeException(); }
  static public final  int getMaxIter ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.DoubleParam tol ()  { throw new RuntimeException(); }
  static public final  double getTol ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.DoubleParam regParam ()  { throw new RuntimeException(); }
  static public final  double getRegParam ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.Param<java.lang.String> weightCol ()  { throw new RuntimeException(); }
  static public final  java.lang.String getWeightCol ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.Param<java.lang.String> solver ()  { throw new RuntimeException(); }
  static public final  java.lang.String getSolver ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.Param<java.lang.String> family ()  { throw new RuntimeException(); }
  static public  java.lang.String getFamily ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.DoubleParam variancePower ()  { throw new RuntimeException(); }
  static public  double getVariancePower ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.Param<java.lang.String> link ()  { throw new RuntimeException(); }
  static public  java.lang.String getLink ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.DoubleParam linkPower ()  { throw new RuntimeException(); }
  static public  double getLinkPower ()  { throw new RuntimeException(); }
  static public final  org.apache.spark.ml.param.Param<java.lang.String> linkPredictionCol ()  { throw new RuntimeException(); }
  static public  java.lang.String getLinkPredictionCol ()  { throw new RuntimeException(); }
  static   boolean hasLinkPredictionCol ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.StructType validateAndTransformSchema (org.apache.spark.sql.types.StructType schema, boolean fitting, org.apache.spark.sql.types.DataType featuresDataType)  { throw new RuntimeException(); }
  static public  void save (java.lang.String path) throws java.io.IOException { throw new RuntimeException(); }
  public  java.lang.String uid ()  { throw new RuntimeException(); }
  public  org.apache.spark.ml.linalg.Vector coefficients ()  { throw new RuntimeException(); }
  public  double intercept ()  { throw new RuntimeException(); }
  // not preceding
     GeneralizedLinearRegressionModel (java.lang.String uid, org.apache.spark.ml.linalg.Vector coefficients, double intercept)  { throw new RuntimeException(); }
  /**
   * Sets the link prediction (linear predictor) column name.
   * <p>
   * @group setParam
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.ml.regression.GeneralizedLinearRegressionModel setLinkPredictionCol (java.lang.String value)  { throw new RuntimeException(); }
  private  org.apache.spark.ml.regression.GeneralizedLinearRegression.FamilyAndLink familyAndLink ()  { throw new RuntimeException(); }
  protected  double predict (org.apache.spark.ml.linalg.Vector features)  { throw new RuntimeException(); }
  /**
   * Calculate the link prediction (linear predictor) of the given instance.
   * @param features (undocumented)
   * @return (undocumented)
   */
  private  double predictLink (org.apache.spark.ml.linalg.Vector features)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> transform (org.apache.spark.sql.Dataset<?> dataset)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> transformImpl (org.apache.spark.sql.Dataset<?> dataset)  { throw new RuntimeException(); }
  private  scala.Option<org.apache.spark.ml.regression.GeneralizedLinearRegressionTrainingSummary> trainingSummary ()  { throw new RuntimeException(); }
  /**
   * Gets R-like summary of model on training set. An exception is
   * thrown if there is no summary available.
   * @return (undocumented)
   */
  public  org.apache.spark.ml.regression.GeneralizedLinearRegressionTrainingSummary summary ()  { throw new RuntimeException(); }
  /**
   * Indicates if {@link summary} is available.
   * @return (undocumented)
   */
  public  boolean hasSummary ()  { throw new RuntimeException(); }
    org.apache.spark.ml.regression.GeneralizedLinearRegressionModel setSummary (scala.Option<org.apache.spark.ml.regression.GeneralizedLinearRegressionTrainingSummary> summary)  { throw new RuntimeException(); }
  /**
   * Evaluate the model on the given dataset, returning a summary of the results.
   * @param dataset (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.ml.regression.GeneralizedLinearRegressionSummary evaluate (org.apache.spark.sql.Dataset<?> dataset)  { throw new RuntimeException(); }
  public  org.apache.spark.ml.regression.GeneralizedLinearRegressionModel copy (org.apache.spark.ml.param.ParamMap extra)  { throw new RuntimeException(); }
  /**
   * Returns a {@link org.apache.spark.ml.util.MLWriter} instance for this ML instance.
   * <p>
   * For {@link GeneralizedLinearRegressionModel}, this does NOT currently save the
   * training {@link summary}. An option to save {@link summary} may be added in the future.
   * <p>
   * @return (undocumented)
   */
  public  org.apache.spark.ml.util.MLWriter write ()  { throw new RuntimeException(); }
  public  int numFeatures ()  { throw new RuntimeException(); }
}
