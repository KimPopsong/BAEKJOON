import sys
from collections import deque

sharkNum, shakEat, shakSize = map(int, sys.stdin.readline().split())
shark = sorted(list(map(int, sys.stdin.readline().split())))

smallStack = []  # 샥이 먹을 수 있는 상어
bigQueue = deque()  # 샥이 먹을 수 없는 상어

for i in range(sharkNum):
    if (shark[i] >= shakSize):
        bigQueue.append(shark[i])

    else:
        smallStack.append(shark[i])

for i in range(shakEat):
    if (len(smallStack) == 0):  # 먹을 수 있는 상어가 없다면 탈출
        break

    shakSize += smallStack.pop()

    for j in range(len(bigQueue)):
        t = bigQueue.popleft()

        if (t >= shakSize):
            bigQueue.appendleft(t)
            break

        else:
            smallStack.append(t)

print(shakSize)
