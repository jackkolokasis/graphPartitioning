package org.apache.spark.deploy;
/**
 * Main gateway of launching a Spark application.
 * <p>
 * This program handles setting up the classpath with relevant Spark dependencies and provides
 * a layer over the different cluster managers and deploy modes that Spark supports.
 */
public  class SparkSubmit$ implements org.apache.spark.util.CommandLineUtils {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SparkSubmit$ MODULE$ = null;
  public   SparkSubmit$ ()  { throw new RuntimeException(); }
  private  int YARN ()  { throw new RuntimeException(); }
  private  int STANDALONE ()  { throw new RuntimeException(); }
  private  int MESOS ()  { throw new RuntimeException(); }
  private  int LOCAL ()  { throw new RuntimeException(); }
  private  int ALL_CLUSTER_MGRS ()  { throw new RuntimeException(); }
  private  int CLIENT ()  { throw new RuntimeException(); }
  private  int CLUSTER ()  { throw new RuntimeException(); }
  private  int ALL_DEPLOY_MODES ()  { throw new RuntimeException(); }
  private  java.lang.String SPARK_SHELL ()  { throw new RuntimeException(); }
  private  java.lang.String PYSPARK_SHELL ()  { throw new RuntimeException(); }
  private  java.lang.String SPARKR_SHELL ()  { throw new RuntimeException(); }
  private  java.lang.String SPARKR_PACKAGE_ARCHIVE ()  { throw new RuntimeException(); }
  private  java.lang.String R_PACKAGE_ARCHIVE ()  { throw new RuntimeException(); }
  private  int CLASS_NOT_FOUND_EXIT_STATUS ()  { throw new RuntimeException(); }
    void printVersionAndExit ()  { throw new RuntimeException(); }
  public  void main (java.lang.String[] args)  { throw new RuntimeException(); }
  /**
   * Kill an existing submission using the REST protocol. Standalone and Mesos cluster mode only.
   * @param args (undocumented)
   */
  private  void kill (org.apache.spark.deploy.SparkSubmitArguments args)  { throw new RuntimeException(); }
  /**
   * Request the status of an existing submission using the REST protocol.
   * Standalone and Mesos cluster mode only.
   * @param args (undocumented)
   */
  private  void requestStatus (org.apache.spark.deploy.SparkSubmitArguments args)  { throw new RuntimeException(); }
  /**
   * Submit the application using the provided parameters.
   * <p>
   * This runs in two steps. First, we prepare the launch environment by setting up
   * the appropriate classpath, system properties, and application arguments for
   * running the child main class based on the cluster manager and the deploy mode.
   * Second, we use this launch environment to invoke the main method of the child
   * main class.
   * @param args (undocumented)
   */
  private  void submit (org.apache.spark.deploy.SparkSubmitArguments args)  { throw new RuntimeException(); }
  /**
   * Prepare the environment for submitting an application.
   * This returns a 4-tuple:
   *   (1) the arguments for the child process,
   *   (2) a list of classpath entries for the child,
   *   (3) a map of system properties, and
   *   (4) the main class for the child
   * Exposed for testing.
   * @param args (undocumented)
   * @return (undocumented)
   */
    scala.Tuple4<scala.collection.Seq<java.lang.String>, scala.collection.Seq<java.lang.String>, scala.collection.mutable.Map<java.lang.String, java.lang.String>, java.lang.String> prepareSubmitEnvironment (org.apache.spark.deploy.SparkSubmitArguments args)  { throw new RuntimeException(); }
  /**
   * Run the main method of the child class using the provided launch environment.
   * <p>
   * Note that this main class will not be the one provided by the user if we're
   * running cluster deploy mode or python applications.
   * @param childArgs (undocumented)
   * @param childClasspath (undocumented)
   * @param sysProps (undocumented)
   * @param childMainClass (undocumented)
   * @param verbose (undocumented)
   */
  private  void runMain (scala.collection.Seq<java.lang.String> childArgs, scala.collection.Seq<java.lang.String> childClasspath, scala.collection.mutable.Map<java.lang.String, java.lang.String> sysProps, java.lang.String childMainClass, boolean verbose)  { throw new RuntimeException(); }
  private  void addJarToClasspath (java.lang.String localJar, org.apache.spark.util.MutableURLClassLoader loader)  { throw new RuntimeException(); }
  /**
   * Return whether the given primary resource represents a user jar.
   * @param res (undocumented)
   * @return (undocumented)
   */
    boolean isUserJar (java.lang.String res)  { throw new RuntimeException(); }
  /**
   * Return whether the given primary resource represents a shell.
   * @param res (undocumented)
   * @return (undocumented)
   */
    boolean isShell (java.lang.String res)  { throw new RuntimeException(); }
  /**
   * Return whether the given main class represents a sql shell.
   * @param mainClass (undocumented)
   * @return (undocumented)
   */
    boolean isSqlShell (java.lang.String mainClass)  { throw new RuntimeException(); }
  /**
   * Return whether the given main class represents a thrift server.
   * @param mainClass (undocumented)
   * @return (undocumented)
   */
  private  boolean isThriftServer (java.lang.String mainClass)  { throw new RuntimeException(); }
  /**
   * Return whether the given primary resource requires running python.
   * @param res (undocumented)
   * @return (undocumented)
   */
    boolean isPython (java.lang.String res)  { throw new RuntimeException(); }
  /**
   * Return whether the given primary resource requires running R.
   * @param res (undocumented)
   * @return (undocumented)
   */
    boolean isR (java.lang.String res)  { throw new RuntimeException(); }
    boolean isInternal (java.lang.String res)  { throw new RuntimeException(); }
  /**
   * Merge a sequence of comma-separated file lists, some of which may be null to indicate
   * no files, into a single comma-separated string.
   * @param lists (undocumented)
   * @return (undocumented)
   */
  private  java.lang.String mergeFileLists (scala.collection.Seq<java.lang.String> lists)  { throw new RuntimeException(); }
}
