import sys
from collections import deque

vertex, edge = map(int, sys.stdin.readline().split())  # 정점, 간선

matrix = [[False for i in range(vertex)] for i in range(vertex)]

for _ in range(edge):
    v1, v2 = map(int, sys.stdin.readline().split())

    v1 -= 1  # index로 표시하기 위해 1씩 감소
    v2 -= 1

    matrix[v1][v2] = True
    matrix[v2][v1] = True

isVisit = [False for i in range(vertex)]
connectedComponents = 0

bfs = deque()
bfs.append(0)
isVisit[0] = True
connectedComponents += 1

while (True):
    flag = True

    if (len(bfs) == 0):
        flag = False

        for i in range(vertex):
            if (isVisit[i] == False):  # 방문하지않은 정점이 있을 경우
                connectedComponents += 1
                bfs.append(i)
                isVisit[i] = True
                flag = True

                break

        if (flag == False):
            break

    while (len(bfs)):
        node = bfs.pop()

        for i in range(vertex):
            if (matrix[node][i] == True):  # 연결되어있고
                if (isVisit[i] == False):  # 방문하지않은 노드라면
                    bfs.append(i)
                    isVisit[i] = True

print(connectedComponents)
