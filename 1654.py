import sys

have, need = map(int, sys.stdin.readline().split())
lan = []

for i in range(have):
    t = list(map(int, sys.stdin.readline().rsplit()))
    lan.append(t[0])

lan.sort()

maxLength = 0
low = 1
high = max(lan)

while low <= high:
    mid = (low + high) // 2

    count = sum([i // mid for i in lan])

    if count < need:
        high = mid - 1

    else:
        low = mid + 1
        maxLength = mid

print(maxLength)
