best = 0
bestCook = 0

for i in range(5):
    t = list(map(int, input().split()))

    if sum(t) > best:
        best = sum(t)
        bestCook = i + 1

print(bestCook, best)
