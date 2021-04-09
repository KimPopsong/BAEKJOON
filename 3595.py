n = int(input())

minimum = 10000000

slideA = 0
slideB = 0
slideC = 0

nod1 = 0
while True:
    nod1 += 1
    nod2 = 0

    while True:
        nod2 += 1
        nod3 = n // nod1 // nod2

        if nod2 > nod3:
            break

        if nod1 * nod2 * nod3 != n:
            continue

        temp = (nod1 * nod2 + nod1 * nod3 + nod2 * nod3) * 2

        if minimum > temp:
            minimum = temp

            slideA = nod1
            slideB = nod2
            slideC = nod3

    if nod1 >= n:
        break

print(slideA, slideB, slideC)
