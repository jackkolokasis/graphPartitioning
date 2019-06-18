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

  def log(key: String, value: String) {
    mainObj += (key -> value)
  }

  def numberOfVerices(graph: Graph[Int, Int]): Long = {
    graph.numVertices
  }

  def numberOfEdges(graph: Graph[Int, Int]): Long = {
    graph.numEdges
  }

  def numberOfPartitions(graph: Graph[Int, Int]): Long = {
    graph.edges.partitionsRDD.count
  }

  def maxPartitionSize(graph: Graph[Int, Int]): Long = {
    graph.edges.partitionsRDD.mapValues(V => V.getDstIds.length).map(a => a._2).max()
  }

  def minPartitionSize(graph: Graph[Int, Int]): Long = {
    graph.edges.partitionsRDD.mapValues(V => V.getDstIds.length).map(a => a._2).min()
  }

  def calculateBalance(graph: Graph[Int, Int]): Double = {
    val maxPart: Double = maxPartitionSize(graph)
    val averagePart: Double = (numberOfEdges(graph) / numberOfPartitions(graph))
    maxPart / averagePart
  }

  def maxNumberOfVertices(graph: Graph[Int, Int]): Double = {

    val nuniqueVerticesInEdgePartitions = graph.edges
      .partitionsRDD
      .mapValues(V => (Set(V.getSrcIds: _*) ++ Set(V.getDstIds: _*)).size)
      .map(x => x._2.toLong)

    val maxNUniqueVertInEdgePart = nuniqueVerticesInEdgePartitions.max

    val sumNUniqueVertInEdgePart = nuniqueVerticesInEdgePartitions.reduce(_ + _)

    val avgNUniqueVertInEdgePart = sumNUniqueVertInEdgePart / numberOfPartitions(graph)

    val balance = maxNUniqueVertInEdgePart.toDouble / avgNUniqueVertInEdgePart.toDouble

    balance
  }


  def calculateSetOfVerticesNotCutted(graph: Graph[Int, Int]): Set[VertexId] = {
    val q = graph.edges.partitionsRDD
    val p = q.mapValues((V) => (Set(V.getSrcIds: _*) ++ Set(V.getDstIds: _*)))
    val w = p.map(a => a._2).flatMap(a => a)
    var result = w.countByValue.filter(_._2 == 1).map(x => x._1).toSet // reduce((a, b) => a ++ b)
    var res = result.map(x => (x.asInstanceOf[Number].longValue))
    res
  }

  def communicationalCost(graph: Graph[Int, Int], notCutted: Set[VertexId]): Long = {

    val q = graph.edges.partitionsRDD
    val p = q.mapValues((V) => (Set(V.getSrcIds: _*) ++ Set(V.getDstIds: _*)))
    val w = p.map(a => a._2)
    val ncutted = notCutted.map(x => x.toInt)
    val z = w.map{a: Set[Int] => a.diff(ncutted)}
    val s = z.map{a: Set[Int] => a.size.toLong}
    s.reduce(_ + _)

  }

  def VertexGoToTheSameEdPartition(graph: Graph[Int, Int]): Int = {
    graph.vertices.VertexGoSameEdPartition()
  }

  def VertexGoToOtherEdPartition(graph: Graph[Int, Int]): Int = {
    graph.vertices.VertexGoOtherEdPartition()
  }
  
  def numberOfEdgesInEachPartition(graph: Graph[Int, Int]): Array[Int] = {

    graph.edges.partitionsRDD.mapValues(V => V.getDstIds.length).map(a => a._2).collect

  }

  def metrics(graph: Graph[Int, Int]): Map[String, String] = {
    val nov = numberOfVerices(graph)

    log("numberVertices", nov.toString)
    log("numberEdges", numberOfEdges(graph).toString)
    log("numberVertexGoToTheSamePartition", VertexGoToTheSameEdPartition(graph).toString)
    log("numberVertexGoToOtherPartition", VertexGoToOtherEdPartition(graph).toString)
    log("numberPartitions", numberOfPartitions(graph).toString)
    log("maxNumberEdgePartition", maxPartitionSize(graph).toString)
    log("minNumberEdgePartition", minPartitionSize(graph).toString)
    log("balance", calculateBalance(graph).toString)
    val notCatted = calculateSetOfVerticesNotCutted(graph)
    log("vertexNonCutted", notCatted.size.toString)
    log("vertexCut", (nov - notCatted.size).toString)
    log("communicationCost", communicationalCost(graph, notCatted).toString)
    log("edgeInPartitions", numberOfEdgesInEachPartition(graph).toList.mkString(", "))

    mainObj
  }

}
// scalastyle:off

