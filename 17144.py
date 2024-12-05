import sys, copy

rowSize, colSize, time = map(int, sys.stdin.readline().rsplit())  # 행, 열, 시간

room = []  # 방

purifierUR, purifierUC = 0, 0  # 공기청정기 윗부분의 좌표
purifierDR, purifierDC = 0, 0  # 공기청정기 아래부분의 좌표

for r in range(rowSize):
    room.append(list(map(int, sys.stdin.readline().rsplit())))

for r in range(rowSize):  # 공기청정기의 좌표 확인
    if (room[r][0] == -1):
        purifierUR = r
        purifierDR = r + 1
        break

for t in range(time):
    # 먼지의 확산 계산
    roomTemp = [[0 for i in range(colSize)] for i in range(rowSize)]  # 확산된 미세먼지 저장용

    dr = [-1, 1, 0, 0]  # 상하좌우 순
    dc = [0, 0, -1, 1]

    for r in range(rowSize):
        for c in range(colSize):
            dust = room[r][c]

            if (dust > 4):  # 4보다 큰 먼지라면 확산. 4보다 작으면 확산되지 않음.
                direct = 0

                spreadDust = dust // 5
                for i in range(4):  # 먼지의 확산 계산
                    rr = r + dr[i]
                    cc = c + dc[i]

                    if (0 <= rr < rowSize and 0 <= cc < colSize):  # 방 안에 있고
                        if (room[rr][cc] != -1):  # 공기청정기가 아니라면
                            direct += 1  # 확산한 방향 1 증가

                            roomTemp[rr][cc] += spreadDust

                roomTemp[r][c] += (dust - spreadDust * direct)  # 남은 먼지 저장

            elif (dust > 0):  # 확산되지 않는 먼지라면
                roomTemp[r][c] += dust

    room = copy.deepcopy(roomTemp)
    room[purifierUR][purifierUC] = -1
    room[purifierDR][purifierDC] = -1

    # 공기 순환
    # 공기청정기의 윗 부분부터 순환
    r = purifierUR - 1
    c = 0

    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]
    nod = 0
    while (True):
        rr = r + dr[nod]
        cc = c + dc[nod]

        if not (0 <= rr <= purifierUR and 0 <= cc < colSize):  # 범위를 벗어났다면
            nod += 1

            if (nod > 3):
                nod = 0

            rr = r + dr[nod]
            cc = c + dc[nod]

        if (room[rr][cc] == -1):  # 공기청정기라면
            room[r][c] = 0

            break

        room[r][c] = room[rr][cc]  # 한 칸씩 밀기
        r = rr
        c = cc

    # 공기청정기 아래 부분 순환
    r = purifierDR + 1
    c = 0

    dr = [1, 0, -1, 0]
    dc = [0, 1, 0, -1]
    nod = 0
    while (True):
        rr = r + dr[nod]
        cc = c + dc[nod]

        if not (purifierDR <= rr < rowSize and 0 <= cc < colSize):  # 범위를 벗어났다면
            nod += 1

            if (nod > 3):
                nod = 0

            rr = r + dr[nod]
            cc = c + dc[nod]

        if (room[rr][cc] == -1):  # 공기청정기라면
            room[r][c] = 0

            break

        room[r][c] = room[rr][cc]  # 한 칸씩 밀기
        r = rr
        c = cc

dustSum = 2

for r in range(rowSize):
    for c in range(colSize):
        dustSum += room[r][c]

print(dustSum)
