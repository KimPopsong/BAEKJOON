import sys
from collections import deque

strings = deque(sys.stdin.readline().rstrip())
bomb = list(sys.stdin.readline().rstrip())

bombLength = len(bomb)

stack = []
node = 0
while strings:
    stack.append(strings.popleft())

    if (stack[len(stack) - bombLength:len(stack)] == bomb):
        for i in range(bombLength):
            stack.pop()

if (len(stack) == 0):
    print("FRULA")

else:
    for s in stack:
        print(s, end="")
