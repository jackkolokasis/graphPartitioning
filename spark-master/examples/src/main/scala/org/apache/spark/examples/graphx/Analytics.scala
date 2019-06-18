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

// scalastyle:off println
package org.apache.spark.examples.graphx

import scala.collection.mutable

import org.apache.spark._
import org.apache.spark.graphx._
import org.apache.spark.graphx.PartitionStrategy._
import org.apache.spark.graphx.lib._
import org.apache.spark.internal.Logging
import org.apache.spark.storage.StorageLevel

/**
 * Driver program for running graph algorithms.
 */
object Analytics extends Logging {

  def main(args: Array[String]): Unit = {
    if (args.length < 2) {
      System.err.println(
        "Usage: Analytics <taskType> <file> --numEPart=<num_edge_partitions> [other options]")
      System.err.println("Supported 'taskType' as follows:")
      System.err.println("  pagerank    Compute PageRank")
      System.err.println("  cc          Compute the connected components of vertices")
      System.err.println("  triangles   Count the number of triangles")
      System.exit(1)
    }

    val taskType = args(0)
    val fname = args(1)
    val date = args(2)
    val optionsList = args.drop(3).map { arg =>
      arg.dropWhile(_ == '-').split('=') match {
        case Array(opt, v) => (opt -> v)
        case _ => throw new IllegalArgumentException("Invalid argument: " + arg)
      }
    }
    val options = mutable.Map(optionsList: _*)

    val conf = new SparkConf()
    GraphXUtils.registerKryoClasses(conf)

    val numEPart = options.remove("numEPart").map(_.toInt).getOrElse {
      println("Set the number of edge partitions using --numEPart.")
      sys.exit(1)
    }
    val partitionStrategy: Option[PartitionStrategy] = options.remove("partStrategy")
      .map(PartitionStrategy.fromString(_))
    val edgeStorageLevel = options.remove("edgeStorageLevel")
      .map(StorageLevel.fromString(_)).getOrElse(StorageLevel.MEMORY_ONLY)
    val vertexStorageLevel = options.remove("vertexStorageLevel")
      .map(StorageLevel.fromString(_)).getOrElse(StorageLevel.MEMORY_ONLY)

    val dataset = fname.split("/")(5)

    taskType match {
      case "pagerank" =>
        val tol = options.remove("tol").map(_.toFloat).getOrElse(0.001F)
        val outFname = options.remove("output").getOrElse("")
        val numIterOpt = options.remove("numIter").map(_.toInt)

        options.foreach {
          case (opt, _) => throw new IllegalArgumentException("Invalid option: " + opt)
        }

//        println("======================================")
//        println("|             PageRank               |")
//        println("======================================")

        println("$pagerank " + partitionStrategy.get.toString + " " + dataset + " " + date)
        val sc = new SparkContext(conf.setAppName("PageRank(" + fname + ")"))

        val unpartitionedGraph = GraphLoader.edgeListFile(sc, fname,
          numEdgePartitions = numEPart,
          edgeStorageLevel = edgeStorageLevel,
          vertexStorageLevel = vertexStorageLevel).cache()

        val graph = partitionStrategy.foldLeft(unpartitionedGraph)(_.partitionBy(_))


//      println("GRAPHX: Number of vertices " + graph.vertices.count)
//      println("GRAPHX: Number of edges " + graph.edges.count)

        val startTime = System.currentTimeMillis
        val pr = (numIterOpt match {
          case Some(numIter) => PageRank.run(graph, numIter)
          case None => PageRank.runUntilConvergence(graph, tol)
        }).vertices.cache()
        println("RunTime " + (System.currentTimeMillis - startTime))

//        println("GRAPHX: Total rank: " + pr.map(_._2).reduce(_ + _))

        if (!outFname.isEmpty) {
          logWarning("Saving pageranks of pages to " + outFname)
          pr.map { case (id, r) => id + "\t" + r }.saveAsTextFile(outFname)
        }

        sc.stop()

      case "cc" =>
        options.foreach {
          case (opt, _) => throw new IllegalArgumentException("Invalid option: " + opt)
        }

//        println("======================================")
//        println("|      Connected Components          |")
//        println("======================================")
        println("$cc " + partitionStrategy.get.toString + " " + dataset + " " + date)

        val sc = new SparkContext(conf.setAppName("ConnectedComponents(" + fname + ")"))
        val unpartitionedGraph = GraphLoader.edgeListFile(sc, fname,
          numEdgePartitions = numEPart,
          edgeStorageLevel = edgeStorageLevel,
          vertexStorageLevel = vertexStorageLevel).cache()

        val graph = partitionStrategy.foldLeft(unpartitionedGraph)(_.partitionBy(_))

        val startTime = System.currentTimeMillis
        val cc = ConnectedComponents.run(graph)
        println("RunTime " + (System.currentTimeMillis - startTime))

//      println("Components: " + cc.vertices.map { case (vid, data) => data }.distinct())
        sc.stop()

      case "triangles" =>
        options.foreach {
          case (opt, _) => throw new IllegalArgumentException("Invalid option: " + opt)
        }

//        println("======================================")
//        println("|      Triangle Count                |")
//        println("======================================")
        println("$triangles " + partitionStrategy.get.toString + " " + dataset + " " + date)

        val sc = new SparkContext(conf.setAppName("TriangleCount(" + fname + ")"))
        val graph = GraphLoader.edgeListFile(sc, fname,
          canonicalOrientation = true,
          numEdgePartitions = numEPart,
          edgeStorageLevel = edgeStorageLevel,
          vertexStorageLevel = vertexStorageLevel)
          // TriangleCount requires the graph to be partitioned
          .partitionBy(partitionStrategy.getOrElse(RandomVertexCut)).cache()

        val startTime = System.currentTimeMillis
        val triangles = TriangleCount.run(graph)
        println("RunTime " + (System.currentTimeMillis - startTime))

//        println("Triangles: " + triangles.vertices.map {
//          case (vid, data) => data.toLong
//        }.reduce(_ + _) / 3)
        sc.stop()

       case "labelpropagation" =>
        options.foreach {
          case (opt, _) => throw new IllegalArgumentException("Invalid option: " + opt)
        }

//        println("======================================")
//        println("|      Label Propagation             |")
//        println("======================================")
        println("$labelpropagation " + partitionStrategy.get.toString + " " + dataset + " " + date)

        val sc = new SparkContext(conf.setAppName("Label Propagation(" + fname + ")"))
        val unpartitionedGraph = GraphLoader.edgeListFile(sc, fname,
          numEdgePartitions = numEPart,
          edgeStorageLevel = edgeStorageLevel,
          vertexStorageLevel = vertexStorageLevel).cache()
        val graph = partitionStrategy.foldLeft(unpartitionedGraph)(_.partitionBy(_))

        val startTime = System.currentTimeMillis
        val labelPropagation = LabelPropagation.run(graph, 10)
        println("RunTime " + (System.currentTimeMillis - startTime))
//      println("Labels: " + labelPropagation.vertices.map { case (vid, data) => data }.distinct())
        sc.stop()

       case "scc" =>
        options.foreach {
          case (opt, _) => throw new IllegalArgumentException("Invalid option: " + opt)
        }

//        println("======================================")
//        println("|      StronglyConnectedComponents   |")
//        println("======================================")
        println("$scc " + partitionStrategy.get.toString + " " + dataset + " " + date)

        val sc = new SparkContext(conf.setAppName("StronglyConnectedComponents(" + fname + ")"))
        val unpartitionedGraph = GraphLoader.edgeListFile(sc, fname,
          numEdgePartitions = numEPart,
          edgeStorageLevel = edgeStorageLevel,
          vertexStorageLevel = vertexStorageLevel).cache()

        val graph = partitionStrategy.foldLeft(unpartitionedGraph)(_.partitionBy(_))

        val startTime = System.currentTimeMillis
        val scc = StronglyConnectedComponents.run(graph, 10)
        println("RunTime " + (System.currentTimeMillis - startTime))

//      println("Components: " + scc.vertices.map { case (vid, data) => data }.distinct())
        sc.stop()

        case "shortestPath" =>
            options.foreach {
              case (opt, _) => throw new IllegalArgumentException("Invalid option: " + opt)
            }

//        println("======================================")
//        println("|           Shortest Path            |")
//        println("======================================")
        println("$shortestpath " + partitionStrategy.get.toString + " " + dataset + " " + date)

        val sc = new SparkContext(conf.setAppName("ShortestPaths(" + fname + ")"))
        val unpartitionedGraph = GraphLoader.edgeListFile(sc, fname,
          numEdgePartitions = numEPart,
          edgeStorageLevel = edgeStorageLevel,
          vertexStorageLevel = vertexStorageLevel).cache()

        val graph = partitionStrategy.foldLeft(unpartitionedGraph)(_.partitionBy(_))

        val startTime = System.currentTimeMillis
        val result = ShortestPaths.run(graph, Seq(5))
        println("RunTime " + (System.currentTimeMillis - startTime))

//        val shortestPath = result               // result is a graph
//          .vertices                             // we get the vertices RDD
//          .filter({case(vId, _) => vId == 1})  // we filter to get only the shortest path from v1
//          .first                                // there's only one value
//          ._2                                   // the result is a tuple (v1, Map)
//          .get(5)                              // we get its shortest path to v2 as an
//        println("Shortest Path = " + shortestPath)
          sc.stop()

       case _ =>
        println("Invalid task type.")
    }
  }
}
// scalastyle:on println
