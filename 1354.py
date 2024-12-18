import sys

global p, q, x, y, dp


def recursion(n):
    global dp

    if (n in dp.keys()):
        return dp[n]

    else:
        npx = n // p - x
        nqy = n // q - y

        if (npx < 0):
            npx = 0

        if (nqy < 0):
            nqy = 0

        if (npx not in dp.keys()):
            recursion(npx)

        if (nqy not in dp.keys()):
            recursion(nqy)

        dp[n] = dp[npx] + dp[nqy]

    return dp[n]


n, p, q, x, y = map(int, sys.stdin.readline().rsplit())
dp = dict()
dp[0] = 1

print(recursion(n))
