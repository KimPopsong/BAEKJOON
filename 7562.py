import sys
from collections import deque

testCase = int(sys.stdin.readline().rstrip())

for case in range(testCase):
    size = int(sys.stdin.readline().rstrip())

    startR, startC = map(int, sys.stdin.readline().split())
    endR, endC = map(int, sys.stdin.readline().split())

    bfs = deque()
    isVisit = [[sys.maxsize for i in range(size)] for i in range(size)]

    bfs.append([startR, startC])
    isVisit[startR][startC] = 0

    while (bfs):
        r, c = bfs.popleft()

        time = isVisit[r][c]

        dr = [-2, -1, 1, 2, 2, 1, -1, -2]  # 1시 방향부터 시계방향 순
        dc = [1, 2, 2, 1, -1, -2, -2, -1]

        for d in range(8):
            rr = r + dr[d]
            cc = c + dc[d]

            if (0 <= rr < size and 0 <= cc < size):  # 체스판 안에 있고
                if (isVisit[rr][cc] == sys.maxsize):  # 방문하지 않았다면
                    bfs.append([rr, cc])
                    isVisit[rr][cc] = time + 1

    print(isVisit[endR][endC])
