import sys

n = int(sys.stdin.readline())
num = [0] * 10001

for i in range(n):
    num[int(sys.stdin.readline())] += 1

for i in range(len(num)):
    if num[i] != 0:
        for j in range(num[i]):
            sys.stdout.write(str(i) + '\n')
