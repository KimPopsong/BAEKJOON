import sys
from collections import deque

tomatoes = []
day = -1
flag = True

width, height, depth = map(int, sys.stdin.readline().split())

bfs = deque()

for i in range(depth):
    temp = []

    for j in range(height):
        temp.append(list(map(int, sys.stdin.readline().split())))
    tomatoes.append(temp)

for i in range(depth):
    for j in range(height):
        for k in range(width):
            if (tomatoes[i][j][k] == 1):
                bfs.append([i, j, k])

while bfs:
    day += 1

    temp = bfs.copy()
    bfs.clear()

    dx = [-1, 1, 0, 0, 0, 0]
    dy = [0, 0, -1, 1, 0, 0]
    dz = [0, 0, 0, 0, -1, 1]

    while temp:
        d, h, w = temp.popleft()

        for i in range(6):
            if (d + dx[i] >= 0 and d + dx[i] < depth and h + dy[i] >= 0 and h + dy[i] < height and w + dz[
                i] >= 0 and w + dz[i] < width):
                if (tomatoes[d + dx[i]][h + dy[i]][w + dz[i]] == 0):
                    bfs.append([d + dx[i], h + dy[i], w + dz[i]])
                    tomatoes[d + dx[i]][h + dy[i]][w + dz[i]] = 1

for i in range(depth):
    for j in range(height):
        for k in range(width):
            if (tomatoes[i][j][k] == 0):
                flag = False
                break

if flag:
    print(day)

else:
    print(-1)
