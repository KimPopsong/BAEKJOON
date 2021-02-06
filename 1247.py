import sys

for i in range(3):
    n = int(sys.stdin.readline().rstrip())

    sumNum = 0

    for j in range(n):
        sumNum += int(sys.stdin.readline().rstrip())

    if sumNum == 0:
        print(0)

    elif sumNum > 0:
        print('+')

    else:
        print('-')
