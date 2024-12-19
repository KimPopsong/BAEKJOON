import sys, copy
from itertools import combinations
from collections import deque

global labSize, virusNumber, lab, virusPlace


def check(labCopy):  # 최소 시간일시 빈 방이 있는지 확인
    for r in range(labSize):
        for c in range(labSize):
            if (labCopy[r][c] == 0):
                return False

    return True


def virusSpread(viruses):
    global minTime

    bfs = deque(viruses)
    labCopy = copy.deepcopy(lab)

    for r in range(labSize):
        for c in range(labSize):
            if (labCopy[r][c] == 2):
                labCopy[r][c] = 0

    for virus in viruses:
        labCopy[virus[0]][virus[1]] = 2

    dr = [-1, 1, 0, 0]  # 상하좌우 순 탐색
    dc = [0, 0, -1, 1]

    time = -1
    while (bfs):
        time += 1

        tempBfs = deque(bfs)
        bfs.clear()

        while (tempBfs):
            r, c = tempBfs.popleft()

            for i in range(4):
                rr = r + dr[i]
                cc = c + dc[i]

                if (0 <= rr < labSize and 0 <= cc < labSize):  # 범위 안에 있고
                    if (labCopy[rr][cc] == 0):  # 빈 공간이고
                        labCopy[rr][cc] = 2  # 바이러스
                        bfs.append([rr, cc])

    if (time < minTime):  # 시간이 더 적을시
        if (check(labCopy)):  # 모든 칸에 바이러스가 퍼진다면
            minTime = time

    return


labSize, virusNumber = map(int, sys.stdin.readline().rsplit())  # 연구실의 사이즈, 바이러스의 개수

lab = []  # 연구실
virusPlace = []  # 바이러스를 놓을 수 있는 장소
minTime = sys.maxsize

for i in range(labSize):
    lab.append(list(map(int, sys.stdin.readline().rsplit())))

for r in range(labSize):  # 바이러스를 놓을 수 있는 장소 저장
    for c in range(labSize):
        if (lab[r][c] == 2):
            virusPlace.append([r, c])

for comb in combinations(virusPlace, virusNumber):
    virusSpread(comb)

if (minTime == sys.maxsize):  # 모든 방에 바이러스를 퍼뜨릴 수 없다면
    minTime = -1

print(minTime)
# TODO 시간이 0일 경우 확인
