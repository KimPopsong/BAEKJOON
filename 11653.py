import math

eratosthenes = []
maximum = int(math.sqrt(10000000)) + 1
for i in range(0, maximum + 1):
    eratosthenes.append(True)

    if i % 2 == 0:
        eratosthenes[i] = False

eratosthenes[0] = False
eratosthenes[1] = False
eratosthenes[2] = True

i = 1
while True:
    i += 1

    if i % 2 == 0:
        continue

    if i > math.sqrt(maximum) + 1:
        break

    k = 2
    while i * k <= maximum:
        eratosthenes[k * i] = False
        k += 1

n = int(input())

originNum = n

node = 2
while math.sqrt(originNum) >= node:
    if n % node == 0:
        n //= node
        print(node)

    else:
        while True:
            node += 1

            if eratosthenes[node] or node >= len(eratosthenes):
                break

if n != 1:
    print(n)
