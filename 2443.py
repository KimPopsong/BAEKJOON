n = int(input())

for i in range(n):
    for blank in range(0, i):
        print(' ', end='')

    for star in range(2 * n - (i * 2 + 1), 0, -1):
        print('*', end='')

    print()
