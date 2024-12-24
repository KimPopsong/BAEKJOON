import sys

day = int(sys.stdin.readline().rstrip())

counsel = []  # [상담일, 가격]
dp = [0 for i in range(day + 1)]

for i in range(day):
    counsel.append(list(map(int, sys.stdin.readline().rsplit())))

for i in range(day - 1, -1, -1):
    daySpend, price = counsel[i]

    if (i + daySpend > day):
        dp[i] = 0

    else:
        dp[i] = price + max(dp[i + daySpend:])

print(max(dp))
