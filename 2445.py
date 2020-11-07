n = int(input())

for i in range(0, n - 1):
    for star in range(0, i + 1):
        print('*', end='')

    for blank in range(0, 2 * (n - i) - 2):
        print(' ', end='')

    for star in range(0, i + 1):
        print('*', end='')

    print()

for star in range(0, n * 2):
    print('*', end='')

for i in range(0, n - 1):
    print()
    for star in range(1, n - i):
        print('*', end='')

    for blank in range(0, (i + 1) * 2):
        print(' ', end='')

    for star in range(1, n - i):
        print('*', end='')
