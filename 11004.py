import sys

numberCount, order = map(int, sys.stdin.readline().rsplit())

number = list(map(int, sys.stdin.readline().rsplit()))

number.sort()

print(number[order - 1])
