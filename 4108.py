import sys

def Check(ii, jj, maxI, maxJ):
    count = 0

    for i in range(0, 3):
        nodI = ii - 1 + i

        for j in range(0, 3):
            nodJ = jj - 1 + j

            if nodI < 0 or nodJ < 0 or nodI >= maxI or nodJ >= maxJ:
                continue

            if gameMap[nodI][nodJ] == '*':
                count += 1

    return count

while True:
    r, c = map(int, sys.stdin.readline().rsplit())

    if r == 0 and c == 0:
        break

    gameMap = []

    for i in range(r):
        gameMap.append(sys.stdin.readline().rstrip())

    numberMap = []

    for i in range(r):
        temp = []

        for j in range(c):
            if gameMap[i][j] == '*':
                temp.append(gameMap[i][j])

            else:
                temp.append(Check(i, j, r, c))

        numberMap.append(temp)

    for num in numberMap:
        for n in num:
            print(n, end = '')

        print()
