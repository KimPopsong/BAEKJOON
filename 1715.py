import sys

n = int(sys.stdin.readline())
card = []
count = 0

for i in range(0, n):
    card.append(int(sys.stdin.readline()))

card.sort()

for i in range(0, n - 1):
    card[i + 1] = card[i] + card[i + 1]
    count += card[i + 1]

    for j in range(i + 1, n - 1):
        if card[j] > card[j + 1]:
            card[j], card[j + 1] = card[j + 1], card[j]

        else:
            break

print(count)
