def PrintStarFirst():
    for _ in range(n - 1):
        print('* ', end = '')
    print('*')

def PrintBlankFirst():
    for _ in range(n):
        print(' *', end = '')
    print()

n = int(input())

for row in range(n):
    if row % 2 == 0:
        PrintStarFirst()

    else:
        PrintBlankFirst()
