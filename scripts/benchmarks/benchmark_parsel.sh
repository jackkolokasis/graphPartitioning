#!/usr/bin/env bash

###################################################
#
# file: benchmark.sh
#
# @Author  Iacovos G. Kolokasis
# @Version 01-06-2018
# @email   kolokasis@ics.forth.gr
#
# @brief   Execute benchmarks for a specific input
# graph algorithm and specific number of
# partitions on a viriety type and size graph
# datasets. Based on this script execution we
# examine how the different partitioners
# implemented in GraphX - Spark depends on the
# total execution time.
# Note:
#          This benchmark script must run on CARV
#          cluster (sith0-3, sith7)
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
             "HybridCutPlus"\
             "CarvCut")

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

# TODO 
# Fix random vertices for the files
vertexRoadUsa=( "2809638"\
                "4845403"\
                "4435467"\
                "3362522"\
                "1223466")

vertexWebWikipedia=("1757067"\
                    "3196308"\
                    "288127"\
                    "192846"\
                    "544664")

vertexSocTwitter=("2"\
                  "3"\
                  "429845"\
                  "5"\
                  "7")

vertexSinaWeibo=("254122"\
                 "55315"\
                 "280541"\
                 "188298"\
                 "116779")

vertexSocFb=("381274"\
             "381532"\
             "382079"\
             "3"\
             "7")

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
# cpu/algorithm/dataset/partitioner/partitions/
for dataset in "${DATASET[@]}"
do
    mkdir -p cpu/${ALGORITHM}/${dataset}
    mkdir -p mem/${ALGORITHM}/${dataset}
    mkdir -p diskIO/${ALGORITHM}/${dataset}
    mkdir -p network/${ALGORITHM}/${dataset}

    for p in "${PARTITIONER[@]}"
    do
        mkdir -p cpu/${ALGORITHM}/${dataset}/${p}/${NUM_PARTITION}
        mkdir -p mem/${ALGORITHM}/${dataset}/${p}/${NUM_PARTITION}
        mkdir -p diskIO/${ALGORITHM}/${dataset}/${p}/${NUM_PARTITION}
        mkdir -p network/${ALGORITHM}/${dataset}/${p}/${NUM_PARTITION}
    done
done

# Execution time directory
mkdir -p ${ALGORITHM}_${NUM_PARTITION}_${CORES}

# Header row for experiments log file
printf "Algorithm;Dataset;Partitioner;StartTime;EndTime\n" \
    >> experiments_log.csv

vertex_a=0
vertex_b=0

#Create a folder for the total execution time results

for ((i=3; i<${#INPUT[@]}; i++))
do
    for ((iter=0; iter<${MAX_ITERATIONS}; iter++))
    do
        if [ ${ALGORITHM} = "sssp" ]
        then
            if [ ${iter} -eq 4 ]
            then
                if [ ${DATASET[$i]} = "road-usa" ]
                then
                    vertex_a=${vertexRoadUsa[${iter}]}
                    vertex_b=${vertexRoadUsa[0]}

                elif [ ${DATASET[$i]} = "socfb-uci-uni" ]
                then
                    vertex_a=${vertexSocFb[${iter}]}
                    vertex_b=${vertexSocFb[0]}

                elif [ ${DATASET[$i]} = "web-wikipedia_link_fr" ]
                then
                    vertex_a=${vertexWebWikipedia[${iter}]}
                    vertex_b=${vertexWebWikipedia[0]}

                elif [ ${DATASET[$i]} = "soc_sinaweibo" ]
                then
                    vertex_a=${vertexSinaWeibo[${iter}]}
                    vertex_b=${vertexSinaWeibo[0]}
                
                else 
                    vertex_a=${vertexSocTwitter[${iter}]}
                    vertex_b=${vertexSocTwitter[0]}
                fi
            else
                if [ ${DATASET[$i]} = "road-usa" ]
                then
                    vertex_a=${vertexRoadUsa[${iter}]}
                    vertex_b=${vertexRoadUsa[$((iter+1))]}
                
                elif [ ${DATASET[$i]} = "socfb-uci-uni" ]
                then
                    vertex_a=${vertexSocFb[${iter}]}
                    vertex_b=${vertexSocFb[$((iter+1))]}

                elif [ ${DATASET[$i]} = "web-wikipedia_link_fr" ]
                then
                    vertex_a=${vertexWebWikipedia[${iter}]}
                    vertex_b=${vertexWebWikipedia[$((iter+1))]}

                elif [ ${DATASET[$i]} = "soc_sianweibo" ]
                then
                    vertex_a=${vertexSinaWeibo[${iter}]}
                    vertex_b=${vertexSinaWeibo[$((iter+1))]}
                
                else 
                    vertex_a=${vertexSocTwitter[${iter}]}
                    vertex_b=${vertexSocTwitter[$((iter+1))]}
                fi
            fi
        else
            vertex_a=0
            vertex_b=0
        fi
        
        for  ((j=0; j<${#PARTITIONER[@]}; j++))
        do

            # Start Spark
            /opt/spark/spark-master/sbin/start-all.sh

            # Start running GC profilers on every spark node

            # Start Time
            startTime=$(date --rfc-3339=seconds |sed 's/ /T/g')

            if [ ${j} -lt 8 ]
            then
                /opt/spark/spark-master/bin/spark-submit \
                    --class org.apache.spark.examples.graphx.TestMultiPartitionStrategy \
                    /opt/spark/spark-master/examples/target/scala-2.11/jars/spark-examples_2.11-2.2.0-SNAPSHOT.jar \
                    ${ALGORITHM} \
                    ${INPUT[${i}]} \
                    ${ALGORITHM}_${NUM_PARTITION}_${CORES}/pagerank_${iter}.csv \
                    ${PARTITIONER[${j}]} \
                    ${NUM_PARTITION} 100 \
                    ${DATASET[${i}]} \
                    119000 ${vertex_a} ${vertex_b}
            else
                /opt/spark/spark-master/bin/spark-submit \
                    --class org.apache.spark.examples.graphx.TestMultiPartitionStrategy \
                    /opt/spark/spark-master/examples/target/scala-2.11/jars/spark-examples_2.11-2.2.0-SNAPSHOT.jar \
                    ${ALGORITHM} \
                    ${INPUT[${i}]} \
                    ${ALGORITHM}_${NUM_PARTITION}_${CORES}/pagerank_${iter}.csv \
                    ${PARTITIONER[${j}]} \
                    ${NUM_PARTITION} 100 \
                    ${DATASET[${i}]} \
                    119000 ${vertex_a} ${vertex_b}
            fi

            # Stop Time
            stopTime=$(date --rfc-3339=seconds |sed 's/ /T/g')
           
            # Stop Spark
            /opt/spark/spark-master/sbin/stop-all.sh

            # Get cpu utilization
            ./cpu_usage.sh -s ${startTime} -e ${stopTime} -i 5s \
                -o cpu/${ALGORITHM}/${DATASET[${i}]}//${PARTITIONER[${j}]}/${NUM_PARTITION}

            # Get memory utilization
            ./mem_usage.sh -s ${startTime} -e ${stopTime} -i 5s \
                -o mem/${ALGORITHM}/${DATASET[${i}]}/${PARTITIONER[${j}]}/${NUM_PARTITION}

            # Get disk utilization
            ./disk_usage.sh -s ${startTime} -e ${stopTime} -i 5s \
                -o diskIO/${ALGORITHM}/${DATASET[${i}]}/${PARTITIONER[${j}]}/${NUM_PARTITION}
            
            # Get network utilization
            ./net_usage.sh -s ${startTime} -e ${stopTime} -i 5s \
                -o network/${ALGORITHM}/${DATASET[${i}]}/${PARTITIONER[${j}]}/${NUM_PARTITION}

            printf "${ALGORITHM};${DATASET[${i}]};" >> experiments_log.csv
            printf "${PARTITIONER[${j}]};" >> experiments_log.csv
            printf "${startTime};${stopTime}\n" >> experiments_log.csv
        done
    done
done
