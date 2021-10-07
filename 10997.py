def SelectDirection(n):
    n += 1

    if n >= 4:
        n = 0

    return n

n = int(input())

if n == 1:
    print('*')
    exit()

direction = [[-1, 0], [0, -1], [1, 0], [0, 1]]

block = [[False] * (4 * n - 3) for i in range(4 * n - 1)]

count = 1
nod = 0

for i in range(4 * n - 3):  # Paint Edge
    block[0][i] = True
    block[4 * n - 2][i] = True

for i in range(4 * n - 2):
    block[i][0] = True

row = 4 * n - 2
col = 4 * n - 4
while count <= 4 * n - 5:
    while True:
        row += direction[nod][0]
        col += direction[nod][1]
        block[row][col] = True

        if block[row + 2 * direction[nod][0]][col + 2 * direction[nod][1]]:
            break

    nod = SelectDirection(nod)
    count += 1

for r in range(4 * n - 1):
    if r == 1:
        print('*')
        continue

    for c in range(4 * n - 3):
        if block[r][c]:
            print('*', end = '')

        else:
            print(' ', end = '')
    print()
