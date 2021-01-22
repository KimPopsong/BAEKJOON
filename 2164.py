n = int(input())

cards = [i for i in range(1, n + 1)]

cards[0] = 0
count = 0
erase = 1
nod = 0

if n == 1:
    print(1)
    exit()

while erase != n - 1:
    if nod >= n:
        nod = 0

    if cards[nod] == 0:
        nod += 1

    else:
        count += 1

        if count != 2:
            nod += 1

        else:
            cards[nod] = 0
            count = 0
            erase += 1

for c in cards:
    if c != 0:
        print(c)
        exit()
