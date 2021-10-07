def Paint(gap, f):
    global block, n

    for r in range(gap, 4 * n - 3 - gap):
        for c in range(gap, 4 * n - 3 - gap):
            block[r][c] = f

n = int(input())

block = [[False] * (4 * n - 3) for i in range(4 * n - 3)]

flag = True

for i in range(2 * n - 1):
    Paint(i, flag)

    flag = not flag

for row in range(0, 4 * n - 3):
    for col in range(0, 4 * n - 3):
        if block[row][col]:
            print('*', end = '')

        else:
            print(' ', end = '')
    print()
