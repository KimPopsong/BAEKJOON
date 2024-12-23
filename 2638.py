import sys
from collections import deque

global rowSize, colSize


def checkCheese(graph):  # 공기와 맞닿는 치즈 확인
    air = deque()

    isVisit = [[0 for _ in range(colSize)] for _ in range(rowSize)]

    air.append([0, 0])  # 모눈종이의 가장자리는 항상 공기
    isVisit[0][0] = True

    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    while (air):
        r, c = air.popleft()

        for i in range(4):
            rr = r + dr[i]
            cc = c + dc[i]

            if (0 <= rr < rowSize and 0 <= cc < colSize):  # 범위 안에 있고
                if (graph[rr][cc] == 1):  # 치즈라면
                    isVisit[rr][cc] += 1

                else:  # 공기라면
                    if (isVisit[rr][cc] == 0):
                        air.append([rr, cc])
                        isVisit[rr][cc] = -1

    cheese = checkMeltCheese(isVisit)

    return cheese


def checkMeltCheese(graph):  # 2면 이상 공기와 닿는 치즈 확인
    cheese = deque()

    for r in range(rowSize):
        for c in range(colSize):
            if (graph[r][c] >= 2):
                cheese.append([r, c])

    return cheese


def melt(graph, cheese):  # 치즈 녹이기
    while (cheese):
        r, c = cheese.popleft()

        graph[r][c] = 0


rowSize, colSize = map(int, sys.stdin.readline().rsplit())

graph = []
time = 0

for i in range(rowSize):
    graph.append(list(map(int, sys.stdin.readline().rsplit())))

while (True):
    cheese = checkCheese(graph)

    if (len(cheese) == 0):  # 치즈가 다 녹았다면
        break

    time += 1

    melt(graph, cheese)

print(time)
