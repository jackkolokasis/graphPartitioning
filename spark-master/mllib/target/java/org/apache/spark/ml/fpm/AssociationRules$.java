package org.apache.spark.ml.fpm;
public  class AssociationRules$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final AssociationRules$ MODULE$ = null;
  public   AssociationRules$ ()  { throw new RuntimeException(); }
  /**
   * Computes the association rules with confidence above minConfidence.
   * @param dataset DataFrame("items", "freq") containing frequent itemset obtained from
   *                algorithms like {@link FPGrowth}.
   * @param itemsCol column name for frequent itemsets
   * @param freqCol column name for frequent itemsets count
   * @param minConfidence minimum confidence for the result association rules
   * @return a DataFrame("antecedent", "consequent", "confidence") containing the association
   *         rules.
   * @param evidence$2 (undocumented)
   */
  public <T extends java.lang.Object> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> getAssociationRulesFromFP (org.apache.spark.sql.Dataset<?> dataset, java.lang.String itemsCol, java.lang.String freqCol, double minConfidence, scala.reflect.ClassTag<T> evidence$2)  { throw new RuntimeException(); }
}
