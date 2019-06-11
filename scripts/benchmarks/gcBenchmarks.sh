#!/usr/bin/env bash

###################################################
#
# file: gcBenchmark.sh
#
# @Author  Iacovos G. Kolokasis
# @Version 17-05-2018
# @email   kolokasis@ics.forth.gr
#
# @brief   Execute benchmarks for a specific input graph algorithm and
#          specific number of partitions on a viriety type and size
#          graph datasets. Based on this script execution we examine
#          how the different partitioners implemented in GraphX -
#          Spark depends on the total execution time.
# Note:
#          This benchmark script must run on CARV cluster
#          (sith0-3, sith7)
#
###################################################

# Partition Strategies
PARTITIONER=("RandomVertexCut"\
             "EdgePartition1D"\
             "EdgePartition2D"\
             "CanonicalRandomVertexCut"\
             "SrcCutPartition"\
             "DstCutPartition")

# Input Datasets
INPUT=("hdfs://sith0-hadoop:9000/user/kolokasis/soc-LiveJournal1.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/follow.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/com-youtube.ungraph.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/com-friendster.ungraph.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/com-orkut.ungraph.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/soc-pokec-relationships.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/follow-dec-2017.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/roadNet-CA.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/roadNet-PA.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/roadNet-TX.txt")

# Dataset Names
DATASET=("socLiveJournal"\
	 "follow"\
	 "youtube"\
	 "friendster"\
	 "orkut"\
	 "pokec"\
	 "follow_dec"\
	 "roadNet-CA"\
	 "roadNet-PA"\
	 "roadNet-TX")

# Print error/usage script message
usage() {
    echo
    echo "Usage:"
    echo "      ./benchmark.sh -a <algorithm> -n <num_partition> -c <num_cores> -i <num iterations> [-h]"
    echo
    echo "Options:"
    echo "      -a  Graph algorithm name (e.g. pagerank)"
    echo "      -n  Number of partitions"
    echo "      -c  Number of cores "
    echo "      -i  Number of iterations "
    echo "      -h  Show usage"
    echo

    exit 1
}

# Check for the input arguments
while getopts ":a:n:c:i:h" opt
do
    case "${opt}" in
        a)
            ALGORITHM=${OPTARG}
            ;;
        n)
            NUM_PARTITION=${OPTARG}
            ;;
        c)
            CORES=${OPTARG}
            ;;
        i)
            MAX_ITERATIONS=${OPTARG}
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
if [ $# -lt 8 ]
then
    usage
fi

# Create output paths
# cpu/algorithm/partitioner/partitions/
for p in "${PARTITIONER[@]}"
do
    mkdir -p cpu/${ALGORITHM}/${p}/${NUM_PARTITIONS}
    mkdir -p mem/${ALGORITHM}/${p}/${NUM_PARTITIONS}
    mkdir -p diskIO/${ALGORITHM}/${p}/${NUM_PARTITIONS}
    mkdir -p network/${ALGORITHM}/${p}/${NUM_PARTITIONS}
done

#Create a folder for the total execution time results
mkdir "${ALGORITHM}_${NUM_PARTITION}_${CORES}" 
mkdir "${ALGORITHM}_${NUM_PARTITION}_${CORES}_gc_master"
mkdir "${ALGORITHM}_${NUM_PARTITION}_${CORES}_gc_executors"

for ((i=0; i<${#DATASET[@]}; i++)); do

    for ((iter=0; iter<${MAX_ITERATIONS}; iter++)); do
        for  ((j=0; j<${#PARTITIONERS[@]}; j++)); do

            # Start Spark
            /opt/spark/spark-master/sbin/start-all.sh

            # Start running GC profilers on every spark node
            ./myjstat.sh \
                -o ${ALGORITHM}_${PARTITIONER[${j}]}_${DATASET[${i}]}_${iter}_master -s MASTER &
            ssh sith0 'bash -s' < ./myjstat.sh \
                -o ${ALGORITHM}_${PARTITIONER[${j}]}_${DATASET[${i}]}_${iter}_executor0 -s EXECUTOR &
            ssh sith1 'bash -s' < ./myjstat.sh \
                -o ${ALGORITHM}_${PARTITIONER[${j}]}_${DATASET[${i}]}_${iter}_executor1 -s EXECUTOR &
            ssh sith2 'bash -s' < ./myjstat.sh \
                -o ${ALGORITHM}_${PARTITIONER[${j}]}_${DATASET[${i}]}_${iter}_executor2 -s EXECUTOR &
            ssh sith3 'bash -s' < ./myjstat.sh \
                -o ${ALGORITHM}_${PARTITIONER[${j}]}_${DATASET[${i}]}_${iter}_executor3 -s EXECUTOR &

            # Start Time
            startTime=$(date --rfc-3339=seconds |sed 's/ /T/g')
            
            /opt/spark/spark-master/bin/spark-submit \
                --class org.apache.spark.examples.graphx.TestMultiPartitionStrategy \
                /opt/spark/spark-master/examples/target/scala-2.11/jars/spark-examples_2.11-2.2.0-SNAPSHOT.jar \
                ${ALGORITHM} \
                ${INPUT[${i}]} \
                ${ALGORITHM}_${NUM_PARTITION}_${CORES}/pagerank_${iter}.csv \
                ${PARTITIONER[${j}]} \
                ${PARTITION} 10 \
                ${DATASET[${i}]}

            # Stop Time
            stopTime=$(date --rfc-3339=seconds |sed 's/ /T/g')
           
            # Stop Spark
            /opt/spark/spark-master/sbin/stop-all.sh

            # Get cpu usage
            for ((i=0; i<7; i++))
            do
                if [ i -eq 4 ]
                then
                    i=7
                fi
                python3 query_csv.py "${CPU_query}" \
                    ${startTime} ${endTime} ${interval}
            done

            # Get cpu utilization
            ./cpu_usage.sh -s ${startTime} -e ${stopTime} -i 10s -o ${CPU_PATH}

            # Get memory utilization
            ./mem_usage.sh -s ${startTime} -e ${stopTime} -i 10s -o ${MEM_PATH}

            # Get disk utilization
            ./disk_usage.sh -s ${startTime} -e ${stopTime} -i 10s -o ${DISK_PATH}

            # Get network utilization
            ./net_usage.sh -s ${startTime} -e ${stopTime} -i 10s -o ${NET_PATH}

        done
    done
done

# Create directories for the results
mkdir -p ${ALGORITHM}_${NUM_PARTITION}_${CORES}
mkdir -p ${ALGORITHM}_${NUM_PARTITION}_${CORES}/gc_master
mkdir -p ${ALGORITHM}_${NUM_PARTITION}_${CORES}/gc_executors

# Move all the results to the directories 
mv *_*_*_*_master* ${ALGORITHM}_${NUM_PARTITION}_${CORES}/gc_master
mv ~/*_*_*_*_executor* ${ALGORITHM}_${NUM_PARTITION}_${CORES}/gc_executors

exit
