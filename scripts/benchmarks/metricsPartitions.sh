#!/usr/bin/env bash

###################################################
#
# file: metricsPartitions.sh
#
# @Author  Iacovos G. Kolokasis
# @Version 03-06-2018
# @email   kolokasis@ics.forth.gr
#
# @brief   This script provide partition metrics
# to test the quality of the different partition
# strategies apply on each dataset.
# Note:
#          This benchmark script must run on CARV
#          cluster (sith0-3, sith7)
# Example:
#          ./metricsPartitions.sh -n 120 -t 100
#
###################################################

# Partition Strategies
PARTITIONER=("RandomVertexCut"\
             "EdgePartition1D"\
             "EdgePartition2D"\
             "CanonicalRandomVertexCut"\
             "SrcCutPartition"\
             "DstCutPartition"\
             "HybridCut"\
             "HybridCutPlus")

# Input Datasets
INPUT=("hdfs://sith0-hadoop:9000/user/kolokasis/road-road-usa.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/socfb-uci-uni.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/web-wikipedia_link_fr.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/soc-sinaweibo.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/twitter-2010.txt")

# Dataset Names
DATASET=("road-usa"\
         "socfb-uci-uni"\
         "web-wikipedia_link_fr"\
         "soc_sinaweibo"\
         "twitter-2010")

# Print error/usage script message
usage() {
    echo
    echo "Usage:"
    echo "      ./benchmark.sh -n <num_partition> -t <partitionThreshold>[-h]"
    echo
    echo "Options:"
    echo "      -n  Number of partitions"
    echo "      -t  Threshold" 
    echo "      -h  Show usage"
    echo

    exit 1
}

# Check for the input arguments
while getopts ":n:t:h" opt
do
    case "${opt}" in
        n)
            NUM_PARTITION=${OPTARG}
            ;;
        t)
            THRESHOLD=${OPTARG}
            ;;
        h)
            usage
            ;;
        *)
            usage
            ;;
    esac
done

# Check the number of the input arguments
if [ $# -lt 3 ]
then
    usage
fi

# Execution time directory
mkdir -p partitions/${NUM_PARTITION}/

# Header row for partition metrics csv file
printf "Dataset;Partitioner;" >> partitions/${NUM_PARTITION}/partMetrics.csv
printf "numberVertices;" >> partitions/${NUM_PARTITION}/partMetrics.csv
printf "numberEdges;" >> partitions/${NUM_PARTITION}/partMetrics.csv
printf "numberPartitions;" >> partitions/${NUM_PARTITION}/partMetrics.csv
printf "balance;" >> partitions/${NUM_PARTITION}/partMetrics.csv
printf "NSTDEV;" >> partitions/${NUM_PARTITION}/partMetrics.csv
printf "replications;" >> partitions/${NUM_PARTITION}/partMetrics.csv
printf "replicationFactor;" >> partitions/${NUM_PARTITION}/partMetrics.csv
printf "maxNumberEdgePartition;" >> partitions/${NUM_PARTITION}/partMetrics.csv
printf "vertexNonCutted;" >> partitions/${NUM_PARTITION}/partMetrics.csv
printf "vertexCut;" >> partitions/${NUM_PARTITION}/partMetrics.csv
printf "communicationCost;" >> partitions/${NUM_PARTITION}/partMetrics.csv
printf "loadBalance\n" >> partitions/${NUM_PARTITION}/partMetrics.csv

#Create a folder for the total execution time results
for ((i=1; i<${#INPUT[@]}; i++))
do
    for  ((j=7; j<${#PARTITIONER[@]}; j++))
    do
        # Start Spark
        /opt/spark/spark-master/sbin/start-all.sh

        /opt/spark/spark-master/bin/spark-submit \
            --class org.apache.spark.examples.graphx.PartitionsMeasures \
            /opt/spark/spark-master/examples/target/scala-2.11/jars/spark-examples_2.11-2.2.0-SNAPSHOT.jar \
            ${INPUT[${i}]} \
            partitions/${NUM_PARTITION}/partMetrics.csv \
            ${PARTITIONER[${j}]} \
            ${NUM_PARTITION} \
            ${DATASET[${i}]} \
            ${THRESHOLD}

        # Stop Spark
        /opt/spark/spark-master/sbin/stop-all.sh
        exit
    done
done
