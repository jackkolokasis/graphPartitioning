package org.apache.spark.sql.catalyst.util;
/**
 * Exception thrown when the underlying parser meet a bad record and can't parse it.
 * param:  record a function to return the record that cause the parser to fail
 * param:  partialResult a function that returns an optional row, which is the partial result of
 *                      parsing this bad record.
 * param:  cause the actual exception about why the record is bad and can't be parsed.
 */
public  class BadRecordException extends java.lang.Exception implements scala.Product, scala.Serializable {
  static public  java.lang.String getMessage ()  { throw new RuntimeException(); }
  static public  java.lang.String getLocalizedMessage ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable getCause ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable initCause (java.lang.Throwable x$1)  { throw new RuntimeException(); }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  static public  void printStackTrace ()  { throw new RuntimeException(); }
  static public  void printStackTrace (java.io.PrintStream x$1)  { throw new RuntimeException(); }
  static public  void printStackTrace (java.io.PrintWriter x$1)  { throw new RuntimeException(); }
  static public  java.lang.Throwable fillInStackTrace ()  { throw new RuntimeException(); }
  static public  java.lang.StackTraceElement[] getStackTrace ()  { throw new RuntimeException(); }
  static public  void setStackTrace (java.lang.StackTraceElement[] x$1)  { throw new RuntimeException(); }
  static   int getStackTraceDepth ()  { throw new RuntimeException(); }
  static   java.lang.StackTraceElement getStackTraceElement (int x$1)  { throw new RuntimeException(); }
  static public final  void addSuppressed (java.lang.Throwable x$1)  { throw new RuntimeException(); }
  static public final  java.lang.Throwable[] getSuppressed ()  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  public  scala.Function0<org.apache.spark.unsafe.types.UTF8String> record ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.Option<org.apache.spark.sql.catalyst.InternalRow>> partialResult ()  { throw new RuntimeException(); }
  public  java.lang.Throwable cause ()  { throw new RuntimeException(); }
  // not preceding
  public   BadRecordException (scala.Function0<org.apache.spark.unsafe.types.UTF8String> record, scala.Function0<scala.Option<org.apache.spark.sql.catalyst.InternalRow>> partialResult, java.lang.Throwable cause)  { throw new RuntimeException(); }
}
