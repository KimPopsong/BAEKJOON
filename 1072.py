import math

gameNumber, winGame = map(int, input().split())

winRate = math.floor(winGame * 100 / gameNumber)

haveToPlay = 0

leftNode = 0
rightNode = gameNumber + 1000000000
mid = 0

if winRate >= 99:  # 99% 이상으로 승률을 높일 수 없음
    print(-1)
    exit()

while leftNode <= rightNode:
    mid = (leftNode + rightNode) // 2

    if math.floor((winGame + mid) * 100 / (gameNumber + mid)) > winRate:
        rightNode = mid - 1

    else:
        leftNode = mid + 1

if math.floor((winGame + mid) * 100 / (gameNumber + mid)) > winRate:
    print(mid)

else:
    print(mid + 1)
