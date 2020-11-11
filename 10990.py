n = int(input())

if n == 1:
    print('*', end='')

else:
    array = [[' '] * (2 * n - 1) for i in range(n)]

    mid = n - 1

    for i in range(0, n):
        array[i][mid - i] = '*'
        array[i][mid + i] = '*'

    for i in range(0, n):
        for j in range(0, n + i):
            print(array[i][j], end='')

        if i != n - 1:
            print()
