import sys

n = int(sys.stdin.readline().rstrip())

numbers = []

for i in range(n):
    numbers.append(int(sys.stdin.readline().rstrip()))

numbers.sort(reverse = True)

for num in numbers:
    print(num)
