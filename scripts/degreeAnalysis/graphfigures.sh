#!/usr/bin/bash

###################################################
#
# file: graphfigures.sh
#
# @Author:   Iacovos G. Kolokasis
# @Version:  09-12-2018
# @email:    kolokasis@ics.forth.gr
#
# Degree Analysis
#
###################################################

INPUT=("/user/kolokasis/road-road-usa.txt"\
       "/user/kolokasis/socfb-uci-uni.txt"\
       "/user/kolokasis/web-wikipedia_link_fr.txt"\
       "/user/kolokasis/soc-sinaweibo.txt"\
       "/user/kolokasis/twitter-2010.txt")

# Dataset Names
DATASET=("road-road-usa"\
         "socfb-uci-uni"\
         "web-wikipedia-link-fr"\
         "soc-sinaweibo"\
         "soc-twitter-2010")

HDFS="/opt/spark/hadoop-2.6.4/bin/hdfs"

#for ((i=0; i<${#INPUT[@]}; i++)); do
#		${HDFS} dfs -cat ${INPUT[$i]} | cut -f 1 -d" " | sort -S 30G | uniq -c | cut -c 1-8 > ${DATASET[$i]}.indegree.txt
#		${HDFS} dfs -cat ${INPUT[$i]} | cut -f 2 -d" " | sort -S 30G | uniq -c | cut -c 1-8 > ${DATASET[$i]}.outdegree.txt
#done

python graphfigures.py \
    -t Indegree \
    -o indegree.png \
    -x Degree \
    ${DATASET[2]}.indegree.txt ${DATASET[4]}.indegree.txt ${DATASET[0]}.indegree.txt ${DATASET[3]}.indegree.txt ${DATASET[1]}.indegree.txt

python graphfigures.py \
    -t Outdegree \
    -o outdegree.png \
    -x Degree \
    ${DATASET[2]}.outdegree.txt ${DATASET[4]}.outdegree.txt ${DATASET[0]}.outdegree.txt ${DATASET[3]}.outdegree.txt ${DATASET[1]}.outdegree.txt
