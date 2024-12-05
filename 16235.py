import sys, copy
from collections import deque

landSize, treeNumber, endYear = map(int, sys.stdin.readline().rsplit())  # 땅의 크기, 나무의 개수, 종료되는 시점

land = [[5 for i in range(landSize)] for i in range(landSize)]  # 땅에 남아있는 비료
fertil = []  # 겨울에 주는 비료의 양
trees = [[deque() for i in range(landSize)] for i in range(landSize)]  # 나무의 정보를 담을 2차원 배열

for _ in range(landSize):
    fertil.append(list(map(int, sys.stdin.readline().rsplit())))

for _ in range(treeNumber):
    x, y, age = map(int, sys.stdin.readline().rsplit())

    trees[x - 1][y - 1].append(age)

while (endYear > 0):
    # 봄
    deadTrees = list()  # 죽은 나무

    for r in range(landSize):
        for c in range(landSize):
            for i in range(len(trees[r][c])):
                age = trees[r][c].popleft()

                if (land[r][c] >= age):  # 충분한 양의 비료가 있다면
                    land[r][c] -= age  # 나무의 나이만큼 비료를 소모하고
                    age += 1  # 나이 증가
                    trees[r][c].append(age)

                else:  # 비료가 부족하다면
                    deadTrees.append([r, c, age])  # 죽은 나무 목록에 추가

    # 여름
    for deadTree in deadTrees:  # 죽은 나무의 나이 % 2를 양분으로 추가. 내림 처리.
        r = deadTree[0]
        c = deadTree[1]
        age = deadTree[2]

        land[r][c] += (age // 2)

    # 가을
    for r in range(landSize):
        for c in range(landSize):
            for i in range(len(trees[r][c])):  # 나무의 나이가 5의 배수일 때 번식, 인접 8개 칸에 나이가 1인 나무 생성
                age = trees[r][c][i]

                if (age % 5 != 0):  # 5의 배수가 아닐시 생략
                    continue

                dr = [-1, -1, 0, 1, 1, 1, 0, -1]  # 위부터 시계방향
                dc = [0, 1, 1, 1, 0, -1, -1, -1]

                for i in range(8):
                    if (0 <= r + dr[i] < landSize and 0 <= c + dc[i] < landSize):  # 범위 안에 있으면
                        trees[r + dr[i]][c + dc[i]].appendleft(1)  # 나이가 1인 나무 추가. 나무의 나이는 항상 가장 어리므로, 왼쪽에 추가

    # 겨울
    for r in range(landSize):  # 땅에 양분 추가
        for c in range(landSize):
            land[r][c] += fertil[r][c]

    endYear -= 1

count = 0

for r in range(landSize):
    for c in range(landSize):
        count += len(trees[r][c])

print(count)
