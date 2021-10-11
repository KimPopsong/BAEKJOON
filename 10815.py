import sys

cardNumber = int(sys.stdin.readline().rstrip())

cards = list(map(int, sys.stdin.readline().rsplit()))

findCardNumber = int(sys.stdin.readline().rstrip())

findCards = list(map(int, sys.stdin.readline().rsplit()))

cards.sort()

for f in findCards:
    flag = False

    leftNode = 0
    rightNode = cardNumber - 1

    while leftNode <= rightNode:
        mid = (leftNode + rightNode) // 2

        c = cards[mid]

        if c == f:
            flag = True
            break

        elif c > f:
            rightNode = mid - 1

        else:
            leftNode = mid + 1

    if flag:
        print('1 ', end = '')

    else:
        print('0 ', end = '')
print()
