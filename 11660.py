import sys

size, testCase = map(int, sys.stdin.readline().rsplit())

table = [[0] for i in range(size)]  # 누적 합 계산을 편하게 하기위해 앞에 0 추가

for r in range(size):
    table[r] += list(map(int, sys.stdin.readline().rsplit()))

for r in range(size):  # 누적 합 계산
    for c in range(1, size + 1):
        table[r][c] += table[r][c - 1]

for case in range(testCase):
    startR, startC, endR, endC = map(int, sys.stdin.readline().rsplit())

    startR -= 1
    endR -= 1

    sumNum = 0

    for r in range(startR, endR + 1):
        sumNum += (table[r][endC] - table[r][startC - 1])

    print(sumNum)
