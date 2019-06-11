/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off

package org.apache.spark.examples.graphx

import com.google.common.collect.Sets
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import java.util.Random

import org.apache.spark._
import org.apache.spark.graphx._
import org.apache.spark.graphx.impl.EdgePartition
import org.apache.spark.rdd.RDD
import scala.collection.JavaConversions
import scala.language.existentials

class MetricsLogger {
  var mainObj: Map[String, String] = Map()

  /**
   * @brief Log file 
   * 
   * @param key   Metric name
   * @param value Metric value
   *
   */

  def log(key: String, value: String) {
    mainObj += (key -> value)
  }

  /**
   * @brief Calculate number of vertices 
   *
   * @param graph Graph
   * 
   * @ret Number of vertices
   *
   */

  def numberOfVerices(graph: Graph[Int, Int]): Long = {
    graph.numVertices
  }
  
  /**
   * @brief Calculate number of edges
   *
   * @param graph   The graph
   * 
   * @ret Number of edges
   *
   */
  def numberOfEdges(graph: Graph[Int, Int]): Long = {
    graph.numEdges
  }

  /**
   * @brief Calculate the number of partitions
   *
   * @param graph   The graph
   *
   * @ret Number of partitions
   */
  def numberOfPartitions(graph: Graph[Int, Int]): Long = {
    graph.edges.partitionsRDD.count
  }

  /**
   * @brief Calculate maximum size partition
   *
   * @param graph   The graph
   * 
   * @ret Maximum size partition
   *
   */
  def maxPartitionSize(graph: Graph[Int, Int]): Long = {
    graph.edges.partitionsRDD.mapValues(V => V.getDstIds.length).map(a => a._2).max()
  }

  /**
   * @brief Calculate minimum size partition
   *
   * @param graph   The graph
   * 
   * @ret Minimum size partition
   *
   */
  def minPartitionSize(graph: Graph[Int, Int]): Long = {
    graph.edges.partitionsRDD.mapValues(V => V.getDstIds.length).map(a => a._2).min()
  }

  /*
   * @brief Calculate Balance of Partitions
   *
   * @param graph   The graph
   * 
   * @ret Return the partitions balance
   *
   */
  def calculateBalance(graph: Graph[Int, Int]): Double = {
    val maxPart: Double = maxPartitionSize(graph)
    val averagePart: Double = (numberOfEdges(graph) / numberOfPartitions(graph))
    maxPart / averagePart
  }

  /**
   * @brief Number of Edges in Each Partitions
   *
   * @param graph   The graph
   * 
   * @ret Number of Edges in Each Partitions
   *
   */
  def numberOfEdgesInEachPartition(graph: Graph[Int, Int]): Array[Int] = {

    graph.edges.partitionsRDD.mapValues(V => V.getDstIds.length).map(a => a._2).collect

  }

  /**
   * @brief Set of Vertices
   *
   * @param graph   The graph
   * 
   * @ret   Set of vertices 
   *
   */
  def calculateSetOfVertices(graph: Graph[Int, Int]): Set[VertexId] = {
    val ar: Array[VertexId] = graph.vertices.collect.map(id => id._1)
    Set(ar: _*)
  }
  
  /**
   * @brief Set of Non-Cutted Vertices
   *
   * @param graph   The graph
   * 
   * @ret   Set of non-cutted vertices 
   *
   */
  def calculateSetOfVerticesNotCutted(graph: Graph[Int, Int]): Set[VertexId] = {
    val q = graph.edges.partitionsRDD
    val p = q.map(x => Range(0, x._2.getSrcIds.length).map(i => x._2.srcIds(i)).toSet
      ++ Range(0, x._2.getDstIds.length).map(i => x._2.dstIds(i)).toSet)
    val w = p.flatMap(a => a)
    var result = w.countByValue.filter(_._2 == 1).map(x => x._1).toSet // reduce((a, b) => a ++ b)
    var res = result.map(x => (x.asInstanceOf[Number].longValue))
    res
  }

  /**
   * @brief Set of Cutted Vertices
   *
   * @param graph   The graph
   * 
   * @ret   Set of cutted vertices 
   *
   */
  def calculateSetOfVerticesCatted(graph: Graph[Int, Int]): Set[VertexId] = {
    calculateSetOfVertices(graph).diff(calculateSetOfVerticesNotCutted(graph))
  }

  /**
   * @brief Communicational Cost 
   *
   * @param graph     The graph
   * @param notCutted Set of non cutted vertices
   * 
   * @ret   Communicational Cost
   *
   */
  def communicationalCost(graph: Graph[Int, Int], notCutted: Set[VertexId]): Long = {

    val q = graph.edges.partitionsRDD
    val p = q.map(x => Range(0, x._2.getSrcIds.length).map(i => x._2.srcIds(i)).toSet
      ++ Range(0, x._2.getDstIds.length).map(i => x._2.dstIds(i)).toSet)
    // val w = p.flatMap(a => a).collect.toSet
    // val ncutted = notCutted.map(x => x.toInt)
    val z = p.map{a => a.diff(notCutted)}
    val s = z.map{a => a.size.toLong}
    s.reduce(_ + _)
  }
  
  /**
   * @brief Replications calculation
   *
   * @param graph     The graph
   * 
   * @ret   Replication 
   *
   */
  def calculateReplications(graph: Graph[Int, Int]) = {
    val q = graph.edges.partitionsRDD
    val p = q.map(x => Range(0, x._2.getSrcIds.length).map(i => x._2.srcIds(i)).toSet
      ++ Range(0, x._2.getDstIds.length).map(i => x._2.dstIds(i)).toSet)

    val replic = p.map(x => x.size).reduce(_+_)

    log("calculateReplications", replic.toString)
    replic
  }
  
  /**
   * @brief Normalize standar deviation of partition size
   *
   * @param graph     The graph
   * 
   * @ret   Standar deviation of partition sizes
   *
   */
  def NSTDEV(graph: Graph[Int, Int]): Double = {
    var ar : List[Double] = numberOfEdgesInEachPartition(graph)
      .toList
      .map(a => a.toDouble)
    Math.sqrt(ar.map(e => Math.pow(e * graph.edges.partitionsRDD.count /
      numberOfEdges(graph) - 1, 2)).sum / graph.edges.partitionsRDD.count)
  }

  /**
   * @brief Load Balance
   *
   * @param graph     The graph
   * 
   * @ret   Standar deviation of partition sizes
   *
   */
  def loadBalance(graph: Graph[Int, Int]): Double = {
	var maxEdges = maxPartitionSize(graph)
	var n = 4
	var lBalance: Double = (n.toDouble / numberOfEdges(graph).toDouble) * maxEdges.toDouble
	lBalance
  }

  /**
   * @brief Calculate the values for each partition metric
   *
   * @param graph     The graph
   * 
   * @ret   All the results are store in a hash map.   
   *
   */
  def metrics(graph: Graph[Int, Int]): Map[String, String] = {
    val nov = numberOfVerices(graph)

    log("numberVertices", nov.toString)
    log("numberEdges", numberOfEdges(graph).toString)
    log("numberPartitions", numberOfPartitions(graph).toString)
    log("balance", calculateBalance(graph).toString)
    log("NSTDEV", NSTDEV(graph).toString)
    log("replicationFactor", (calculateReplications(graph).toDouble / nov.toDouble).toString)
    log("maxNumberEdgePartition", maxPartitionSize(graph).toString)
    val notCatted = calculateSetOfVerticesNotCutted(graph)
    log("vertexNonCutted", notCatted.size.toString)
    log("vertexCut", (nov - notCatted.size).toString)
    log("communicationCost", communicationalCost(graph, notCatted).toString)
    log("loadBalance", loadBalance(graph).toString)
    mainObj
  }
}
// scalastyle:off

