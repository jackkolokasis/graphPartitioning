
###################################################
#
# file: disk_usage.sh
#
# @Author:   Iacovos G. Kolokasis
# @Version:  01-06-2018
# @email:    kolokasis@ics.forth.gr

# @desc     Resourses usage calculation script.
# The informations provided internally by the
# prometheus application. 
# Provide informations about:
#   - Disk I/O utilization
#
#    +------------------------------------------+
#    |     Host Name     |   HDFS   |    TMP    |
#    +-------------------+----------+-----------+
#    |       sith0       |    ---   | /dev/sdb  |
#    +-------------------+----------+-----------+
#    |       sith1       | /dev/sdb | /dev/sdc  |
#    +-------------------+----------+-----------+
#    |       sith2       | /dev/sdb | /dev/sdc  | 
#    +-------------------+----------+-----------+
#    |       sith3       | /dev/sdd | /dev/sdc  |
#    +-------------------+----------+-----------+
#    |       sith7       | /dev/sdc | /dev/sdb  |
#    +-------------------+----------+-----------+
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

    if [ ${i} -eq 0 ]
    then
        hdfs_device=""
        tmp_device="sdb"

    elif [ ${i} -gt 0 ] && [ ${i} -lt 3 ]
    then
        hdfs_device="sdb"
        tmp_device="sdc"

    elif [ ${i} -eq 3 ]
    then
        hdfs_device="sdd"
        tmp_device="sdc"

    elif [ ${i} -eq 7 ]
    then
        hdfs_device="sdc"
        tmp_device="sdb"
    fi

    if [ ${i} -eq 0 ]
    then
        # Set up queries
        DISK_tmp_read_query="irate(node_disk_reads_completed{\
            device='${tmp_device}',instance=~'sith${i}:9100'}[5m])"

        DISK_tmp_write_query="irate(node_disk_writes_completed{\
            device='${tmp_device}',instance=~'sith${i}:9100'}[5m])"

        # Execute queries
        python3 query_csv.py ${PROMITHEUS} \
            "${DISK_tmp_read_query}" ${startTime} ${endTime} ${interval} \
            > ${output}/tmp_read_sith${i}.csv
        
        python3 query_csv.py ${PROMITHEUS} \
            "${DISK_tmp_write_query}" ${startTime} ${endTime} ${interval} \
            > ${output}/tmp_write_sith${i}.csv

    else
        # Set up queries
        DISK_hdfs_read_query="irate(node_disk_reads_completed{\
            device='${hdfs_device}',instance=~'sith${i}:9100'}[5m])"

        DISK_hdfs_write_query="irate(node_disk_writes_completed{\
            device='${hdfs_device}',instance=~'sith${i}:9100'}[5m])"

        DISK_tmp_read_query="irate(node_disk_reads_completed{\
            device='${tmp_device}',instance=~'sith${i}:9100'}[5m])"

        DISK_tmp_write_query="irate(node_disk_writes_completed{\
            device='${tmp_device}',instance=~'sith${i}:9100'}[5m])"

        # Execute queries
        python3 query_csv.py ${PROMITHEUS} \
            "${DISK_hdfs_read_query}" ${startTime} ${endTime} ${interval} \
            > ${output}/hdfs_read_sith${i}.csv
        
        python3 query_csv.py ${PROMITHEUS} \
            "${DISK_hdfs_write_query}" ${startTime} ${endTime} ${interval} \
            > ${output}/hdfs_write_sith${i}.csv
        
        python3 query_csv.py ${PROMITHEUS} \
            "${DISK_tmp_read_query}" ${startTime} ${endTime} ${interval} \
            > ${output}/tmp_read_sith${i}.csv
        
        python3 query_csv.py ${PROMITHEUS} \
            "${DISK_tmp_write_query}" ${startTime} ${endTime} ${interval} \
            > ${output}/tmp_write_sith${i}.csv
    fi
done
