import sys

testCase = int(sys.stdin.readline().rstrip())

for case in range(testCase):
    stampCol = int(sys.stdin.readline().rstrip())

    stamps = []

    for i in range(2):
        stamps.append(list(map(int, sys.stdin.readline().rsplit())))

    dp = [[0 for i in range(stampCol)] for i in range(2)]

    dp[0][0] = stamps[0][0]
    dp[1][0] = stamps[1][0]

    if (stampCol > 1):  # 2행 2열까지 계산
        dp[0][1] = stamps[0][1] + stamps[1][0]
        dp[1][1] = stamps[1][1] + stamps[0][0]

    for i in range(2, stampCol):
        dp[0][i] = stamps[0][i] + max(dp[1][i - 1], dp[1][i - 2])
        dp[1][i] = stamps[1][i] + max(dp[0][i - 1], dp[0][i - 2])

    print(max(max(dp[0]), max(dp[1])))
