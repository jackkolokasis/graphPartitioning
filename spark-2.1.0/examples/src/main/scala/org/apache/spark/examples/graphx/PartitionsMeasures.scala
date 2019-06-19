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

object PartitionsMeasures {
  def main(args: Array[String]) {

    require(args.length == 6, """|Wrong argument number.
                                 |Should be 6.
                                 Usage: <pathToGrpah> <filenameWithResult>
                                 <parititonerName> <minEdgePartitions>
                                 <shortGraphName>""".stripMargin)

    val pathToGraph = args(0)
    val outFile = args(1)
    val partitionerName = args(2)
    val numEPart = args(3).toInt
    val graphName = args(4)
    val threshold = args(5).toInt

    val conf = new SparkConf()
    val sc = new SparkContext(conf.setAppName("PartitionAndMeasure"))

    var graph: Graph[Int, Int] = null

    graph = GraphLoader.edgeListFile(sc, pathToGraph,
          numEdgePartitions = numEPart,
          edgeStorageLevel = StorageLevel.MEMORY_ONLY,
          vertexStorageLevel = StorageLevel.MEMORY_ONLY)

    graph = graph.partitionBy(PartitionStrategy.fromString(partitionerName), numEPart, threshold)

    val logger = new MetricsLogger()
    val mapLog = logger.metrics(graph)

    val out = new PrintWriter(new FileWriter(outFile, true));
    val arr = Array(
		    "numberVertices",
		    "numberEdges",
		    "numberPartitions", 
		    "balance",
		    "NSTDEV",
		    "calculateReplications",
		    "replicationFactor",
		    "maxNumberEdgePartition",
		    "vertexNonCutted",
		    "vertexCut",
		    "communicationCost",
            	    "loadBalance"
		   )

    val vals = graphName :: partitionerName :: arr.map(x => mapLog.get(x).getOrElse("")).toList
    // :: graph.numVertices.toString :: graph.numEdges.toString
    val s = vals.mkString(";")

    out.println(s)
    out.close

    sc.stop
  }
}
// scalastyle:on
