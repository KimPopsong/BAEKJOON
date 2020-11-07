n = int(input())

for upper in range(0, n - 1):
    for blank in range(0, n - upper - 1):
        print(' ', end='')

    for star in range(0, upper + 1):
        print('*', end='')

    print()

for midStar in range(0, n):
    print('*', end='')

for lower in range(0, n - 1):
    print()
    for blank in range(0, lower + 1):
        print(' ', end='')

    for star in range(0, n - lower - 1):
        print('*', end='')
