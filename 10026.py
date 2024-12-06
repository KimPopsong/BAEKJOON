import sys
from collections import deque

size = int(sys.stdin.readline().rstrip())

paint = []

for i in range(size):
    paint.append(list(sys.stdin.readline().rstrip()))

dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]

bfsNormal = deque()
isNormal = [[False for i in range(size)] for i in range(size)]
areaNumberNormal = 0

for row in range(size):  # 정상인 탐색
    for col in range(size):
        if (isNormal[row][col] == False):  # 방문하지 않은 노드라면
            bfsNormal.append([row, col])  # 방문 예정 목록에 추가
            isNormal[row][col] = True
            nodColor = paint[row][col]  # 기준 색상

            areaNumberNormal += 1

            while (bfsNormal):  # BFS
                r, c = bfsNormal.popleft()

                for i in range(4):  # 상하좌우 탐색
                    rr = r + dr[i]
                    cc = c + dc[i]

                    if (0 <= rr < size and 0 <= cc < size):  # 범위 안에 있고
                        if (paint[rr][cc] == nodColor):  # 같은 색상이고
                            if (isNormal[rr][cc] == False):  # 방문하지 않은 곳이라면
                                bfsNormal.append([rr, cc])  # 방문
                                isNormal[rr][cc] = True

for row in range(size):  # 적록색약용 그림으로 변경
    for col in range(size):
        if (paint[row][col] == "G"):  # 초록색을
            paint[row][col] = "R"  # 빨강으로

bfsColorBlind = deque()
isColorBlind = [[False for i in range(size)] for i in range(size)]
areaNumberColorBlind = 0

for row in range(size):  # 적록색약 탐색
    for col in range(size):
        if (isColorBlind[row][col] == False):  # 방문하지 않은 노드라면
            bfsColorBlind.append([row, col])  # 방문 예정 목록에 추가
            isColorBlind[row][col] = True
            nodColor = paint[row][col]  # 기준 색상

            areaNumberColorBlind += 1

            while (bfsColorBlind):  # BFS
                r, c = bfsColorBlind.popleft()

                for i in range(4):  # 상하좌우 탐색
                    rr = r + dr[i]
                    cc = c + dc[i]

                    if (0 <= rr < size and 0 <= cc < size):  # 범위 안에 있고
                        if (paint[rr][cc] == nodColor):  # 같은 색상이고
                            if (isColorBlind[rr][cc] == False):  # 방문하지 않은 곳이라면
                                bfsColorBlind.append([rr, cc])  # 방문
                                isColorBlind[rr][cc] = True

print(areaNumberNormal, areaNumberColorBlind)
