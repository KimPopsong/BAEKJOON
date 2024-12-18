import sys, copy

"""
1 ~ 5 : 감시카메라
6 : 벽
1 : 직선
2 : 앞뒤 또는 좌우 평행
3 : 수직
4 : 한 면 제외
5 : 4방향 전부
감시카메라는 벽 통과 불가. 카메라는 카메라 통과 가능
"""

global rowSize, colSize, cctv, cctvCount


def calcBlindSpot(isVisit):
    global blindSpot

    blind = 0

    for r in range(rowSize):
        for c in range(colSize):
            if (isVisit[r][c] == 0):
                blind += 1

    blindSpot = min(blindSpot, blind)


def recursion(depth, isVisit):
    if (depth == cctvCount):
        calcBlindSpot(isVisit)

        return

    r, c = cctv[depth]
    type = room[r][c]

    if (type == 1):
        dr = [-1, 0, 1, 0]  # 상우하좌 순
        dc = [0, 1, 0, -1]

        for i in range(4):
            copyVisit = copy.deepcopy(isVisit)

            rr = r + dr[i]
            cc = c + dc[i]

            while (0 <= rr < rowSize and 0 <= cc < colSize):
                if (room[rr][cc] == 6):  # 벽일경우
                    break

                else:
                    copyVisit[rr][cc] = -1  # 감시구역으로 만들기

                    rr += dr[i]
                    cc += dc[i]

            recursion(depth + 1, copyVisit)


    elif (type == 2):
        dr = [[0, 0], [-1, 1]]  # 좌우 상하 순
        dc = [[-1, 1], [0, 0]]

        for i in range(2):
            copyVisit = copy.deepcopy(isVisit)

            for j in range(2):
                rr = r + dr[i][j]
                cc = c + dc[i][j]

                while (0 <= rr < rowSize and 0 <= cc < colSize):
                    if (room[rr][cc] == 6):  # 벽일경우
                        break

                    else:
                        copyVisit[rr][cc] = -1  # 감시구역으로 만들기

                        rr += dr[i][j]
                        cc += dc[i][j]

            recursion(depth + 1, copyVisit)

    elif (type == 3):
        dr = [-1, 0, 1, 0, -1]
        dc = [0, 1, 0, -1, 0]

        for i in range(4):
            copyVisit = copy.deepcopy(isVisit)

            for j in range(i, i + 2):
                rr = r + dr[j]
                cc = c + dc[j]

                while (0 <= rr < rowSize and 0 <= cc < colSize):
                    if (room[rr][cc] == 6):  # 벽일경우
                        break

                    else:
                        copyVisit[rr][cc] = -1  # 감시구역으로 만들기

                        rr += dr[j]
                        cc += dc[j]

            recursion(depth + 1, copyVisit)

    elif (type == 4):
        dr = [-1, 0, 1, 0, -1, 0]
        dc = [0, 1, 0, -1, 0, 1]

        for i in range(4):
            copyVisit = copy.deepcopy(isVisit)

            for j in range(i, i + 3):
                rr = r + dr[j]
                cc = c + dc[j]

                while (0 <= rr < rowSize and 0 <= cc < colSize):
                    if (room[rr][cc] == 6):  # 벽일경우
                        break

                    else:
                        copyVisit[rr][cc] = -1  # 감시구역으로 만들기

                        rr += dr[j]
                        cc += dc[j]

            recursion(depth + 1, copyVisit)

    else:
        dr = [-1, 0, 1, 0]  # 상우하좌 순
        dc = [0, 1, 0, -1]

        copyVisit = copy.deepcopy(isVisit)

        for i in range(4):
            rr = r + dr[i]
            cc = c + dc[i]

            while (0 <= rr < rowSize and 0 <= cc < colSize):
                if (room[rr][cc] == 6):  # 벽일경우
                    break

                else:
                    copyVisit[rr][cc] = -1  # 감시구역으로 만들기

                    rr += dr[i]
                    cc += dc[i]

        recursion(depth + 1, copyVisit)


rowSize, colSize = map(int, sys.stdin.readline().rsplit())  # 행, 열
blindSpot = 0  # 사각지대
cctv = []  # cctv의 위치
cctvCount = 0  # cctv의 개수

room = []
for i in range(rowSize):
    room.append(list(map(int, sys.stdin.readline().rsplit())))

for r in range(rowSize):
    for c in range(colSize):
        if (room[r][c] == 0):
            blindSpot += 1

        elif (room[r][c] != 6):
            cctv.append([r, c])
cctvCount = len(cctv)

recursion(0, room)

print(blindSpot)
