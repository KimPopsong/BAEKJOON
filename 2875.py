s = list(map(int, input().split()))

n = s[0]
m = s[1]
k = s[2]

team = 0

while True:
    if n - 2 < 0 or m - 1 < 0:
        break

    else:
        n -= 2
        m -= 1
        team += 1

left = n + m

k -= left

while True:
    if k <= 0:
        break

    else:
        team -= 1
        k -= 3

print(team)
