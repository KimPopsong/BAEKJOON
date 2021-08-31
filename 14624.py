n = int(input())

if n % 2:  # if odd
    for star in range(n):
        print('*', end = '')
    print()

    for line in range(n // 2 + 1):
        for blank in range(n // 2 - line):
            print(' ', end = '')

        print('*', end = '')

        if line == 0:
            print()

        for blank in range(2 * line - 1):
            print(' ', end = '')

        if line:
            print('*')

else:
    print('I LOVE CBNU')
