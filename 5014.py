import sys
from collections import deque

buildingFloor, nowFloor, destination, up, down = map(int,
                                                     sys.stdin.readline().rsplit())  # 건물의 높이, 현재 위치, 목적지, 위로 이동, 아래로 이동

floor = dict()  # 각 층별 버튼의 최솟값

bfs = deque()

bfs.append(nowFloor)
floor[nowFloor] = 0

while (bfs):
    f = bfs.popleft()
    move = floor[f]

    if (f + up <= buildingFloor):
        if (f + up not in floor.keys()):
            floor[f + up] = move + 1
            bfs.append(f + up)

    if (1 <= f - down):
        if (f - down not in floor.keys()):
            floor[f - down] = move + 1
            bfs.append(f - down)

if (destination in floor.keys()):
    print(floor[destination])

else:
    print("use the stairs")
