def swapCard(start, end):
    global cards

    temp = cards[start:end + 1:]
    temp.reverse()

    for i in range(start, end + 1):
        cards[i] = temp[i - start]

cards = [i for i in range(1, 21)]

for i in range(10):
    start, end = map(int, input().split())

    swapCard(start - 1, end - 1)

for c in cards:
    print(c, end = ' ')
