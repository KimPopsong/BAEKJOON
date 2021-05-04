import math

n = int(input())

nod = math.ceil(math.sqrt(n))

while True:
    if nod * nod >= n:
        print(nod)
        break

    else:
        nod += 1
