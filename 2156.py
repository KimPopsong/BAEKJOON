import sys

wineNumber = int(sys.stdin.readline().rstrip())

wine = []
dp = []

for _ in range(wineNumber):
    wine.append(int(sys.stdin.readline().rstrip()))

if (wineNumber <= 2):  # 와인의 개수가 2개보다 적으면 다 마시면 됨
    print(sum(wine))

    exit()

dp.append(wine[0])
dp.append(wine[0] + wine[1])
dp.append(max(max(dp[0] + wine[2], wine[1] + wine[2]), dp[1]))

for i in range(3, wineNumber):
    dp.append(max(max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]), dp[i - 1]))

print(max(dp))
