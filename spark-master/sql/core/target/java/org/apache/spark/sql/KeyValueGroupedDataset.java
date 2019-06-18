package org.apache.spark.sql;
/**
 * :: Experimental ::
 * A {@link Dataset} has been logically grouped by a user specified grouping key.  Users should not
 * construct a {@link KeyValueGroupedDataset} directly, but should instead call <code>groupByKey</code> on
 * an existing {@link Dataset}.
 * <p>
 * @since 2.0.0
 */
public  class KeyValueGroupedDataset<K extends java.lang.Object, V extends java.lang.Object> implements scala.Serializable {
  public  org.apache.spark.sql.execution.QueryExecution queryExecution ()  { throw new RuntimeException(); }
  private  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes ()  { throw new RuntimeException(); }
  private  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes ()  { throw new RuntimeException(); }
  // not preceding
     KeyValueGroupedDataset (org.apache.spark.sql.Encoder<K> kEncoder, org.apache.spark.sql.Encoder<V> vEncoder, org.apache.spark.sql.execution.QueryExecution queryExecution, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes)  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<K> kExprEnc ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<V> vExprEnc ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan ()  { throw new RuntimeException(); }
  private  org.apache.spark.sql.SparkSession sparkSession ()  { throw new RuntimeException(); }
  /**
   * Returns a new {@link KeyValueGroupedDataset} where the type of the key has been mapped to the
   * specified type. The mapping of key columns to the type follows the same rules as <code>as</code> on
   * {@link Dataset}.
   * <p>
   * @since 1.6.0
   * @param evidence$1 (undocumented)
   * @return (undocumented)
   */
  public <L extends java.lang.Object> org.apache.spark.sql.KeyValueGroupedDataset<L, V> keyAs (org.apache.spark.sql.Encoder<L> evidence$1)  { throw new RuntimeException(); }
  /**
   * Returns a new {@link KeyValueGroupedDataset} where the given function <code>func</code> has been applied
   * to the data. The grouping key is unchanged by this.
   * <p>
   * <pre><code>
   *   // Create values grouped by key from a Dataset[(K, V)]
   *   ds.groupByKey(_._1).mapValues(_._2) // Scala
   * </code></pre>
   * <p>
   * @since 2.1.0
   * @param func (undocumented)
   * @param evidence$2 (undocumented)
   * @return (undocumented)
   */
  public <W extends java.lang.Object> org.apache.spark.sql.KeyValueGroupedDataset<K, W> mapValues (scala.Function1<V, W> func, org.apache.spark.sql.Encoder<W> evidence$2)  { throw new RuntimeException(); }
  /**
   * Returns a new {@link KeyValueGroupedDataset} where the given function <code>func</code> has been applied
   * to the data. The grouping key is unchanged by this.
   * <p>
   * <pre><code>
   *   // Create Integer values grouped by String key from a Dataset&lt;Tuple2&lt;String, Integer&gt;&gt;
   *   Dataset&lt;Tuple2&lt;String, Integer&gt;&gt; ds = ...;
   *   KeyValueGroupedDataset&lt;String, Integer&gt; grouped =
   *     ds.groupByKey(t -&gt; t._1, Encoders.STRING()).mapValues(t -&gt; t._2, Encoders.INT());
   * </code></pre>
   * <p>
   * @since 2.1.0
   * @param func (undocumented)
   * @param encoder (undocumented)
   * @return (undocumented)
   */
  public <W extends java.lang.Object> org.apache.spark.sql.KeyValueGroupedDataset<K, W> mapValues (org.apache.spark.api.java.function.MapFunction<V, W> func, org.apache.spark.sql.Encoder<W> encoder)  { throw new RuntimeException(); }
  /**
   * Returns a {@link Dataset} that contains each unique key. This is equivalent to doing mapping
   * over the Dataset to extract the keys and then running a distinct operation on those.
   * <p>
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<K> keys ()  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Applies the given function to each group of data.  For each unique group, the function will
   * be passed the group key and an iterator that contains all of the elements in the group. The
   * function can return an iterator containing elements of an arbitrary type which will be returned
   * as a new {@link Dataset}.
   * <p>
   * This function does not support partial aggregation, and as a result requires shuffling all
   * the data in the {@link Dataset}. If an application intends to perform an aggregation over each
   * key, it is best to use the reduce function or an
   * <code>org.apache.spark.sql.expressions#Aggregator</code>.
   * <p>
   * Internally, the implementation will spill to disk if any given group is too large to fit into
   * memory.  However, users must take care to avoid materializing the whole iterator for a group
   * (for example, by calling <code>toList</code>) unless they are sure that this is possible given the memory
   * constraints of their cluster.
   * <p>
   * @since 1.6.0
   * @param f (undocumented)
   * @param evidence$3 (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<U> flatMapGroups (scala.Function2<K, scala.collection.Iterator<V>, scala.collection.TraversableOnce<U>> f, org.apache.spark.sql.Encoder<U> evidence$3)  { throw new RuntimeException(); }
  /**
   * (Java-specific)
   * Applies the given function to each group of data.  For each unique group, the function will
   * be passed the group key and an iterator that contains all of the elements in the group. The
   * function can return an iterator containing elements of an arbitrary type which will be returned
   * as a new {@link Dataset}.
   * <p>
   * This function does not support partial aggregation, and as a result requires shuffling all
   * the data in the {@link Dataset}. If an application intends to perform an aggregation over each
   * key, it is best to use the reduce function or an
   * <code>org.apache.spark.sql.expressions#Aggregator</code>.
   * <p>
   * Internally, the implementation will spill to disk if any given group is too large to fit into
   * memory.  However, users must take care to avoid materializing the whole iterator for a group
   * (for example, by calling <code>toList</code>) unless they are sure that this is possible given the memory
   * constraints of their cluster.
   * <p>
   * @since 1.6.0
   * @param f (undocumented)
   * @param encoder (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<U> flatMapGroups (org.apache.spark.api.java.function.FlatMapGroupsFunction<K, V, U> f, org.apache.spark.sql.Encoder<U> encoder)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Applies the given function to each group of data.  For each unique group, the function will
   * be passed the group key and an iterator that contains all of the elements in the group. The
   * function can return an element of arbitrary type which will be returned as a new {@link Dataset}.
   * <p>
   * This function does not support partial aggregation, and as a result requires shuffling all
   * the data in the {@link Dataset}. If an application intends to perform an aggregation over each
   * key, it is best to use the reduce function or an
   * <code>org.apache.spark.sql.expressions#Aggregator</code>.
   * <p>
   * Internally, the implementation will spill to disk if any given group is too large to fit into
   * memory.  However, users must take care to avoid materializing the whole iterator for a group
   * (for example, by calling <code>toList</code>) unless they are sure that this is possible given the memory
   * constraints of their cluster.
   * <p>
   * @since 1.6.0
   * @param f (undocumented)
   * @param evidence$4 (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<U> mapGroups (scala.Function2<K, scala.collection.Iterator<V>, U> f, org.apache.spark.sql.Encoder<U> evidence$4)  { throw new RuntimeException(); }
  /**
   * (Java-specific)
   * Applies the given function to each group of data.  For each unique group, the function will
   * be passed the group key and an iterator that contains all of the elements in the group. The
   * function can return an element of arbitrary type which will be returned as a new {@link Dataset}.
   * <p>
   * This function does not support partial aggregation, and as a result requires shuffling all
   * the data in the {@link Dataset}. If an application intends to perform an aggregation over each
   * key, it is best to use the reduce function or an
   * <code>org.apache.spark.sql.expressions#Aggregator</code>.
   * <p>
   * Internally, the implementation will spill to disk if any given group is too large to fit into
   * memory.  However, users must take care to avoid materializing the whole iterator for a group
   * (for example, by calling <code>toList</code>) unless they are sure that this is possible given the memory
   * constraints of their cluster.
   * <p>
   * @since 1.6.0
   * @param f (undocumented)
   * @param encoder (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<U> mapGroups (org.apache.spark.api.java.function.MapGroupsFunction<K, V, U> f, org.apache.spark.sql.Encoder<U> encoder)  { throw new RuntimeException(); }
  /**
   * ::Experimental::
   * (Scala-specific)
   * Applies the given function to each group of data, while maintaining a user-defined per-group
   * state. The result Dataset will represent the objects returned by the function.
   * For a static batch Dataset, the function will be invoked once per group. For a streaming
   * Dataset, the function will be invoked for each group repeatedly in every trigger, and
   * updates to each group's state will be saved across invocations.
   * See {@link org.apache.spark.sql.streaming.GroupState} for more details.
   * <p>
   * @tparam S The type of the user-defined state. Must be encodable to Spark SQL types.
   * @tparam U The type of the output objects. Must be encodable to Spark SQL types.
   * @param func Function to be called on every group.
   * <p>
   * See {@link Encoder} for more details on what types are encodable to Spark SQL.
   * @since 2.2.0
   * @param evidence$5 (undocumented)
   * @param evidence$6 (undocumented)
   * @return (undocumented)
   */
  public <S extends java.lang.Object, U extends java.lang.Object> org.apache.spark.sql.Dataset<U> mapGroupsWithState (scala.Function3<K, scala.collection.Iterator<V>, org.apache.spark.sql.streaming.GroupState<S>, U> func, org.apache.spark.sql.Encoder<S> evidence$5, org.apache.spark.sql.Encoder<U> evidence$6)  { throw new RuntimeException(); }
  /**
   * ::Experimental::
   * (Scala-specific)
   * Applies the given function to each group of data, while maintaining a user-defined per-group
   * state. The result Dataset will represent the objects returned by the function.
   * For a static batch Dataset, the function will be invoked once per group. For a streaming
   * Dataset, the function will be invoked for each group repeatedly in every trigger, and
   * updates to each group's state will be saved across invocations.
   * See {@link org.apache.spark.sql.streaming.GroupState} for more details.
   * <p>
   * @tparam S The type of the user-defined state. Must be encodable to Spark SQL types.
   * @tparam U The type of the output objects. Must be encodable to Spark SQL types.
   * @param func Function to be called on every group.
   * @param timeoutConf Timeout configuration for groups that do not receive data for a while.
   * <p>
   * See {@link Encoder} for more details on what types are encodable to Spark SQL.
   * @since 2.2.0
   * @param evidence$7 (undocumented)
   * @param evidence$8 (undocumented)
   * @return (undocumented)
   */
  public <S extends java.lang.Object, U extends java.lang.Object> org.apache.spark.sql.Dataset<U> mapGroupsWithState (org.apache.spark.sql.streaming.GroupStateTimeout timeoutConf, scala.Function3<K, scala.collection.Iterator<V>, org.apache.spark.sql.streaming.GroupState<S>, U> func, org.apache.spark.sql.Encoder<S> evidence$7, org.apache.spark.sql.Encoder<U> evidence$8)  { throw new RuntimeException(); }
  /**
   * ::Experimental::
   * (Java-specific)
   * Applies the given function to each group of data, while maintaining a user-defined per-group
   * state. The result Dataset will represent the objects returned by the function.
   * For a static batch Dataset, the function will be invoked once per group. For a streaming
   * Dataset, the function will be invoked for each group repeatedly in every trigger, and
   * updates to each group's state will be saved across invocations.
   * See <code>GroupState</code> for more details.
   * <p>
   * @tparam S The type of the user-defined state. Must be encodable to Spark SQL types.
   * @tparam U The type of the output objects. Must be encodable to Spark SQL types.
   * @param func          Function to be called on every group.
   * @param stateEncoder  Encoder for the state type.
   * @param outputEncoder Encoder for the output type.
   * <p>
   * See {@link Encoder} for more details on what types are encodable to Spark SQL.
   * @since 2.2.0
   * @return (undocumented)
   */
  public <S extends java.lang.Object, U extends java.lang.Object> org.apache.spark.sql.Dataset<U> mapGroupsWithState (org.apache.spark.api.java.function.MapGroupsWithStateFunction<K, V, S, U> func, org.apache.spark.sql.Encoder<S> stateEncoder, org.apache.spark.sql.Encoder<U> outputEncoder)  { throw new RuntimeException(); }
  /**
   * ::Experimental::
   * (Java-specific)
   * Applies the given function to each group of data, while maintaining a user-defined per-group
   * state. The result Dataset will represent the objects returned by the function.
   * For a static batch Dataset, the function will be invoked once per group. For a streaming
   * Dataset, the function will be invoked for each group repeatedly in every trigger, and
   * updates to each group's state will be saved across invocations.
   * See <code>GroupState</code> for more details.
   * <p>
   * @tparam S The type of the user-defined state. Must be encodable to Spark SQL types.
   * @tparam U The type of the output objects. Must be encodable to Spark SQL types.
   * @param func          Function to be called on every group.
   * @param stateEncoder  Encoder for the state type.
   * @param outputEncoder Encoder for the output type.
   * @param timeoutConf   Timeout configuration for groups that do not receive data for a while.
   * <p>
   * See {@link Encoder} for more details on what types are encodable to Spark SQL.
   * @since 2.2.0
   * @return (undocumented)
   */
  public <S extends java.lang.Object, U extends java.lang.Object> org.apache.spark.sql.Dataset<U> mapGroupsWithState (org.apache.spark.api.java.function.MapGroupsWithStateFunction<K, V, S, U> func, org.apache.spark.sql.Encoder<S> stateEncoder, org.apache.spark.sql.Encoder<U> outputEncoder, org.apache.spark.sql.streaming.GroupStateTimeout timeoutConf)  { throw new RuntimeException(); }
  /**
   * ::Experimental::
   * (Scala-specific)
   * Applies the given function to each group of data, while maintaining a user-defined per-group
   * state. The result Dataset will represent the objects returned by the function.
   * For a static batch Dataset, the function will be invoked once per group. For a streaming
   * Dataset, the function will be invoked for each group repeatedly in every trigger, and
   * updates to each group's state will be saved across invocations.
   * See <code>GroupState</code> for more details.
   * <p>
   * @tparam S The type of the user-defined state. Must be encodable to Spark SQL types.
   * @tparam U The type of the output objects. Must be encodable to Spark SQL types.
   * @param func Function to be called on every group.
   * @param outputMode The output mode of the function.
   * @param timeoutConf Timeout configuration for groups that do not receive data for a while.
   * <p>
   * See {@link Encoder} for more details on what types are encodable to Spark SQL.
   * @since 2.2.0
   * @param evidence$9 (undocumented)
   * @param evidence$10 (undocumented)
   * @return (undocumented)
   */
  public <S extends java.lang.Object, U extends java.lang.Object> org.apache.spark.sql.Dataset<U> flatMapGroupsWithState (org.apache.spark.sql.streaming.OutputMode outputMode, org.apache.spark.sql.streaming.GroupStateTimeout timeoutConf, scala.Function3<K, scala.collection.Iterator<V>, org.apache.spark.sql.streaming.GroupState<S>, scala.collection.Iterator<U>> func, org.apache.spark.sql.Encoder<S> evidence$9, org.apache.spark.sql.Encoder<U> evidence$10)  { throw new RuntimeException(); }
  /**
   * ::Experimental::
   * (Java-specific)
   * Applies the given function to each group of data, while maintaining a user-defined per-group
   * state. The result Dataset will represent the objects returned by the function.
   * For a static batch Dataset, the function will be invoked once per group. For a streaming
   * Dataset, the function will be invoked for each group repeatedly in every trigger, and
   * updates to each group's state will be saved across invocations.
   * See <code>GroupState</code> for more details.
   * <p>
   * @tparam S The type of the user-defined state. Must be encodable to Spark SQL types.
   * @tparam U The type of the output objects. Must be encodable to Spark SQL types.
   * @param func          Function to be called on every group.
   * @param outputMode    The output mode of the function.
   * @param stateEncoder  Encoder for the state type.
   * @param outputEncoder Encoder for the output type.
   * @param timeoutConf   Timeout configuration for groups that do not receive data for a while.
   * <p>
   * See {@link Encoder} for more details on what types are encodable to Spark SQL.
   * @since 2.2.0
   * @return (undocumented)
   */
  public <S extends java.lang.Object, U extends java.lang.Object> org.apache.spark.sql.Dataset<U> flatMapGroupsWithState (org.apache.spark.api.java.function.FlatMapGroupsWithStateFunction<K, V, S, U> func, org.apache.spark.sql.streaming.OutputMode outputMode, org.apache.spark.sql.Encoder<S> stateEncoder, org.apache.spark.sql.Encoder<U> outputEncoder, org.apache.spark.sql.streaming.GroupStateTimeout timeoutConf)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Reduces the elements of each group of data using the specified binary function.
   * The given function must be commutative and associative or the result may be non-deterministic.
   * <p>
   * @since 1.6.0
   * @param f (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<scala.Tuple2<K, V>> reduceGroups (scala.Function2<V, V, V> f)  { throw new RuntimeException(); }
  /**
   * (Java-specific)
   * Reduces the elements of each group of data using the specified binary function.
   * The given function must be commutative and associative or the result may be non-deterministic.
   * <p>
   * @since 1.6.0
   * @param f (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<scala.Tuple2<K, V>> reduceGroups (org.apache.spark.api.java.function.ReduceFunction<V> f)  { throw new RuntimeException(); }
  /**
   * Internal helper function for building typed aggregations that return tuples.  For simplicity
   * and code reuse, we do this without the help of the type system and then use helper functions
   * that cast appropriately for the user facing interface.
   * @param columns (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.Dataset<?> aggUntyped (scala.collection.Seq<org.apache.spark.sql.TypedColumn<?, ?>> columns)  { throw new RuntimeException(); }
  /**
   * Computes the given aggregation, returning a {@link Dataset} of tuples for each unique key
   * and the result of computing this aggregation over all elements in the group.
   * <p>
   * @since 1.6.0
   * @param col1 (undocumented)
   * @return (undocumented)
   */
  public <U1 extends java.lang.Object> org.apache.spark.sql.Dataset<scala.Tuple2<K, U1>> agg (org.apache.spark.sql.TypedColumn<V, U1> col1)  { throw new RuntimeException(); }
  /**
   * Computes the given aggregations, returning a {@link Dataset} of tuples for each unique key
   * and the result of computing these aggregations over all elements in the group.
   * <p>
   * @since 1.6.0
   * @param col1 (undocumented)
   * @param col2 (undocumented)
   * @return (undocumented)
   */
  public <U1 extends java.lang.Object, U2 extends java.lang.Object> org.apache.spark.sql.Dataset<scala.Tuple3<K, U1, U2>> agg (org.apache.spark.sql.TypedColumn<V, U1> col1, org.apache.spark.sql.TypedColumn<V, U2> col2)  { throw new RuntimeException(); }
  /**
   * Computes the given aggregations, returning a {@link Dataset} of tuples for each unique key
   * and the result of computing these aggregations over all elements in the group.
   * <p>
   * @since 1.6.0
   * @param col1 (undocumented)
   * @param col2 (undocumented)
   * @param col3 (undocumented)
   * @return (undocumented)
   */
  public <U1 extends java.lang.Object, U2 extends java.lang.Object, U3 extends java.lang.Object> org.apache.spark.sql.Dataset<scala.Tuple4<K, U1, U2, U3>> agg (org.apache.spark.sql.TypedColumn<V, U1> col1, org.apache.spark.sql.TypedColumn<V, U2> col2, org.apache.spark.sql.TypedColumn<V, U3> col3)  { throw new RuntimeException(); }
  /**
   * Computes the given aggregations, returning a {@link Dataset} of tuples for each unique key
   * and the result of computing these aggregations over all elements in the group.
   * <p>
   * @since 1.6.0
   * @param col1 (undocumented)
   * @param col2 (undocumented)
   * @param col3 (undocumented)
   * @param col4 (undocumented)
   * @return (undocumented)
   */
  public <U1 extends java.lang.Object, U2 extends java.lang.Object, U3 extends java.lang.Object, U4 extends java.lang.Object> org.apache.spark.sql.Dataset<scala.Tuple5<K, U1, U2, U3, U4>> agg (org.apache.spark.sql.TypedColumn<V, U1> col1, org.apache.spark.sql.TypedColumn<V, U2> col2, org.apache.spark.sql.TypedColumn<V, U3> col3, org.apache.spark.sql.TypedColumn<V, U4> col4)  { throw new RuntimeException(); }
  /**
   * Returns a {@link Dataset} that contains a tuple with each key and the number of items present
   * for that key.
   * <p>
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<scala.Tuple2<K, java.lang.Object>> count ()  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Applies the given function to each cogrouped data.  For each unique group, the function will
   * be passed the grouping key and 2 iterators containing all elements in the group from
   * {@link Dataset} <code>this</code> and <code>other</code>.  The function can return an iterator containing elements of an
   * arbitrary type which will be returned as a new {@link Dataset}.
   * <p>
   * @since 1.6.0
   * @param other (undocumented)
   * @param f (undocumented)
   * @param evidence$11 (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object, R extends java.lang.Object> org.apache.spark.sql.Dataset<R> cogroup (org.apache.spark.sql.KeyValueGroupedDataset<K, U> other, scala.Function3<K, scala.collection.Iterator<V>, scala.collection.Iterator<U>, scala.collection.TraversableOnce<R>> f, org.apache.spark.sql.Encoder<R> evidence$11)  { throw new RuntimeException(); }
  /**
   * (Java-specific)
   * Applies the given function to each cogrouped data.  For each unique group, the function will
   * be passed the grouping key and 2 iterators containing all elements in the group from
   * {@link Dataset} <code>this</code> and <code>other</code>.  The function can return an iterator containing elements of an
   * arbitrary type which will be returned as a new {@link Dataset}.
   * <p>
   * @since 1.6.0
   * @param other (undocumented)
   * @param f (undocumented)
   * @param encoder (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object, R extends java.lang.Object> org.apache.spark.sql.Dataset<R> cogroup (org.apache.spark.sql.KeyValueGroupedDataset<K, U> other, org.apache.spark.api.java.function.CoGroupFunction<K, V, U, R> f, org.apache.spark.sql.Encoder<R> encoder)  { throw new RuntimeException(); }
}
