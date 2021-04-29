have, found, need = map(int, input().split())

have += found
sumDrink = 0

while True:
    if have < need:
        break

    sumDrink += have // need

    have = have // need + have % need

print(sumDrink)
