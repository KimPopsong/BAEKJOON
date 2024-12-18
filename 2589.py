import sys
from collections import deque

rowSize, colSize = map(int, sys.stdin.readline().split())

graph = []
treasure = 0

for i in range(rowSize):
    graph.append(list(sys.stdin.readline().rstrip()))

for startR in range(rowSize):
    for startC in range(colSize):
        if (graph[startR][startC] == 'L'):  # 육지일 경우
            time = -1

            bfs = deque()
            isVisit = [[False for i in range(colSize)] for i in range(rowSize)]

            bfs.append([startR, startC])
            isVisit[startR][startC] = True

            dr = [-1, 1, 0, 0]
            dc = [0, 0, 1, -1]
            while (bfs):
                time += 1

                tempBfs = deque(bfs)
                bfs.clear()

                while tempBfs:
                    r, c = tempBfs.popleft()

                    for i in range(4):
                        rr = r + dr[i]
                        cc = c + dc[i]

                        if (0 <= rr < rowSize and 0 <= cc < colSize):  # 범위 안에 있고
                            if (isVisit[rr][cc] == False):  # 방문하지 않았고
                                if (graph[rr][cc] == "L"):  # 육지라면
                                    bfs.append([rr, cc])
                                    isVisit[rr][cc] = True

            treasure = max(treasure, time)

print(treasure)
