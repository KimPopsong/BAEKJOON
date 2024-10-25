import sys
from collections import deque

global vertex, edge, startVertex, matrix


def dfs():
    searchResult = []

    isVisit = [False for i in range(vertex)]

    dfs = deque()
    dfs.append(startVertex)

    while (dfs):
        node = dfs.popleft()

        if (isVisit[node]):
            continue

        isVisit[node] = True
        searchResult.append(node + 1)

        for i in range(vertex - 1, -1, -1):
            if (matrix[node][i] == True):  # 연결되어있고
                if (isVisit[i] == False):  # 방문하지않은 노드라면 탐색
                    dfs.appendleft(i)

    return searchResult


def bfs():
    searchResult = [startVertex + 1]

    isVisit = [False for i in range(vertex)]

    bfs = deque()
    bfs.append(startVertex)
    isVisit[startVertex] = True

    while (bfs):
        node = bfs.popleft()

        for i in range(vertex):
            if (matrix[node][i] == True):
                if (isVisit[i] == False):
                    bfs.append(i)
                    isVisit[i] = True
                    searchResult.append(i + 1)

    return searchResult


vertex, edge, startVertex = map(int, sys.stdin.readline().split())  # 정점, 간선, 탐색을 시작할 정점의 번호
startVertex -= 1  # index로 표시하기위해 1 감소

matrix = [[False for i in range(vertex)] for i in range(vertex)]

for _ in range(edge):
    v1, v2 = map(int, sys.stdin.readline().split())

    v1 -= 1  # index로 표시하기 위해 1씩 감소
    v2 -= 1

    matrix[v1][v2] = True
    matrix[v2][v1] = True

dfsResult = dfs()
bfsResult = bfs()

for d in dfsResult:
    sys.stdout.write(str(d) + " ")
print()

for b in bfsResult:
    sys.stdout.write(str(b) + " ")
