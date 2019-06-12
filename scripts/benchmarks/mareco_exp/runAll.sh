#!/usr/bin/env bash

# TODO change num_partitions and num_cores
# Print error/usage script message

usage() {
    echo
    echo "Usage:"
    echo "      ./runAll.sh -n <num_partition> -c <num_cores> [-h]"
    echo
    echo "Options:"
    echo "      -n  Number of partitions"
    echo "      -c  Number of cores "
    echo "      -h  Show usage"
    echo

    exit 1
}

# Check for the input arguments
while getopts ":a:n:c:i:h" opt
do
    case "${opt}" in
        n)
            NUM_PARTITION=${OPTARG}
            ;;
        c)
            CORES=${OPTARG}
            ;;
        h)
            usage
            ;;
        *)
            usage
            ;;
    esac
done

./benchmark_parsel.sh -a pagerank -n ${NUM_PARTITION} -c ${CORES} -i 5
echo "PAGERANK      DONE"

./benchmark_parsel.sh -a cc -n ${NUM_PARTITION} -c ${CORES} -i 5
echo "CC      DONE"

./benchmark_parsel.sh -a triangles -n ${NUM_PARTITION} -c ${CORES} -i 5
echo "TRIANGLES      DONE"

./benchmark_parsel.sh -a sssp -n ${NUM_PARTITION} -c ${CORES} -i 5
echo "SSSP      DONE"

