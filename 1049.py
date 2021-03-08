needString, stringBrand = map(int, input().split())

cheapestPack = 1001
cheapestPiece = 1001

money = 0

for i in range(stringBrand):
    temp = list(map(int, input().split()))

    if cheapestPack > temp[0]:
        cheapestPack = temp[0]

    if cheapestPiece > temp[1]:
        cheapestPiece = temp[1]

while needString > 0:
    if needString >= 6:
        if cheapestPack < cheapestPiece * 6:
            money += cheapestPack
            needString -= 6

        else:
            money += cheapestPiece * 6
            needString -= 6

    else:
        if cheapestPack < cheapestPiece * needString:
            money += cheapestPack
            needString -= 6

        else:
            money += cheapestPiece * needString
            needString = 0

print(money)
