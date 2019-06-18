package org.apache.spark.security;
/**
 * A util class for manipulating IO encryption and decryption streams.
 */
public  class CryptoStreamUtils {
  /**
   * This class is a workaround for CRYPTO-125, that forces all bytes to be written to the
   * underlying channel. Since the callers of this API are using blocking I/O, there are no
   * concerns with regards to CPU usage here.
   */
  static private  class CryptoHelperChannel implements java.nio.channels.WritableByteChannel {
    public   CryptoHelperChannel (java.nio.channels.WritableByteChannel sink)  { throw new RuntimeException(); }
    public  int write (java.nio.ByteBuffer src)  { throw new RuntimeException(); }
    public  boolean isOpen ()  { throw new RuntimeException(); }
    public  void close ()  { throw new RuntimeException(); }
  }
  static private  class CryptoParams {
    public   CryptoParams (byte[] key, org.apache.spark.SparkConf sparkConf)  { throw new RuntimeException(); }
    public  javax.crypto.spec.SecretKeySpec keySpec ()  { throw new RuntimeException(); }
    public  java.lang.String transformation ()  { throw new RuntimeException(); }
    public  java.util.Properties conf ()  { throw new RuntimeException(); }
  }
  static public  int IV_LENGTH_IN_BYTES ()  { throw new RuntimeException(); }
  static public  java.lang.String SPARK_IO_ENCRYPTION_COMMONS_CONFIG_PREFIX ()  { throw new RuntimeException(); }
  /**
   * Helper method to wrap <code>OutputStream</code> with <code>CryptoOutputStream</code> for encryption.
   * @param os (undocumented)
   * @param sparkConf (undocumented)
   * @param key (undocumented)
   * @return (undocumented)
   */
  static public  java.io.OutputStream createCryptoOutputStream (java.io.OutputStream os, org.apache.spark.SparkConf sparkConf, byte[] key)  { throw new RuntimeException(); }
  /**
   * Wrap a <code>WritableByteChannel</code> for encryption.
   * @param channel (undocumented)
   * @param sparkConf (undocumented)
   * @param key (undocumented)
   * @return (undocumented)
   */
  static public  java.nio.channels.WritableByteChannel createWritableChannel (java.nio.channels.WritableByteChannel channel, org.apache.spark.SparkConf sparkConf, byte[] key)  { throw new RuntimeException(); }
  /**
   * Helper method to wrap <code>InputStream</code> with <code>CryptoInputStream</code> for decryption.
   * @param is (undocumented)
   * @param sparkConf (undocumented)
   * @param key (undocumented)
   * @return (undocumented)
   */
  static public  java.io.InputStream createCryptoInputStream (java.io.InputStream is, org.apache.spark.SparkConf sparkConf, byte[] key)  { throw new RuntimeException(); }
  /**
   * Wrap a <code>ReadableByteChannel</code> for decryption.
   * @param channel (undocumented)
   * @param sparkConf (undocumented)
   * @param key (undocumented)
   * @return (undocumented)
   */
  static public  java.nio.channels.ReadableByteChannel createReadableChannel (java.nio.channels.ReadableByteChannel channel, org.apache.spark.SparkConf sparkConf, byte[] key)  { throw new RuntimeException(); }
  static public  java.util.Properties toCryptoConf (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  /**
   * Creates a new encryption key.
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  byte[] createKey (org.apache.spark.SparkConf conf)  { throw new RuntimeException(); }
  /**
   * This method to generate an IV (Initialization Vector) using secure random.
   * @param properties (undocumented)
   * @return (undocumented)
   */
  static private  byte[] createInitializationVector (java.util.Properties properties)  { throw new RuntimeException(); }
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
}
