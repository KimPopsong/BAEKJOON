import sys

bottleNum, people = map(int, sys.stdin.readline().rsplit())

alcohol = []

for i in range(bottleNum):
    alcohol.append(int(sys.stdin.readline().rstrip()))

leftNod = 1
rightNod = max(alcohol)
answer = 0

while leftNod <= rightNod:
    midNod = (leftNod + rightNod) // 2

    bottleSum = 0

    for i in range(bottleNum):
        bottleSum += alcohol[i] // midNod

    if bottleSum >= people:
        if midNod > answer:
            answer = midNod

        leftNod = midNod + 1

    else:
        rightNod = midNod - 1

print(answer)
