#!/usr/bin/env bash

# TODO change num_partitions and num_cores

./benchmark.sh -a pagerank -n <num_partition> -c <num_cores> -i 5
echo "PAGERANK      DONE"

./benchmark.sh -a cc -n <num_partition> -c <num_cores> -i 5
echo "CC      DONE"

./benchmark.sh -a triangles -n <num_partition> -c <num_cores> -i 5
echo "TRIANGLES      DONE"

./benchmark.sh -a sssp -n <num_partition> -c <num_cores> -i 5
echo "SSSP      DONE"

