s = input().split()
n = int(s[0])
m = int(s[1])

cards = input().split()
cards = [int(i) for i in cards]

diff = 0

for i in range(n):
    for j in range(i + 1, n):
        for k in range(j + 1, n):
            temp = cards[i] + cards[j] + cards[k]

            if m >= temp > diff:
                diff = temp

print(diff)
