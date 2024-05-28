import sys
from collections import deque

width, height = map(int, sys.stdin.readline().split())

tomato = []
day = -1
bfs = deque()
flag = True

for i in range(height):  # 토마토 입력
    tomato.append(list(map(int, sys.stdin.readline().split())))

for i in range(height):
    for j in range(width):
        if (tomato[i][j] == 1):
            bfs.append((i, j))

while len(bfs) != 0:  # BFS
    day += 1

    temp = bfs.copy()
    bfs.clear()

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while len(temp):
        r, c = temp.popleft()

        for i in range(4):
            if (r + dx[i] >= 0 and r + dx[i] < height and c + dy[i] >= 0 and c + dy[i] < width):
                if (tomato[r + dx[i]][c + dy[i]] == 0):
                    bfs.append([r + dx[i], c + dy[i]])
                    tomato[r + dx[i]][c + dy[i]] = 1

for i in range(height):
    for j in range(width):
        if (tomato[i][j] == 0):
            flag = False

if (flag):
    print(day)

else:
    print(-1)
