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

import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import java.util.Random
import org.apache.spark._
import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD
import org.apache.spark.SparkContext._
import org.apache.spark.storage.StorageLevel
import scala.collection.immutable.Vector
import org.apache.spark.graphx.lib._

object TestMultiPartitionStrategy {
  var mainObj: Map[String, String] = Map()

  def log(key: String, value: String) {
    mainObj += (key -> value)
  }

  def toCSV(outFile: String, taskType: String, graphName: String, partitionerName: String) {
    val out = new PrintWriter(new FileWriter(outFile, true));

    val arr = Array(
      "timeAll",
      "timeLoad",
      "timePartition",
      "timeComp"
    )
    
    val vals = taskType :: graphName :: partitionerName :: arr.map(x => mainObj.get(x).getOrElse("")).toList
    val s = vals.mkString(";")
    
    out.println(s)
    out.close
  }

  def main(args: Array[String]) {

    /* Start Application Time */
    val startAll = System.currentTimeMillis()

    require(args.length == 10, """|Wrong argument number.
                                 |Should be 8.
                                 Usage: <taskType> <pathToGrpah> <filenameWithResult>
                                 <parititonerName> <minEdgePartitions>
                                 <numIter>
                                 <shortGraphName>
				 <partitionThreshold>""".stripMargin)

    /* Parse command line arguments */
    val taskType = args(0)
    val pathToGraph = args(1)
    val outFile = args(2)
    val partitionerName = args(3)
    val numEPart = args(4).toInt
    val numIter = args(5).toInt
    val graphName = args(6)
    val threshold = args(7).toInt
    val vertex1 = args(8).toLong
    val vertex2 = args(9).toLong

    val conf = new SparkConf()
    val sc = new SparkContext(conf.setAppName(taskType))

    /* Graph object declaration */
    var graph: Graph[Int, Int] = null
    
    /* Graph Loading */

    /* Start Load Time */
    val startLoad = System.currentTimeMillis()

    graph = GraphLoader.edgeListFile(sc, pathToGraph,
          numEdgePartitions = numEPart,
          edgeStorageLevel = StorageLevel.MEMORY_ONLY,
          vertexStorageLevel = StorageLevel.MEMORY_ONLY)
    
    val numOfEdges = graph.edges.count

    /* End Loading Time */
    val endLoad = System.currentTimeMillis()

    /* Graph Partitioning */
   if (partitionerName == "CarvCut")
   {
     if ((numOfEdges/numEPart) > threshold)
     {
       graph = graph.partitionBy( 
         PartitionStrategy.fromString("EdgePartition2D"), numEPart, threshold)
     }
     else
     {
       graph = graph.partitionBy( 
         PartitionStrategy.fromString("DstCutPartition"), numEPart, threshold)
     }
   }
   else
   {
     graph = graph.partitionBy(
       PartitionStrategy.fromString(partitionerName), numEPart, threshold)
   }

   graph.edges.count

   /* End Partition Time */
    val endPart = System.currentTimeMillis()

    taskType match {
      case "pagerank" =>
        
        val result = graph.staticPageRank(numIter)
        result.vertices.count

      case "cc" =>
        
        val result = graph.connectedComponents(numIter)
        result.vertices.map { case (vid, data) => data }.distinct()

      case "triangles" =>
        
        val result = graph.triangleCount()
        result.vertices.map {case (vid, data) => data.toLong}.reduce(_ + _) / 3

      case "sssp" =>
        val result = ShortestPaths.run(graph, Seq(vertex1))

        val shortestPath = result               	// result is a graph
          .vertices                             	// we get the vertices RDD
          .filter({case(vId, _) => vId == vertex1})  	// we filter to get only the shortest path from v1
          .first                                	// there's only one value
          ._2                                   	// the result is a tuple (v1, Map)
          .get(vertex2)                              	// we get its shortest path to v2 as an
    }
    
    val endComp = System.currentTimeMillis

    val timeAll = endComp - startAll
    val timeLoad = endLoad - startLoad
    val timePartition = endPart - endLoad
    val timeComp = endComp - endPart

    log("timeAll", timeAll.toString)
    log("timeLoad", timeLoad.toString)
    log("timePartition", timePartition.toString)
    log("timeComp", timeComp.toString)

    toCSV(outFile, taskType, graphName, partitionerName)
    sc.stop
  }
}
// scalastyle:on
