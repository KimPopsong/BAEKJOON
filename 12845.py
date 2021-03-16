n = int(input())

cards = list(map(int, input().split()))

maxLevel = max(cards)

print(sum(cards) + (n - 2) * maxLevel)
