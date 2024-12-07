import sys
from collections import deque

start, end = map(int, sys.stdin.readline().rsplit())

bfs = deque()
isVisit = dict()  # 메모리 초과로 dict 사용

bfs.append(start)
isVisit[start] = 1

while (bfs):
    number = bfs.popleft()

    op1 = number * 2  # 2를 곱
    op2 = number * 10 + 1  # 1을 수의 가장 오른쪽에 추가

    if (op1 <= end):  # 범위 안에 있고
        if (op1 not in isVisit.keys()):  # 방문하지 않았다면
            bfs.append(op1)
            isVisit[op1] = isVisit[number] + 1

    if (op2 <= end):
        if (op2 not in isVisit.keys()):
            bfs.append(op2)
            isVisit[op2] = isVisit[number] + 1

if (end not in isVisit.keys()):
    print(-1)

else:
    print(isVisit[end])
