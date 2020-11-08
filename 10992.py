n = int(input())

if n == 1:
    print('*', end='')

else:
    array = [[' '] * (2 * n - 1) for i in range(n)]

    for i in range(0, 2 * n - 1):
        array[n - 1][i] = '*'

    mid = n - 1

    for i in range(0, n - 1):
        array[i][mid - i] = '*'
        array[i][mid + i] = '*'

    for i in range(0, n):
        for j in range(0, n + i):
            print(array[i][j], end='')

        if i != n - 1:
            print()
