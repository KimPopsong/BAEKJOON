import math

eratosthenes = []
maximum = 10000000

for i in range(0, maximum + 1):
    if i % 2 == 0:
        eratosthenes.append(False)

    else:
        eratosthenes.append(True)

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

origin, add = input().split()

changed = add + origin

if eratosthenes[int(origin)] and eratosthenes[int(changed)]:
    print('Yes')

else:
    print('No')
