package org.apache.spark.streaming.api.python;
/**
 * Base class for PythonDStream with some common methods
 */
 abstract class PythonDStream extends org.apache.spark.streaming.dstream.DStream<byte[]> {
  /**
   * can not access PythonTransformFunctionSerializer.register() via Py4j
   * Py4JError: PythonTransformFunctionSerializerregister does not exist in the JVM
   * @param ser (undocumented)
   */
  static public  void registerSerializer (org.apache.spark.streaming.api.python.PythonTransformFunctionSerializer ser)  { throw new RuntimeException(); }
  /**
   * helper function for DStream.foreachRDD(),
   * cannot be <code>foreachRDD</code>, it will confusing py4j
   * @param jdstream (undocumented)
   * @param pfunc (undocumented)
   */
  static public  void callForeachRDD (org.apache.spark.streaming.api.java.JavaDStream<byte[]> jdstream, org.apache.spark.streaming.api.python.PythonTransformFunction pfunc)  { throw new RuntimeException(); }
  /**
   * convert list of RDD into queue of RDDs, for ssc.queueStream()
   * @param rdds (undocumented)
   * @return (undocumented)
   */
  static public  java.util.Queue<org.apache.spark.api.java.JavaRDD<byte[]>> toRDDQueue (java.util.ArrayList<org.apache.spark.api.java.JavaRDD<byte[]>> rdds)  { throw new RuntimeException(); }
  /**
   * Stop {@link StreamingContext} if the Python process crashes (E.g., OOM) in case the user cannot
   * stop it in the Python side.
   * @param e (undocumented)
   */
  static public  void stopStreamingContextIfPythonProcessIsDead (java.lang.Throwable e)  { throw new RuntimeException(); }
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
  static   org.apache.spark.streaming.StreamingContext ssc ()  { throw new RuntimeException(); }
  static   void ssc_$eq (org.apache.spark.streaming.StreamingContext x$1)  { throw new RuntimeException(); }
  static public abstract  scala.Option<org.apache.spark.rdd.RDD<T>> compute (org.apache.spark.streaming.Time validTime)  ;
  static   scala.collection.mutable.HashMap<org.apache.spark.streaming.Time, org.apache.spark.rdd.RDD<T>> generatedRDDs ()  { throw new RuntimeException(); }
  static   void generatedRDDs_$eq (scala.collection.mutable.HashMap<org.apache.spark.streaming.Time, org.apache.spark.rdd.RDD<T>> x$1)  { throw new RuntimeException(); }
  static   org.apache.spark.streaming.Time zeroTime ()  { throw new RuntimeException(); }
  static   void zeroTime_$eq (org.apache.spark.streaming.Time x$1)  { throw new RuntimeException(); }
  static   org.apache.spark.streaming.Duration rememberDuration ()  { throw new RuntimeException(); }
  static   void rememberDuration_$eq (org.apache.spark.streaming.Duration x$1)  { throw new RuntimeException(); }
  static   org.apache.spark.storage.StorageLevel storageLevel ()  { throw new RuntimeException(); }
  static   void storageLevel_$eq (org.apache.spark.storage.StorageLevel x$1)  { throw new RuntimeException(); }
  static   boolean mustCheckpoint ()  { throw new RuntimeException(); }
  static   org.apache.spark.streaming.Duration checkpointDuration ()  { throw new RuntimeException(); }
  static   void checkpointDuration_$eq (org.apache.spark.streaming.Duration x$1)  { throw new RuntimeException(); }
  static   org.apache.spark.streaming.dstream.DStreamCheckpointData<T> checkpointData ()  { throw new RuntimeException(); }
  static   org.apache.spark.streaming.DStreamGraph graph ()  { throw new RuntimeException(); }
  static   void graph_$eq (org.apache.spark.streaming.DStreamGraph x$1)  { throw new RuntimeException(); }
  static   boolean isInitialized ()  { throw new RuntimeException(); }
  static   org.apache.spark.streaming.Duration parentRememberDuration ()  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.StreamingContext context ()  { throw new RuntimeException(); }
  static   org.apache.spark.util.CallSite creationSite ()  { throw new RuntimeException(); }
  static protected  scala.Option<java.lang.String> baseScope ()  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<T> persist (org.apache.spark.storage.StorageLevel level)  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<T> persist ()  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<T> cache ()  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<T> checkpoint (org.apache.spark.streaming.Duration interval)  { throw new RuntimeException(); }
  static   void initialize (org.apache.spark.streaming.Time time)  { throw new RuntimeException(); }
  static   void validateAtStart ()  { throw new RuntimeException(); }
  static   void setContext (org.apache.spark.streaming.StreamingContext s)  { throw new RuntimeException(); }
  static   void setGraph (org.apache.spark.streaming.DStreamGraph g)  { throw new RuntimeException(); }
  static   void remember (org.apache.spark.streaming.Duration duration)  { throw new RuntimeException(); }
  static   boolean isTimeValid (org.apache.spark.streaming.Time time)  { throw new RuntimeException(); }
  static  final  scala.Option<org.apache.spark.rdd.RDD<T>> getOrCompute (org.apache.spark.streaming.Time time)  { throw new RuntimeException(); }
  static protected <U extends java.lang.Object> U createRDDWithLocalProperties (org.apache.spark.streaming.Time time, boolean displayInnerRDDOps, scala.Function0<U> body)  { throw new RuntimeException(); }
  static   scala.Option<org.apache.spark.streaming.scheduler.Job> generateJob (org.apache.spark.streaming.Time time)  { throw new RuntimeException(); }
  static   void clearMetadata (org.apache.spark.streaming.Time time)  { throw new RuntimeException(); }
  static   void updateCheckpointData (org.apache.spark.streaming.Time currentTime)  { throw new RuntimeException(); }
  static   void clearCheckpointData (org.apache.spark.streaming.Time time)  { throw new RuntimeException(); }
  static   void restoreCheckpointData ()  { throw new RuntimeException(); }
  static public <U extends java.lang.Object> org.apache.spark.streaming.dstream.DStream<U> map (scala.Function1<T, U> mapFunc, scala.reflect.ClassTag<U> evidence$2)  { throw new RuntimeException(); }
  static public <U extends java.lang.Object> org.apache.spark.streaming.dstream.DStream<U> flatMap (scala.Function1<T, scala.collection.TraversableOnce<U>> flatMapFunc, scala.reflect.ClassTag<U> evidence$3)  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<T> filter (scala.Function1<T, java.lang.Object> filterFunc)  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<java.lang.Object> glom ()  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<T> repartition (int numPartitions)  { throw new RuntimeException(); }
  static public <U extends java.lang.Object> org.apache.spark.streaming.dstream.DStream<U> mapPartitions (scala.Function1<scala.collection.Iterator<T>, scala.collection.Iterator<U>> mapPartFunc, boolean preservePartitioning, scala.reflect.ClassTag<U> evidence$4)  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<T> reduce (scala.Function2<T, T, T> reduceFunc)  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<java.lang.Object> count ()  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<scala.Tuple2<T, java.lang.Object>> countByValue (int numPartitions, scala.math.Ordering<T> ord)  { throw new RuntimeException(); }
  static public  void foreachRDD (scala.Function1<org.apache.spark.rdd.RDD<T>, scala.runtime.BoxedUnit> foreachFunc)  { throw new RuntimeException(); }
  static public  void foreachRDD (scala.Function2<org.apache.spark.rdd.RDD<T>, org.apache.spark.streaming.Time, scala.runtime.BoxedUnit> foreachFunc)  { throw new RuntimeException(); }
  static public <U extends java.lang.Object> org.apache.spark.streaming.dstream.DStream<U> transform (scala.Function1<org.apache.spark.rdd.RDD<T>, org.apache.spark.rdd.RDD<U>> transformFunc, scala.reflect.ClassTag<U> evidence$5)  { throw new RuntimeException(); }
  static public <U extends java.lang.Object> org.apache.spark.streaming.dstream.DStream<U> transform (scala.Function2<org.apache.spark.rdd.RDD<T>, org.apache.spark.streaming.Time, org.apache.spark.rdd.RDD<U>> transformFunc, scala.reflect.ClassTag<U> evidence$6)  { throw new RuntimeException(); }
  static public <U extends java.lang.Object, V extends java.lang.Object> org.apache.spark.streaming.dstream.DStream<V> transformWith (org.apache.spark.streaming.dstream.DStream<U> other, scala.Function2<org.apache.spark.rdd.RDD<T>, org.apache.spark.rdd.RDD<U>, org.apache.spark.rdd.RDD<V>> transformFunc, scala.reflect.ClassTag<U> evidence$7, scala.reflect.ClassTag<V> evidence$8)  { throw new RuntimeException(); }
  static public <U extends java.lang.Object, V extends java.lang.Object> org.apache.spark.streaming.dstream.DStream<V> transformWith (org.apache.spark.streaming.dstream.DStream<U> other, scala.Function3<org.apache.spark.rdd.RDD<T>, org.apache.spark.rdd.RDD<U>, org.apache.spark.streaming.Time, org.apache.spark.rdd.RDD<V>> transformFunc, scala.reflect.ClassTag<U> evidence$9, scala.reflect.ClassTag<V> evidence$10)  { throw new RuntimeException(); }
  static public  void print ()  { throw new RuntimeException(); }
  static public  void print (int num)  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<T> window (org.apache.spark.streaming.Duration windowDuration)  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<T> window (org.apache.spark.streaming.Duration windowDuration, org.apache.spark.streaming.Duration slideDuration)  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<T> reduceByWindow (scala.Function2<T, T, T> reduceFunc, org.apache.spark.streaming.Duration windowDuration, org.apache.spark.streaming.Duration slideDuration)  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<T> reduceByWindow (scala.Function2<T, T, T> reduceFunc, scala.Function2<T, T, T> invReduceFunc, org.apache.spark.streaming.Duration windowDuration, org.apache.spark.streaming.Duration slideDuration)  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<java.lang.Object> countByWindow (org.apache.spark.streaming.Duration windowDuration, org.apache.spark.streaming.Duration slideDuration)  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<scala.Tuple2<T, java.lang.Object>> countByValueAndWindow (org.apache.spark.streaming.Duration windowDuration, org.apache.spark.streaming.Duration slideDuration, int numPartitions, scala.math.Ordering<T> ord)  { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.dstream.DStream<T> union (org.apache.spark.streaming.dstream.DStream<T> that)  { throw new RuntimeException(); }
  static public  scala.collection.Seq<org.apache.spark.rdd.RDD<T>> slice (org.apache.spark.streaming.Interval interval)  { throw new RuntimeException(); }
  static public  scala.collection.Seq<org.apache.spark.rdd.RDD<T>> slice (org.apache.spark.streaming.Time fromTime, org.apache.spark.streaming.Time toTime)  { throw new RuntimeException(); }
  static public  void saveAsObjectFiles (java.lang.String prefix, java.lang.String suffix)  { throw new RuntimeException(); }
  static public  void saveAsTextFiles (java.lang.String prefix, java.lang.String suffix)  { throw new RuntimeException(); }
  static   org.apache.spark.streaming.dstream.DStream<T> register ()  { throw new RuntimeException(); }
  static public  int countByValue$default$1 ()  { throw new RuntimeException(); }
  static public  scala.math.Ordering<T> countByValue$default$2 (int numPartitions)  { throw new RuntimeException(); }
  static public  int countByValueAndWindow$default$3 ()  { throw new RuntimeException(); }
  static public  scala.math.Ordering<T> countByValueAndWindow$default$4 (org.apache.spark.streaming.Duration windowDuration, org.apache.spark.streaming.Duration slideDuration, int numPartitions)  { throw new RuntimeException(); }
  static public <U extends java.lang.Object> boolean mapPartitions$default$2 ()  { throw new RuntimeException(); }
  static public  java.lang.String saveAsObjectFiles$default$2 ()  { throw new RuntimeException(); }
  static public  java.lang.String saveAsTextFiles$default$2 ()  { throw new RuntimeException(); }
  public   PythonDStream (org.apache.spark.streaming.dstream.DStream<?> parent, org.apache.spark.streaming.api.python.PythonTransformFunction pfunc)  { throw new RuntimeException(); }
  public  org.apache.spark.streaming.api.python.TransformFunction func ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.List<org.apache.spark.streaming.dstream.DStream<?>> dependencies ()  { throw new RuntimeException(); }
  public  org.apache.spark.streaming.Duration slideDuration ()  { throw new RuntimeException(); }
  public  org.apache.spark.streaming.api.java.JavaDStream<byte[]> asJavaDStream ()  { throw new RuntimeException(); }
}
