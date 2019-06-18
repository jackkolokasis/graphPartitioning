package org.apache.spark.util;
/**
 * Contains basic command line parsing functionality and methods to parse some common Spark CLI
 * options.
 */
  interface CommandLineUtils {
    scala.Function1<java.lang.Object, scala.runtime.BoxedUnit> exitFn ()  ;
    java.io.PrintStream printStream ()  ;
    void printWarning (java.lang.String str)  ;
    void printErrorAndExit (java.lang.String str)  ;
    scala.Tuple2<java.lang.String, java.lang.String> parseSparkConfProperty (java.lang.String pair)  ;
  public  void main (java.lang.String[] args)  ;
}
