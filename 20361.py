import sys

n, x, k = map(int, sys.stdin.readline().rsplit())

for i in range(k):
    cup1, cup2 = map(int, sys.stdin.readline().rsplit())

    if cup1 == x:
        x = cup2

    elif cup2 == x:
        x = cup1

print(x)
