import sys
from collections import deque

row, col = map(int, sys.stdin.readline().rsplit())

campus = []

originR, originC = 0, 0  # 도연이의 시작 위치
meet = 0  # 만난 사람의 수

for _ in range(row):
    campus.append(list(sys.stdin.readline().rstrip()))

for i in range(row):  # 도연이의 위치 구하기
    for j in range(col):
        if (campus[i][j] == "I"):
            originR, originC = i, j

            break

bfs = deque()
isVisit = [[False for i in range(col)] for j in range(row)]

bfs.append([originR, originC])
isVisit[originR][originC] = True

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

while (len(bfs)):
    r, c = bfs.popleft()

    for i in range(4):
        rr = r + dr[i]
        cc = c + dc[i]

        if (0 <= rr < row and 0 <= cc < col):  # 범위 안에 있고
            if (campus[rr][cc] != "X"):  # 벽이 아니고
                if (isVisit[rr][cc] == False):  # 방문하지 않았다면
                    bfs.append([rr, cc])  # 방문
                    isVisit[rr][cc] = True

                    if (campus[rr][cc] == "P"):  # 사람을 만났다면
                        meet += 1

if (meet == 0):  # 아무도 못만났다면
    print("TT")

else:
    print(meet)
