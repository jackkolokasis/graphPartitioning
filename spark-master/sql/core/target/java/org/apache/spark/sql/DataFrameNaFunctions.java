package org.apache.spark.sql;
/**
 * Functionality for working with missing data in <code>DataFrame</code>s.
 * <p>
 * @since 1.3.1
 */
public final class DataFrameNaFunctions {
     DataFrameNaFunctions (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that drops rows containing any null or NaN values.
   * <p>
   * @since 1.3.1
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop ()  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that drops rows containing null or NaN values.
   * <p>
   * If <code>how</code> is "any", then drop rows containing any null or NaN values.
   * If <code>how</code> is "all", then drop rows only if every column is null or NaN for that row.
   * <p>
   * @since 1.3.1
   * @param how (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop (java.lang.String how)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that drops rows containing any null or NaN values
   * in the specified columns.
   * <p>
   * @since 1.3.1
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop (java.lang.String[] cols)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Returns a new <code>DataFrame</code> that drops rows containing any null or NaN values
   * in the specified columns.
   * <p>
   * @since 1.3.1
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop (scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that drops rows containing null or NaN values
   * in the specified columns.
   * <p>
   * If <code>how</code> is "any", then drop rows containing any null or NaN values in the specified columns.
   * If <code>how</code> is "all", then drop rows only if every specified column is null or NaN for that row.
   * <p>
   * @since 1.3.1
   * @param how (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop (java.lang.String how, java.lang.String[] cols)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Returns a new <code>DataFrame</code> that drops rows containing null or NaN values
   * in the specified columns.
   * <p>
   * If <code>how</code> is "any", then drop rows containing any null or NaN values in the specified columns.
   * If <code>how</code> is "all", then drop rows only if every specified column is null or NaN for that row.
   * <p>
   * @since 1.3.1
   * @param how (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop (java.lang.String how, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that drops rows containing
   * less than <code>minNonNulls</code> non-null and non-NaN values.
   * <p>
   * @since 1.3.1
   * @param minNonNulls (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop (int minNonNulls)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that drops rows containing
   * less than <code>minNonNulls</code> non-null and non-NaN values in the specified columns.
   * <p>
   * @since 1.3.1
   * @param minNonNulls (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop (int minNonNulls, java.lang.String[] cols)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Returns a new <code>DataFrame</code> that drops rows containing less than
   * <code>minNonNulls</code> non-null and non-NaN values in the specified columns.
   * <p>
   * @since 1.3.1
   * @param minNonNulls (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop (int minNonNulls, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that replaces null or NaN values in numeric columns with <code>value</code>.
   * <p>
   * @since 2.2.0
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fill (long value)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that replaces null or NaN values in numeric columns with <code>value</code>.
   * @since 1.3.1
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fill (double value)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that replaces null values in string columns with <code>value</code>.
   * <p>
   * @since 1.3.1
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fill (java.lang.String value)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that replaces null or NaN values in specified numeric columns.
   * If a specified column is not a numeric column, it is ignored.
   * <p>
   * @since 2.2.0
   * @param value (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fill (long value, java.lang.String[] cols)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that replaces null or NaN values in specified numeric columns.
   * If a specified column is not a numeric column, it is ignored.
   * <p>
   * @since 1.3.1
   * @param value (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fill (double value, java.lang.String[] cols)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Returns a new <code>DataFrame</code> that replaces null or NaN values in specified
   * numeric columns. If a specified column is not a numeric column, it is ignored.
   * <p>
   * @since 2.2.0
   * @param value (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fill (long value, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Returns a new <code>DataFrame</code> that replaces null or NaN values in specified
   * numeric columns. If a specified column is not a numeric column, it is ignored.
   * <p>
   * @since 1.3.1
   * @param value (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fill (double value, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that replaces null values in specified string columns.
   * If a specified column is not a string column, it is ignored.
   * <p>
   * @since 1.3.1
   * @param value (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fill (java.lang.String value, java.lang.String[] cols)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Returns a new <code>DataFrame</code> that replaces null values in
   * specified string columns. If a specified column is not a string column, it is ignored.
   * <p>
   * @since 1.3.1
   * @param value (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fill (java.lang.String value, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that replaces null values.
   * <p>
   * The key of the map is the column name, and the value of the map is the replacement value.
   * The value must be of the following type:
   * <code>Integer</code>, <code>Long</code>, <code>Float</code>, <code>Double</code>, <code>String</code>, <code>Boolean</code>.
   * Replacement values are cast to the column data type.
   * <p>
   * For example, the following replaces null values in column "A" with string "unknown", and
   * null values in column "B" with numeric value 1.0.
   * <pre><code>
   *   import com.google.common.collect.ImmutableMap;
   *   df.na.fill(ImmutableMap.of("A", "unknown", "B", 1.0));
   * </code></pre>
   * <p>
   * @since 1.3.1
   * @param valueMap (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fill (java.util.Map<java.lang.String, java.lang.Object> valueMap)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Returns a new <code>DataFrame</code> that replaces null values.
   * <p>
   * The key of the map is the column name, and the value of the map is the replacement value.
   * The value must be of the following type: <code>Int</code>, <code>Long</code>, <code>Float</code>, <code>Double</code>, <code>String</code>, <code>Boolean</code>.
   * Replacement values are cast to the column data type.
   * <p>
   * For example, the following replaces null values in column "A" with string "unknown", and
   * null values in column "B" with numeric value 1.0.
   * <pre><code>
   *   df.na.fill(Map(
   *     "A" -&gt; "unknown",
   *     "B" -&gt; 1.0
   *   ))
   * </code></pre>
   * <p>
   * @since 1.3.1
   * @param valueMap (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fill (scala.collection.immutable.Map<java.lang.String, java.lang.Object> valueMap)  { throw new RuntimeException(); }
  /**
   * Replaces values matching keys in <code>replacement</code> map with the corresponding values.
   * Key and value of <code>replacement</code> map must have the same type, and
   * can only be doubles, strings or booleans.
   * If <code>col</code> is "*", then the replacement is applied on all string columns or numeric columns.
   * <p>
   * <pre><code>
   *   import com.google.common.collect.ImmutableMap;
   *
   *   // Replaces all occurrences of 1.0 with 2.0 in column "height".
   *   df.replace("height", ImmutableMap.of(1.0, 2.0));
   *
   *   // Replaces all occurrences of "UNKNOWN" with "unnamed" in column "name".
   *   df.replace("name", ImmutableMap.of("UNKNOWN", "unnamed"));
   *
   *   // Replaces all occurrences of "UNKNOWN" with "unnamed" in all string columns.
   *   df.replace("*", ImmutableMap.of("UNKNOWN", "unnamed"));
   * </code></pre>
   * <p>
   * @param col name of the column to apply the value replacement
   * @param replacement value replacement map, as explained above
   * <p>
   * @since 1.3.1
   * @return (undocumented)
   */
  public <T extends java.lang.Object> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> replace (java.lang.String col, java.util.Map<T, T> replacement)  { throw new RuntimeException(); }
  /**
   * Replaces values matching keys in <code>replacement</code> map with the corresponding values.
   * Key and value of <code>replacement</code> map must have the same type, and
   * can only be doubles, strings or booleans.
   * <p>
   * <pre><code>
   *   import com.google.common.collect.ImmutableMap;
   *
   *   // Replaces all occurrences of 1.0 with 2.0 in column "height" and "weight".
   *   df.replace(new String[] {"height", "weight"}, ImmutableMap.of(1.0, 2.0));
   *
   *   // Replaces all occurrences of "UNKNOWN" with "unnamed" in column "firstname" and "lastname".
   *   df.replace(new String[] {"firstname", "lastname"}, ImmutableMap.of("UNKNOWN", "unnamed"));
   * </code></pre>
   * <p>
   * @param cols list of columns to apply the value replacement
   * @param replacement value replacement map, as explained above
   * <p>
   * @since 1.3.1
   * @return (undocumented)
   */
  public <T extends java.lang.Object> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> replace (java.lang.String[] cols, java.util.Map<T, T> replacement)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Replaces values matching keys in <code>replacement</code> map.
   * Key and value of <code>replacement</code> map must have the same type, and
   * can only be doubles, strings or booleans.
   * If <code>col</code> is "*",
   * then the replacement is applied on all string columns , numeric columns or boolean columns.
   * <p>
   * <pre><code>
   *   // Replaces all occurrences of 1.0 with 2.0 in column "height".
   *   df.replace("height", Map(1.0 -&gt; 2.0))
   *
   *   // Replaces all occurrences of "UNKNOWN" with "unnamed" in column "name".
   *   df.replace("name", Map("UNKNOWN" -&gt; "unnamed")
   *
   *   // Replaces all occurrences of "UNKNOWN" with "unnamed" in all string columns.
   *   df.replace("*", Map("UNKNOWN" -&gt; "unnamed")
   * </code></pre>
   * <p>
   * @param col name of the column to apply the value replacement
   * @param replacement value replacement map, as explained above
   * <p>
   * @since 1.3.1
   * @return (undocumented)
   */
  public <T extends java.lang.Object> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> replace (java.lang.String col, scala.collection.immutable.Map<T, T> replacement)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Replaces values matching keys in <code>replacement</code> map.
   * Key and value of <code>replacement</code> map must have the same type, and
   * can only be doubles , strings or booleans.
   * <p>
   * <pre><code>
   *   // Replaces all occurrences of 1.0 with 2.0 in column "height" and "weight".
   *   df.replace("height" :: "weight" :: Nil, Map(1.0 -&gt; 2.0));
   *
   *   // Replaces all occurrences of "UNKNOWN" with "unnamed" in column "firstname" and "lastname".
   *   df.replace("firstname" :: "lastname" :: Nil, Map("UNKNOWN" -&gt; "unnamed");
   * </code></pre>
   * <p>
   * @param cols list of columns to apply the value replacement
   * @param replacement value replacement map, as explained above
   * <p>
   * @since 1.3.1
   * @return (undocumented)
   */
  public <T extends java.lang.Object> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> replace (scala.collection.Seq<java.lang.String> cols, scala.collection.immutable.Map<T, T> replacement)  { throw new RuntimeException(); }
  private <T extends java.lang.Object> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> replace0 (scala.collection.Seq<java.lang.String> cols, scala.collection.immutable.Map<T, T> replacement)  { throw new RuntimeException(); }
  private  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fillMap (scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.Object>> values)  { throw new RuntimeException(); }
  /**
   * Returns a {@link Column} expression that replaces null value in <code>col</code> with <code>replacement</code>.
   * @param col (undocumented)
   * @param replacement (undocumented)
   * @return (undocumented)
   */
  private <T extends java.lang.Object> org.apache.spark.sql.Column fillCol (org.apache.spark.sql.types.StructField col, T replacement)  { throw new RuntimeException(); }
  /**
   * Returns a {@link Column} expression that replaces value matching key in <code>replacementMap</code> with
   * value in <code>replacementMap</code>, using {@link CaseWhen}.
   * <p>
   * TODO: This can be optimized to use broadcast join when replacementMap is large.
   * @param col (undocumented)
   * @param replacementMap (undocumented)
   * @return (undocumented)
   */
  private  org.apache.spark.sql.Column replaceCol (org.apache.spark.sql.types.StructField col, scala.collection.immutable.Map<?, ?> replacementMap)  { throw new RuntimeException(); }
  private  double convertToDouble (Object v)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that replaces null or NaN values in specified
   * numeric, string columns. If a specified column is not a numeric, string column,
   * it is ignored.
   * @param value (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  private <T extends java.lang.Object> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> fillValue (T value, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
}
