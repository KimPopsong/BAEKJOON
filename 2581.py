eratosthenes = []

for i in range(0, 10001):
    eratosthenes.append(int(i))

minimum = int(input())
maximum = int(input())

sum = 0  # sum prime numbers
minPrime = -1  # lowest prime number

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

for i in range(maximum, minimum - 1, -1):
    temp = eratosthenes[i]

    if temp != 0:
        sum += temp
        minPrime = temp

    else:
        continue

if sum:
    print(sum)
print(minPrime)
