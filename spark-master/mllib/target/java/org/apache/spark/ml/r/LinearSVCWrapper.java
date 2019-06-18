package org.apache.spark.ml.r;
  class LinearSVCWrapper implements org.apache.spark.ml.util.MLWritable {
  static public  class LinearSVCWrapperWriter extends org.apache.spark.ml.util.MLWriter {
    public   LinearSVCWrapperWriter (org.apache.spark.ml.r.LinearSVCWrapper instance)  { throw new RuntimeException(); }
    protected  void saveImpl (java.lang.String path)  { throw new RuntimeException(); }
  }
  static public  class LinearSVCWrapperReader extends org.apache.spark.ml.util.MLReader<org.apache.spark.ml.r.LinearSVCWrapper> {
    public   LinearSVCWrapperReader ()  { throw new RuntimeException(); }
    public  org.apache.spark.ml.r.LinearSVCWrapper load (java.lang.String path)  { throw new RuntimeException(); }
  }
  static public  java.lang.String PREDICTED_LABEL_INDEX_COL ()  { throw new RuntimeException(); }
  static public  java.lang.String PREDICTED_LABEL_COL ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.r.LinearSVCWrapper fit (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> data, java.lang.String formula, double regParam, int maxIter, double tol, boolean standardization, double threshold, java.lang.String weightCol, int aggregationDepth)  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.util.MLReader<org.apache.spark.ml.r.LinearSVCWrapper> read ()  { throw new RuntimeException(); }
  static public  org.apache.spark.ml.r.LinearSVCWrapper load (java.lang.String path)  { throw new RuntimeException(); }
  static public  void save (java.lang.String path) throws java.io.IOException { throw new RuntimeException(); }
  public  org.apache.spark.ml.PipelineModel pipeline ()  { throw new RuntimeException(); }
  public  java.lang.String[] features ()  { throw new RuntimeException(); }
  public  java.lang.String[] labels ()  { throw new RuntimeException(); }
  // not preceding
  private   LinearSVCWrapper (org.apache.spark.ml.PipelineModel pipeline, java.lang.String[] features, java.lang.String[] labels)  { throw new RuntimeException(); }
  private  org.apache.spark.ml.classification.LinearSVCModel svcModel ()  { throw new RuntimeException(); }
  public  double[] coefficients ()  { throw new RuntimeException(); }
  public  double intercept ()  { throw new RuntimeException(); }
  public  int numClasses ()  { throw new RuntimeException(); }
  public  int numFeatures ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> transform (org.apache.spark.sql.Dataset<?> dataset)  { throw new RuntimeException(); }
  public  org.apache.spark.ml.util.MLWriter write ()  { throw new RuntimeException(); }
}
