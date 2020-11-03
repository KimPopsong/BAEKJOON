n = int(input())

for i in range(0, n):
    for j in range(n - i - 1): #print blank
        print(' ', end='')

    for k in range(i * 2 + 1): #print star
        print('*', end='')

    print()
