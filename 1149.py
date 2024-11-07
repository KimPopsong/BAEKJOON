import sys

houseNumber = int(sys.stdin.readline().rstrip())  # 집의 개수 입력

house = []

for _ in range(houseNumber):  # RGB 가격 입력
    temp = list(map(int, sys.stdin.readline().rsplit()))

    house.append(temp)

dp = [house[0]]

for i in range(1, houseNumber):
    tempDp = []

    tempDp.append(house[i][0] + min(dp[i - 1][1], dp[i - 1][2]))
    tempDp.append(house[i][1] + min(dp[i - 1][0], dp[i - 1][2]))
    tempDp.append(house[i][2] + min(dp[i - 1][0], dp[i - 1][1]))

    dp.append(tempDp)

print(min(dp[-1]))
