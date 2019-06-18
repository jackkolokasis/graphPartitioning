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

/**
 * Uses GraphX to run PageRank on a LiveJournal social network graph. Download the dataset from
 * http://snap.stanford.edu/data/soc-LiveJournal1.html.
 */
object my_LiveJournalPageRank {
  def main(args: Array[String]) {
    if (args.length < 1) {
      System.err.println(
        "Usage: LiveJournalPageRank <edge_list_file>\n" +
          "    --numEPart=<num_edge_partitions>\n" +
          "        The number of partitions for the graph's edge RDD.\n" +
          "    [--tol=<tolerance>]\n" +
          "        The tolerance allowed at convergence (smaller => more accurate). Default is " +
          "0.001.\n" +
          "    [--output=<output_file>]\n" +
          "        If specified, the file to write the ranks to.\n" +
          "    [--partStrategy=RandomVertexCut | EdgePartition1D | EdgePartition2D | " +
          "CanonicalRandomVertexCut]\n" +
          "        The way edges are assigned to edge partitions. Default is RandomVertexCut.")
      System.exit(-1)
    }

    args(0) match {
      case "--code=pagerank" => Analytics.main(args.patch(0, List("pagerank"), 1))
      case "--code=cc" => Analytics.main(args.patch(0, List("cc"), 1))
      case "--code=triangles" => Analytics.main(args.patch(0, List("triangles"), 1))
      case "--code=labelpropagation" => Analytics.main(args.patch(0, List("labelpropagation"), 1))
      case "--code=scc" => Analytics.main(args.patch(0, List("scc"), 1))
      case "--code=shortestPath" => Analytics.main(args.patch(0, List("shortestPath"), 1))
    }

    // Analytics.main(args.patch(0, List("pagerank"), 0))
  }
}
// scalastyle:on println
