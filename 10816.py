import sys

cardHaveNum = int(sys.stdin.readline())

card = list(map(int, sys.stdin.readline().rsplit()))
cardPlus = [0] * 10000001
cardMinus = [0] * 10000001

for c in card:
    if c < 0:
        t = -1 * c
        cardMinus[t] += 1

    else:
        cardPlus[c] += 1

cardIsHaveNum = int(sys.stdin.readline())

cardIsHave = list(map(int, sys.stdin.readline().rsplit()))

for c in cardIsHave:
    if c < 0:
        t = -1 * c
        print(cardMinus[t], end = ' ')

    else:
        print(cardPlus[c], end = ' ')
