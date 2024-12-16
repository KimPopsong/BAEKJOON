import sys, copy
from collections import deque

strings = deque(sys.stdin.readline().rstrip())
minMove = sys.maxsize

length = len(strings)
aNumber = 0
for s in strings:
    if (s == 'a'):
        aNumber += 1

for _ in range(length):
    move = 0

    for i in range(aNumber):
        if (strings[i] == 'b'):
            move += 1

    strings.append(strings.popleft())

    minMove = min(minMove, move)

print(minMove)
