import sys

n = int(input())

numList = []
stack = [0]
answer = []

nod = 1
numListNod = 0
flag = 0

for i in range(n):
    t = list(map(int, sys.stdin.readline().rsplit()))
    numList.append(t[0])

for t in numList:
    while nod <= t:  # Push
        stack.append(nod)
        nod += 1
        answer.append('+')

    if t == stack[-1]:
        stack.pop()
        answer.append('-')
        numListNod += 1

    else:
        flag = 1

if flag:
    print('NO')

else:
    for ans in answer:
        print(ans)
