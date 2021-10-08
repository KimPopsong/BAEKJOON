import sys
input = sys.stdin.readline

giftList = []

friendNumber, maxDiff = map(int, input().split())

for _ in range(friendNumber):
    giftList.append(list(map(int, input().split())))
giftList.sort()

maxHappiness = giftList[0][1]
sumHappiness = giftList[0][1]

leftNode = 0
for rightNode in range(1, friendNumber):
    sumHappiness += giftList[rightNode][1]

    while True:
        if giftList[rightNode][0] - giftList[leftNode][0] >= maxDiff:
            sumHappiness -= giftList[leftNode][1]
            leftNode += 1

        else:
            break

    maxHappiness = max(maxHappiness, sumHappiness)

print(maxHappiness)
