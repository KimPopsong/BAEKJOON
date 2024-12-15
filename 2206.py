import sys
from collections import deque

rowSize, colSize = map(int, sys.stdin.readline().rsplit())

if (rowSize == 1 and colSize == 1):
    print(1)

    exit()

graph = []
for i in range(rowSize):
    graph.append(list(map(int, sys.stdin.readline().rstrip())))

time = 1
bfs = deque()  # [r, c, 벽을 부순 횟수]
isVisit = [[False for i in range(colSize)] for i in range(rowSize)]

bfs.append([0, 0, 0])
isVisit[0][0] = True

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

while (bfs):
    time += 1

    tempBfs = deque(bfs)
    bfs.clear()

    while (tempBfs):
        r, c, wall = tempBfs.popleft()

        for i in range(4):
            rr = r + dr[i]
            cc = c + dc[i]

            if (rr == rowSize - 1 and cc == colSize - 1):  # 도착지점에 도착했다면
                print(time)

                exit()

            if (0 <= rr < rowSize and 0 <= cc < colSize):  # 범위 안에 있고
                if (wall == 1):  # 벽을 한 번 통과하였고
                    if (graph[rr][cc] == 0):  # 갈 수 있는 길이고
                        if (isVisit[rr][cc] == False):  # 방문하지 않은 장소라면
                            bfs.append([rr, cc, 1])  # 방문
                            isVisit[rr][cc] = 'B'

                else:  # 벽을 통과하지 않았고
                    if (isVisit[rr][cc] != True):  # 방문 가능한 장소라면
                        if (graph[rr][cc] == 1):
                            bfs.append([rr, cc, 1])
                            isVisit[rr][cc] = 'B'

                        else:
                            bfs.append([rr, cc, 0])
                            isVisit[rr][cc] = True

print(-1)
