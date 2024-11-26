import sys

sumNum = 0

number = int(sys.stdin.readline().rstrip())

for _ in range(number):
    sumNum += int(sys.stdin.readline().rstrip())

print(sumNum)
