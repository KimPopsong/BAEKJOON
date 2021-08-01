import sys

basketNumber, times = map(int, sys.stdin.readline().rsplit())

basket = [0] * basketNumber

for _ in range(times):
    start, end, ballNumber = map(int, sys.stdin.readline().rsplit())

    for i in range(start - 1, end):
        basket[i] = ballNumber

for num in basket:
    print(num, end = ' ')
