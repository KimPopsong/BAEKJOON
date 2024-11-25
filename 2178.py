import sys
from collections import deque

row, col = map(int, sys.stdin.readline().split())  # 미로의 세로, 가로의 길이

maze = []  # 미로 배열 저장
bfs = deque()
isVisit = [[False for _ in range(col)] for _ in range(row)]

bfs.append([0, 0])  # 시작점은 (0, 0)
isVisit[0][0] = True

move = 1  # 자기 자신도 포함

for _ in range(row):
    maze.append(list(map(int, sys.stdin.readline().strip())))

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

while (bfs):
    move += 1

    tempBfs = deque(bfs)
    bfs.clear()

    while (tempBfs):
        r, c = tempBfs.popleft()

        for i in range(4):
            rr = r + dr[i]
            cc = c + dc[i]

            if (0 <= rr < row and 0 <= cc < col):  # 범위 안에 있고
                if (maze[rr][cc] == 1):  # 갈 수 있는 길이고
                    if (isVisit[rr][cc] == False):  # 가지 않았던 길이라면
                        bfs.append([rr, cc])  # 방문 예정에 추가
                        isVisit[rr][cc] = True

                        if (rr == row - 1 and cc == col - 1):  # 목적지에 도착했다면 탐색 종료
                            bfs.clear()
                            tempBfs.clear()

                            break

print(move)
