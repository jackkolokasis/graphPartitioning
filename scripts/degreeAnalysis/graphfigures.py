#!/usr/bin/env python

'''
This tool plots log-log plots of distributions given as x, y pairs in
txt files.  Each filename is the plot label for the corresponding
line.  argv[1] is title of the graph and output file name, rest of
argv are input datasets.

Use with graphs after counting edges:
cat weighted.graph.txt | cut -f 1 -d" " | sort | uniq -c | cut -c 1-8 > weighted.graph.indegree.txt
cat weighted.graph.txt | cut -f 2 -d" " | sort | uniq -c | cut -c 1-8 > weighted.graph.outdegree.txt
cat weighted.graph.txt | cut -f 1,2 -d" " | tr " " "\n" | sort | uniq -c | cut -c 1-8 > weighted.graph.degree.txt
graphfigures.py -t Degre -o degree.png -x Degree weighted.graph.degree.txt
'''

import sys
import optparse
import numpy as np
import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot as plt

parser = optparse.OptionParser()
parser.add_option('-o', '--output', action='store', dest='output', default="output.png", help='Output file')
parser.add_option('-t', '--title', action='store', dest='title', default='Chart', help='Chart title')
parser.add_option('-x', '--xlabel', action='store', dest='xlabel', default="Degree", help='X axis')
(options, args) = parser.parse_args()

plt.yscale('log')
plt.xscale('log')
plt.grid(True, linestyle='--', color='grey', zorder=0)

CB_color_cycle = ['#3399ff', '#ff9933', '#00b33c', '#cc0000', '#9966ff']

i = 0

for inputfile in args:
  data = np.loadtxt(inputfile)
  title = inputfile.split('.')[0]
  sorted_data = np.sort(data)
  n = len(sorted_data)
  yvals=np.arange(n)/float(n-1)
  plt.plot(sorted_data, 1-yvals, "o", markeredgewidth=0.0, label=title, color=CB_color_cycle[i], zorder=2)
  i = i + 1

#plt.title(options.title)
#plt.xlabel(options.xlabel)
plt.xlabel(options.title)
#plt.ylabel('PMF')
plt.legend(loc=1, fontsize='medium')

plt.savefig(options.output, bbox_inches='tight', pad_inches=0)
