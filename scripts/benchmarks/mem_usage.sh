
###################################################
#
# file: mem_usage.sh
#
# @Author:   Iacovos G. Kolokasis
# @Version:  01-06-2018
# @email:    kolokasis@ics.forth.gr
#
# @desc     Resourses usage calculation script.
# The informations provided internally by the
# prometheus application. 
# Provide informations about:
#   - Memory Usage 
#     (applications)
#
###################################################

# Print error/usage script message
usage() {
    echo
    echo "Usage:"
    printf "      ./cpu_usage.sh -s <start_time> -e <end_time> -i <interval>"
    printf " -o <output_dir> [-h]\n"
    echo
    echo "Options:"
    echo "      -s  Start time"
    echo "      -e  End time"
    echo "      -i  Interval"
    echo "      -o  Output Directory"
    echo "      -h  Show usage"
    echo

    exit 1
}

# Check for the input arguments
while getopts ":s:e:i:o:h" opt
do
    case "${opt}" in
        s)
            startTime=${OPTARG}
            ;;
        e)
            endTime=${OPTARG}
            ;;
        i)
            interval=${OPTARG}
            ;;
        o)
            output=${OPTARG}
            ;;
        h)
            usage
            ;;
        *)
            usage
            ;;
    esac
done

# Promitheus provider
PROMITHEUS="http://ray1:9090"

for ((i=0; i<7; i++))
do
    if [ ${i} -eq 4 ]
    then
        i=7
    fi

    # Prometheus Memory query
    query="(node_memory_MemTotal{instance=~'sith${i}:9100'}\
        -node_memory_MemFree{instance=~'sith${i}:9100'}\
        -node_memory_Buffers{instance=~'sith${i}:9100'}\
        -node_memory_Buffers{instance=~'sith${i}:9100'}\
        -node_memory_Cached{instance=~'sith${i}:9100'}\
        -node_memory_SwapCached{instance=~'sith${i}:9100'}\
        -node_memory_Slab{instance=~'sith${i}:9100'}\
        -node_memory_PageTables{instance=~'sith${i}:9100'}\
        -node_memory_VmallocUsed{instance=~'sith${i}:9100'})"

    python3 query_csv.py ${PROMITHEUS} "${query}" ${startTime} ${endTime} \
        ${interval} > ${output}/sith${i}.csv

done
