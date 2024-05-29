import sys

cards = dict()

number = int(sys.stdin.readline().strip())

most = 0
mostNumber = 0

for i in range(number):
    card = int(sys.stdin.readline().strip())

    if card in cards:
        cards[card] += 1

    else:
        cards[card] = 1

cards = dict(sorted(cards.items()))

for card in cards.keys():
    if cards[card] > most:
        most = cards[card]
        mostNumber = card

print(mostNumber)
