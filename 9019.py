import sys
from collections import deque

testCase = int(sys.stdin.readline().rstrip())

for case in range(testCase):
    startNumber, endNumber = map(int, sys.stdin.readline().rsplit())

    bfs = deque()
    isVisit = ["" for i in range(10000)]

    bfs.append(startNumber)

    while (bfs):
        number = bfs.popleft()
        commmand = isVisit[number]

        # D -> 두 배로 변환
        D = number * 2

        if (D >= 10000):
            D %= 10000

        if (isVisit[D] == ""):  # 방문하지 않았다면
            isVisit[D] = commmand + "D"
            bfs.append(D)

        # S -> 1빼기
        S = number - 1

        if (S < 0):
            S = 9999

        if (isVisit[S] == ""):  # 방문하지 않았다면
            isVisit[S] = commmand + "S"
            bfs.append(S)

        # L -> 자리수를 왼편으로 회전
        L = number * 10 + number // 1000

        if (L >= 10000):  # 최적화를 위해 계산 따로
            L %= 10000

        if (isVisit[L] == ""):  # 방문하지 않았다면
            isVisit[L] = commmand + "L"
            bfs.append(L)

        # R -> 자리수를 오른편으로 회전
        R = number // 10 + (number % 10) * 1000

        if (isVisit[R] == ""):  # 방문하지 않았다면
            isVisit[R] = commmand + "R"
            bfs.append(R)

    print(isVisit[endNumber])
