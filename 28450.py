import sys

rowSize, colSize = map(int, sys.stdin.readline().rsplit())

graph = []
for i in range(rowSize):
    graph.append(list(map(int, sys.stdin.readline().rsplit())))

stealth = int(sys.stdin.readline().rstrip())

for i in range(1, colSize):
    graph[0][i] += graph[0][i - 1]

for i in range(1, rowSize):
    graph[i][0] += graph[i - 1][0]

for r in range(1, rowSize):
    for c in range(1, colSize):
        graph[r][c] += min(graph[r - 1][c], graph[r][c - 1])

if (graph[rowSize - 1][colSize - 1] <= stealth):
    print("YES")
    print(graph[rowSize - 1][colSize - 1])

else:
    print("NO")
