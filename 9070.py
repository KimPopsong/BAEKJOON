for _ in range(int(input())):
    weightPerPrice = 0
    bestPrice = 1000001

    for __ in range(int(input())):
        weight, price = map(float, input().split())

        if weightPerPrice < weight / price:
            weightPerPrice = weight / price
            bestPrice = price

        elif weightPerPrice == weight / price:
            if price < bestPrice:
                bestPrice = price

    print(int(bestPrice))
