import sys
from collections import defaultdict

trees = defaultdict(int)
treeNumber = 0

for line in sys.stdin:
    trees[line.strip()] += 1
    treeNumber += 1

trees = dict(sorted(trees.items()))

for tree in trees:
    print("%s %.4f" % (tree, trees[tree] / treeNumber * 100))
