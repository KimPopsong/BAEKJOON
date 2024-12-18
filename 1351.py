import sys

global p, q, dp


def recursion(n):
    global dp

    if (n in dp.keys()):
        return dp[n]

    else:
        if (n // p not in dp.keys()):
            np = recursion(n // p)

        if (n // q not in dp.keys()):
            nq = recursion(n // q)

        dp[n] = dp[n // p] + dp[n // q]

    return dp[n]


n, p, q = map(int, sys.stdin.readline().rsplit())
dp = dict()
dp[0] = 1

print(recursion(n))
