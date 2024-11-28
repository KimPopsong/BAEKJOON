import sys
from collections import deque

peopleNumber, nodNumber = map(int, sys.stdin.readline().split())

nods = [[5001 for i in range(peopleNumber)] for i in range(peopleNumber)]  # 친구 관계를 표시
for _ in range(nodNumber):
    p1, p2 = map(int, sys.stdin.readline().split())

    p1 -= 1
    p2 -= 1

    nods[p1][p2] = 1
    nods[p2][p1] = 1

for people in range(peopleNumber):
    fw = deque()

    for i in range(peopleNumber):
        if (nods[people][i] != 5001):  # 연결되어 있다면
            fw.append(i)  # 방문 예정에 추가

    while (len(fw)):
        nod = fw.popleft()

        distance = nods[people][nod]  # 기준점과의 거리

        for i in range(peopleNumber):
            if (nods[nod][i] + distance < nods[people][i]):
                nods[people][i] = nods[nod][i] + distance

                fw.append(i)

answer = 1
sumKevinBacon = sys.maxsize
for index, nod in enumerate(nods):
    if (sum(nod) < sumKevinBacon):
        answer = index + 1

        sumKevinBacon = sum(nod)

print(answer)
