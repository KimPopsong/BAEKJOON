import sys, heapq

cardNeed = int(sys.stdin.readline().rstrip())

cards = [0] + list(map(int, sys.stdin.readline().rsplit()))  # 카드i의 가격

for i in range(1, len(cards)):
    for j in range(i):
        cards[i] = max(cards[i], cards[j] + cards[i - j])

print(cards[-1])
