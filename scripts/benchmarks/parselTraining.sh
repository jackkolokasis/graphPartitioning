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
             "DstCutPartition")

#PARTITIONER=("RandomVertexCut"\
#             "EdgePartition1D"\
#             "EdgePartition2D"\
#             "CanonicalRandomVertexCut"\
#             "SrcCutPartition"\
#             "DstCutPartition"\
#             "HybridCut"\
#             "HybridCutPlus"\
#             "CarvCut")

# Input Datasets
#INPUT=("hdfs://sith0-hadoop:9000/user/kolokasis/roadNet-CA.txt"\
#       "hdfs://sith0-hadoop:9000/user/kolokasis/soc-LiveJournal1.txt"\
#       "hdfs://sith0-hadoop:9000/user/kolokasis/follow-dec-2017.txt"\
#       "hdfs://sith0-hadoop:9000/user/kolokasis/com-orkut.ungraph.txt"\
#       "hdfs://sith0-hadoop:9000/user/kolokasis/soc-pokec-relationships.txt"\
#       "hdfs://sith0-hadoop:9000/user/kolokasis/follow.txt")
#
## Dataset Names
#DATASET=("roadNet-CA"\
#         "socLiveJournal"\
#	     "follow_dec"\
#         "orkut"\
#         "pokec"\

INPUT=("hdfs://sith0-hadoop:9000/user/kolokasis/com-orkut.ungraph.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/com-youtube.ungraph.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/follow-dec-2017.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/follow.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/roadNet-CA.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/roadNet-PA.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/roadNet-TX.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/soc-LiveJournal1.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/soc-pokec-relationships.txt"\
       "hdfs://sith0-hadoop:9000/user/kolokasis/web-uk-2005-all.txt")
# Dataset Names
DATASET=("orkut"\
         "youtube"\
         "follow_dec"\
         "follow"\
         "roadNet-CA"\
         "roadNet-PA"\
         "roadNet-TX"\
         "socLiveJournal"\
         "pokec"\
         "webSK")

vertexLiveJournal=( "2809638"\
                    "4845403"\
                    "4435467"\
                    "3362522"\
                    "1223466")

vertexWebSK=( "1"\
              "2"\
              "3"\
              "4"\
              "5")

vertexFollowDec=("446262596"\
                 "355437738"\
                 "1000000038"\
                 "1000000134"\
                 "1044503624")

vertexOrkut=("872689"\
             "665279"\
             "1725214"\
             "820956"\
             "603909")

vertexPokec=("1585432"\
             "609933"\
             "1275198"\
             "295504"\
             "621507")

vertexFollow=("15699351"\
              "549883032"\
              "1000000134"\
              "124158704"\
              "1626473317")

vertexYoutube=("1157458"\
              "1157538"\
              "1157572"\
              "1157682"\
              "1157570")

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
#for ((i=3; i<${#INPUT[@]}; i++))
for ((i=9; i<10; i++))
do
    for ((iter=0; iter<${MAX_ITERATIONS}; iter++))
    do
        if [ ${ALGORITHM} = "sssp" ]
        then
            if [ ${iter} -eq 4 ]
            then
                if [ ${DATASET[$i]} = "socLiveJournal" ]
                then
                    vertex_a=${vertexLiveJournal[${iter}]}
                    vertex_b=${vertexLiveJournal[0]}

                elif [ ${DATASET[$i]} = "webSK" ]
                then
                    vertex_a=${vertexWebSK[${iter}]}
                    vertex_b=${vertexWebSK[0]}
                
                elif [ ${DATASET[$i]} = "follow_dec" ]
                then
                    vertex_a=${vertexFollowDec[${iter}]}
                    vertex_b=${vertexFollowDec[0]}

                elif [ ${DATASET[$i]} = "orkut" ]
                then
                    vertex_a=${vertexOrkut[${iter}]}
                    vertex_b=${vertexOrkut[0]}

                elif [ ${DATASET[$i]} = "pokec" ]
                then
                    vertex_a=${vertexPokec[${iter}]}
                    vertex_b=${vertexPokec[0]}
                
                elif [ ${DATASET[$i]} = "youtube" ]
                then
                    vertex_a=${vertexYoutube[${iter}]}
                    vertex_b=${vertexYoutube[0]}
                
                else 
                    vertex_a=${vertexFollow[${iter}]}
                    vertex_b=${vertexFollow[0]}
                fi
            else
                if [ ${DATASET[$i]} = "socLiveJournal" ]
                then
                    vertex_a=${vertexLiveJournal[${iter}]}
                    vertex_b=${vertexLiveJournal[$((iter+1))]}
                
                elif [ ${DATASET[$i]} = "webSK" ]
                then
                    vertex_a=${vertexWebSK[${iter}]}
                    vertex_b=${vertexWebSK[$((iter+1))]}
                
                elif [ ${DATASET[$i]} = "follow_dec" ]
                then
                    vertex_a=${vertexFollowDec[${iter}]}
                    vertex_b=${vertexFollowDec[$((iter+1))]}

                elif [ ${DATASET[$i]} = "orkut" ]
                then
                    vertex_a=${vertexOrkut[${iter}]}
                    vertex_b=${vertexOrkut[$((iter+1))]}

                elif [ ${DATASET[$i]} = "pokec" ]
                then
                    vertex_a=${vertexPokec[${iter}]}
                    vertex_b=${vertexPokec[$((iter+1))]}
                
                elif [ ${DATASET[$i]} = "youtube" ]
                then
                    vertex_a=${vertexYoutube[${iter}]}
                    vertex_b=${vertexYoutube[$((iter+1))]}
                
                else 
                    vertex_a=${vertexFollow[${iter}]}
                    vertex_b=${vertexFollow[$((iter+1))]}
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
                    100 ${vertex_a} ${vertex_b}
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
                    80000 ${vertex_a} ${vertex_b}
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
