#!/bin/bash

###################################################
#
# file: myjstat.sh
#
# @Author:  Iacovos G. Kolokasis
# @Version: 04-05-2018
# @email:   kolokasis@ics.forth.gr
#
# @brief    This script use jstat to monitor the Garbage Collection on the Spark
# setup. Find out the proccess id of the executor or the master, from the jps
# and then execute the jstat.  All the informations are saved in an output file.
#
###################################################

# Print error/usage script message
usage() {
    echo
    echo "Usage:"
    echo "      ./benchmark.sh -o <output> -s <setup> [-h]"
    echo
    echo "Options:"
    echo "      -o  Output file name"
    echo "      -s  Setup use (Master/Executor)"
    echo "      -h  Show usage"
    echo

    exit 1
}

while getopts ":o:s:h" opt
do
   case "${opt}" in
       o)
           OUTPUT=${OPTARG}
           ;;
       s)
           SETUP=${OPTARG}
           ;;
       h)
           usage
           ;;
       *)
           usage
           ;;
   esac
done

if [ $# -lt 4 ]
then
    usage
fi

#Get the proccess id from the running
processId=""

# Check if we profile Master or Executors
if [ ${SETUP} = "MASTER" ]
then
	while [ -z ${processId} ] 
	do
		processId=$(jps |\
			grep "SparkSubmit" |\
			awk '{split($0,array," "); print array[1]}')
	done
else	
	while [ -z ${processId} ] 
	do
		processId=$(jps |\
			grep "CoarseGrainedExecutorBackend" |\
			awk '{split($0,array," "); print array[1]}')
	done
fi

# Call jstat
jstat -gc ${processId} 100 > ${OUTPUT}.txt

exit
