import sys

line = int(input())

mirror = []

for i in range(line):
    mirror.append(list(sys.stdin.readline().rstrip()))

mind = int(input())

if mind == 1:
    for i in range(line):
        for j in range(line):
            print(mirror[i][j], end = '')
        print()

elif mind == 2:
    for i in range(line):
        for j in range(line - 1, -1, -1):
            print(mirror[i][j], end = '')
        print()

else:
    for i in range(line - 1, -1, -1):
        for j in range(line):
            print(mirror[i][j], end = '')
        print()
