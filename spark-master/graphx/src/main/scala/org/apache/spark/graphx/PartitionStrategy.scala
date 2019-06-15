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

package org.apache.spark.graphx

/**
 * Represents the way edges are assigned to edge partitions based on their source and destination
 * vertex IDs.
 */
trait PartitionStrategy extends Serializable {
  /** Returns the partition number for a given edge. */
  def getPartition(src: VertexId, dst: VertexId, numParts: PartitionID): PartitionID
}

/**
 * Collection of built-in [[PartitionStrategy]] implementations.
 */
object PartitionStrategy {
  /**
   * Assigns edges to partitions using a 2D partitioning of the sparse edge adjacency matrix,
   * guaranteeing a `2 * sqrt(numParts)` bound on vertex replication.
   *
   * Suppose we have a graph with 12 vertices that we want to partition
   * over 9 machines.  We can use the following sparse matrix representation:
   *
   * <pre>
   *       __________________________________
   *  v0   | P0 *     | P1       | P2    *  |
   *  v1   |  ****    |  *       |          |
   *  v2   |  ******* |      **  |  ****    |
   *  v3   |  *****   |  *  *    |       *  |
   *       ----------------------------------
   *  v4   | P3 *     | P4 ***   | P5 **  * |
   *  v5   |  *  *    |  *       |          |
   *  v6   |       *  |      **  |  ****    |
   *  v7   |  * * *   |  *  *    |       *  |
   *       ----------------------------------
   *  v8   | P6   *   | P7    *  | P8  *   *|
   *  v9   |     *    |  *    *  |          |
   *  v10  |       *  |      **  |  *  *    |
   *  v11  | * <-E    |  ***     |       ** |
   *       ----------------------------------
   * </pre>
   *
   * The edge denoted by `E` connects `v11` with `v1` and is assigned to processor `P6`. To get the
   * processor number we divide the matrix into `sqrt(numParts)` by `sqrt(numParts)` blocks. Notice
   * that edges adjacent to `v11` can only be in the first column of blocks `(P0, P3,
   * P6)` or the last
   * row of blocks `(P6, P7, P8)`.  As a consequence we can guarantee that `v11` will need to be
   * replicated to at most `2 * sqrt(numParts)` machines.
   *
   * Notice that `P0` has many edges and as a consequence this partitioning would lead to poor work
   * balance.  To improve balance we first multiply each vertex id by a large prime to shuffle the
   * vertex locations.
   *
   * When the number of partitions requested is not a perfect square we use a slightly different
   * method where the last column can have a different number of rows than the others while still
   * maintaining the same size per block.
   */
  case object EdgePartition2D extends PartitionStrategy {
    override def getPartition(src: VertexId, dst: VertexId, numParts: PartitionID): PartitionID = {
      val ceilSqrtNumParts: PartitionID = math.ceil(math.sqrt(numParts)).toInt
      val mixingPrime: VertexId = 1125899906842597L
      if (numParts == ceilSqrtNumParts * ceilSqrtNumParts) {
        // Use old method for perfect squared to ensure we get same results
        val col: PartitionID = (math.abs(src * mixingPrime) % ceilSqrtNumParts).toInt
        val row: PartitionID = (math.abs(dst * mixingPrime) % ceilSqrtNumParts).toInt
        val id = (col * ceilSqrtNumParts + row) % numParts
        return id

      } else {
        // Otherwise use new method
        val cols = ceilSqrtNumParts
        val rows = (numParts + cols - 1) / cols
        val lastColRows = numParts - rows * (cols - 1)
        val col = (math.abs(src * mixingPrime) % numParts / rows).toInt
        val row = (math.abs(dst * mixingPrime) % (if (col < cols - 1) rows else lastColRows)).toInt
        val id = col * rows + row
        return id
      }
    }
  }

  /**
   * Assigns edges to partitions using only the source vertex ID, colocating edges with the same
   * source.
   */
  case object EdgePartition1D extends PartitionStrategy {
    override def getPartition(src: VertexId, dst: VertexId, numParts: PartitionID): PartitionID = {
      val mixingPrime: VertexId = 1125899906842597L
      val id = (math.abs(src * mixingPrime) % numParts).toInt
      return id
    }
  }


  /**
   * Assigns edges to partitions by hashing the source and destination vertex IDs, resulting in a
   * random vertex cut that colocates all same-direction edges between two vertices.
   */
  case object RandomVertexCut extends PartitionStrategy {
    override def getPartition(src: VertexId, dst: VertexId, numParts: PartitionID): PartitionID = {
      val id = math.abs((src, dst).hashCode()) % numParts
      return id
    }
  }


  /**
   * Assigns edges to partitions by hashing the source and destination vertex IDs in a canonical
   * direction, resulting in a random vertex cut that colocates all edges between two vertices,
   * regardless of direction.
   */
  case object CanonicalRandomVertexCut extends PartitionStrategy {
    override def getPartition(src: VertexId, dst: VertexId, numParts: PartitionID): PartitionID = {
      if (src < dst) {
        val id = math.abs((src, dst).hashCode()) % numParts
        return id
      } else {
        val id = math.abs((dst, src).hashCode()) % numParts
        return(id)
      }
    }
  }

  case object SrcCutPartition extends PartitionStrategy {
    override def getPartition(src: VertexId, dst: VertexId, numParts: PartitionID): PartitionID = {
      val id = (src % numParts).toInt
      return id
    }
  }

  case object DstCutPartition extends PartitionStrategy {
    override def getPartition(src: VertexId, dst: VertexId, numParts: PartitionID): PartitionID = {
      val id = (dst % numParts).toInt
      return id
    }
  }

/**
   * @brief HybridCut, a PartitionStrategy
   * details
   *
   * a Balanced p-way Hybrid-Cut inspired by
   * PowerLyra : Differentiated Graph Computation and Partitioning on Skewed Graphs
   * Institute of Parallel and Distributed Systems
   * Chen, R., Shi, J., Chen, Y., Guan, H., Chen, H., Ipadstr--, T. R. N., & Zang, B. (2013).
   *
   * design 1 (same parameter as before)
   * @param src [source vertex ID]
   * @param dst [destination vertex ID]
   * @param numParts [number of partitions intended to part]
   * @return PartitionID [PartitionID for this edge]
   * logic: need graph info
   */
  case object GreedyHybridCut extends PartitionStrategy {
    override def getPartition(
      src: VertexId, dst: VertexId, numParts: PartitionID)
    : PartitionID = {
      0
    }
  }
  case object HybridCutPlus extends PartitionStrategy {
    override def getPartition(
      src: VertexId, dst: VertexId, numParts: PartitionID)
    : PartitionID = {
      0
    }
  }

case object HybridCut extends PartitionStrategy {
    override def getPartition(
      src: VertexId, dst: VertexId, numParts: PartitionID)
    : PartitionID = {
      // this is how to get in-degrees for a given graph
      // need to persist it and for store reference use
      // make it one copy, destroy when finish?

      // info Vertex ID or Vetex Name?
      // val inDegrees: VertexRDD[Int] = graph.inDegrees
      // var DegreesArray = inDegrees.toArray()
      // var DegreesMap = Map(DegreesArray:_*)
      // DegreesMap.get(src)
      // var ThreshHold = 50
      // // val DegreeCount : Int = DegreesMap.getOrElse(dst, 0)
      // val DegreeCount : Int = inDegrees.lookup(dst).head
      // if (DegreeCount > ThreshHold) {
      //     // high-cut
      //     math.abs(src).toInt % numParts
      //   } else {
      //     // low-cut
      //     math.abs(dst).toInt % numParts
      //   }
      // dummy
      (math.abs(dst) % numParts).toInt
    }
  }

  /** Returns the PartitionStrategy with the specified name. */
  def fromString(s: String): PartitionStrategy = s match {
    case "RandomVertexCut" => RandomVertexCut
    case "EdgePartition1D" => EdgePartition1D
    case "EdgePartition2D" => EdgePartition2D
    case "CanonicalRandomVertexCut" => CanonicalRandomVertexCut
    case "SrcCutPartition" => SrcCutPartition
    case "DstCutPartition" => DstCutPartition
    case "GreedyHybridCut" => GreedyHybridCut
    case "HybridCut" => HybridCut
    case "HybridCutPlus" => HybridCutPlus
    case _ => throw new IllegalArgumentException("Invalid PartitionStrategy: " + s)
  }
}
