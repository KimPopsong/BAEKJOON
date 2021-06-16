import sys

cardNumber = int(sys.stdin.readline().rstrip())

card = list(map(int, sys.stdin.readline().rsplit()))

card.sort()

print(sum(card) - card[-1])
