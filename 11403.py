import sys
from collections import deque

nodNumber = int(sys.stdin.readline().rstrip())

nods = []

for _ in range(nodNumber):
    nods.append(list(map(int, sys.stdin.readline().rsplit())))

for nod in range(nodNumber):
    isVisit = [False for i in range(nodNumber)]

    bfs = deque()
    bfs.append(nod)

    while (len(bfs)):
        togo = bfs.popleft()

        for i in range(nodNumber):
            if (nods[togo][i] == 1):  # 갈 수 있는 노드이고
                if (isVisit[i] == False):  # 가보지 않은 노드라면
                    bfs.append(i)
                    nods[nod][i] = 1
                    isVisit[i] = True

for nod in nods:  # 답안 출력
    for n in nod:
        print(n, end=" ")
    print()
