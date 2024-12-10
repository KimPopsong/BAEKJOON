import sys, copy
from collections import deque

rowSize, colSize = map(int, sys.stdin.readline().rsplit())

iceberg = []  # 빙하 배열
for row in range(rowSize):
    iceberg.append(list(map(int, sys.stdin.readline().rsplit())))

time = 0
flag = True
while (flag):
    flag = False

    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]

    for r in range(1, rowSize - 1):  # 빙하가 모두 녹았는지 확인
        for c in range(1, colSize - 1):  # 첫 행렬, 마지막 행렬은 항상 바다이므로 탐색하지 않음
            if (iceberg[r][c] != 0):  # 빙하가 모두 녹지 않았다면
                flag = True

        if (flag):
            break

    if (flag == False):  # 빙하가 모두 녹았다면 종료
        break

    bfs = deque()  # 빙하가 분리되었는지 확인
    isVisit = [[False for i in range(colSize)] for j in range(rowSize)]

    area = 0
    for r in range(1, rowSize - 1):
        for c in range(1, colSize - 1):
            if (iceberg[r][c] != 0):  # 빙하가 아니고
                if (isVisit[r][c] == False):  # 방문하지 않았다면
                    area += 1

                    bfs.append([r, c])
                    isVisit[r][c] = True

                    while (bfs):
                        row, col = bfs.popleft()

                        for i in range(4):
                            rr = row + dr[i]
                            cc = col + dc[i]

                            if (0 <= rr < rowSize and 0 <= cc < colSize):  # 범위 안에 있고
                                if (iceberg[rr][cc] != 0):  # 바다가 아니고
                                    if (isVisit[rr][cc] == False):  # 방문하지 않은 빙하라면
                                        bfs.append([rr, cc])
                                        isVisit[rr][cc] = True

    if (area >= 2):  # 2개 이상의 구역으로 분리되었다면 종료
        break

    # 빙하 녹이기
    time += 1
    melt = [[0 for i in range(colSize)] for j in range(rowSize)]  # 빙하가 얼마나 녹는지 저장

    for r in range(1, rowSize - 1):  # 어느 빙하가 얼만큼 녹는지 계산
        for c in range(1, colSize - 1):
            if (iceberg[r][c] != 0):  # 빙하라면
                seaCount = 0

                for i in range(4):  # 바다와 맞닿는 면적 계산
                    rr = r + dr[i]
                    cc = c + dc[i]

                    if (iceberg[rr][cc] == 0):  # 맞닿는 부분이 바다라면
                        seaCount += 1

                melt[r][c] = seaCount

    for r in range(1, rowSize - 1):  # 빙하 녹이기
        for c in range(1, colSize - 1):
            iceberg[r][c] -= melt[r][c]

            if (iceberg[r][c] < 0):
                iceberg[r][c] = 0

if (flag):
    print(time)

else:
    print(0)
