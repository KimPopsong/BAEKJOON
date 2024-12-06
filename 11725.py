import sys
from collections import deque

nodNumber = int(sys.stdin.readline().rstrip())

nodDict = dict()  # 용량 초과로 dictionary 사용

for _ in range(nodNumber - 1):
    nod1, nod2 = map(int, sys.stdin.readline().rsplit())

    if (nod1 in nodDict.keys()):
        nodDict[nod1].append(nod2)

    else:
        nodDict[nod1] = [nod2]

    if (nod2 in nodDict.keys()):
        nodDict[nod2].append(nod1)

    else:
        nodDict[nod2] = [nod1]

nodParent = [False for i in range(nodNumber + 1)]
nodParent[1] = 1

bfs = deque()
bfs.append(1)

while (bfs):
    nod = bfs.popleft()

    for n in nodDict[nod]:
        if (nodParent[n] == False):  # 부모 노드가 없다면
            nodParent[n] = nod  # nod가 부모 노드
            bfs.append(n)

for i in range(2, nodNumber + 1):  # 출력
    print(nodParent[i])
