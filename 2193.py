import sys

leechinsoo = [0, 1]

n = int(sys.stdin.readline().rstrip())

for i in range(2, n + 1):
    leechinsoo.append(leechinsoo[i - 1] + leechinsoo[i - 2])

print(leechinsoo[n])
