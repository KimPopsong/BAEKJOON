eratosthenes = []

for i in range(0, 10001):
    eratosthenes.append(int(i))

eratosthenes[1] = 0

i = 1
while True:
    i += 1

    if i == 10001:
        break

    n = eratosthenes[i]

    if n == 0:
        continue

    for k in range(i + 1, 10001):
        if eratosthenes[k] == 0:
            continue

        elif eratosthenes[k] % n == 0:
            eratosthenes[k] = 0

testcase = int(input())

numbers = []

for i in range(testcase):
    numbers.append(int(input()))

for num in numbers:
    nod = num // 2

    while True:
        if eratosthenes[nod]:
            if eratosthenes[num - nod]:
                print(nod, num - nod)
                break

            else:
                nod -= 1
                continue

        else:
            nod -= 1

            if nod == 1:
                break
