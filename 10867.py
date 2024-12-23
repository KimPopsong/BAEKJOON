import sys

number = int(sys.stdin.readline().rstrip())
numbers = set(map(int, sys.stdin.readline().rsplit()))

numbers = sorted(list(numbers))

for n in numbers:
    print(n, end=" ")
