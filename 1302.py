import sys

sells = dict()
bestSellerName = ""
bestSell = 0

number = int(sys.stdin.readline().strip())

for i in range(number):
    book = sys.stdin.readline().strip()

    if book in sells:
        sells[book] += 1

    else:
        sells[book] = 1

sells = dict(sorted(sells.items()))

for book in sells.keys():
    if sells[book] > bestSell:
        bestSellerName = book
        bestSell = sells[book]

print(bestSellerName)
