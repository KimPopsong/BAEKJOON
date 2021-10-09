import sys

balloonNumber = int(sys.stdin.readline().rstrip())

balloon = list(map(int, sys.stdin.readline().rsplit()))

arrowNumber = 0

while True:
    height = max(balloon)

    if height == 0:
        break

    for i in range(0, balloonNumber):
        if balloon[i] == height:
            balloon[i] = 0
            height -= 1

    arrowNumber += 1

print(arrowNumber)
