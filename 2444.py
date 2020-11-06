n = int(input())

for i in range(1, n):
    for blank in range(i, n):
        print(' ', end='')

    for star in range(0, i * 2 - 1):
        print('*', end='')

    print()

for i in range(0, 2 * n - 1):
    print('*', end='')

for i in range(0, n):
    print()
    for blank in range(0, i + 1):
        print(' ', end='')

    for star in range(i, 2 * (n - 1) - i - 1):
        print('*', end='')
