import sys
sys.setrecursionlimit(10 ** 4)

def Remove(field, x, y):
    field[x][y] = 0

    if x != 0:
        if field[x - 1][y] == 1:
            Remove(field, x - 1, y)

    if y != 0:
        if field[x][y - 1] == 1:
            Remove(field, x, y - 1)

    if x != len(field) - 1:
        if field[x + 1][y] == 1:
            Remove(field, x + 1, y)

    if y != len(field[x]) - 1:
        if field[x][y + 1] == 1:
            Remove(field, x, y + 1)

testcase = int(input())

cabageField = []
answer = []

for i in range(testcase):
    temp = input().split()
    t = [[0 for j in range(int(temp[0]))] for k in range(int(temp[1]))]

    for j in range(int(temp[2])):
        location = input().split()
        t[int(location[1])][int(location[0])] = 1

    cabageField.append(t)

for field in cabageField:
    count = 0

    for i in range(len(field)):
        for j in range(len(field[i])):
            if field[i][j] == 1:
                Remove(field, i, j)
                count += 1

            else:
                continue

    answer.append(count)

for ans in answer:
    print(ans)
