
###################################################
#
# file: net_usage.sh
#
# @Author   Iacovos G. Kolokasis
# @Version  01-06-2018
# @email    kolokasis@ics.forth.gr
#
# @desc     Resourses usage calculation script.
# The informations provided internally by the
# prometheus application. 
# Provide informations about:
#   - Network utilization (40Gb network)
#
# +-------------------------------------+
# |     Host Name     |     Device      |
# +-------------------+-----------------+
# |       sith0       |                 |
# +-------------------+                 |
# |       sith1       |                 |
# +-------------------+                 |
# |       sith2       |      ens10      |
# +-------------------+                 |
# |       sith3       |                 |
# +-------------------+                 |
# |       sith7       |                 |
# +-------------------+-----------------+
#
###################################################

# Print error/usage script message
usage() {
    echo
    echo "Usage:"
    printf "      ./cpu_usage.sh -s <start_time> -e <end_time> -i <interval>"
    printf " -o <output-_dir> [-h]\n"
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

    # Promitheus network usage query
    NET_rec_query="irate(\
        node_network_receive_bytes{\
        device='ens10',instance=~'sith${i}:9100'}[5m])*8"

    NET_trans_query="irate(\
        node_network_transmit_bytes{\
        device='ens10',instance=~'sith${i}:9100'}[5m])*8"

    python3 query_csv.py ${PROMITHEUS} \
        "${NET_rec_query}" ${startTime} ${endTime} ${interval} \
        > ${output}/net_rec_sith${i}.csv

    python3 query_csv.py ${PROMITHEUS} \
        "${NET_trans_query}" ${startTime} ${endTime} ${interval} \
        > ${output}/net_trans_sith${i}.csv
done
