import math

eratosthenes = []
maximum = 104729
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

count = 0
nod = 1

while True:
    if eratosthenes[nod]:
        count += 1

    if count == n:
        print(nod)
        break

    else:
        nod += 1
