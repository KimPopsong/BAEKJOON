eratosthenes = []

for i in range(0, 1001):
    eratosthenes.append(int(i))

eratosthenes[1] = 0

i = 1
while True:
    i += 1

    if i == 1001:
        break

    n = eratosthenes[i]

    if n == 0:
        continue

    for k in range(i + 1, 1001):
        if eratosthenes[k] == 0:
            continue

        elif eratosthenes[k] % n == 0:
            eratosthenes[k] = 0

n = int(input())

numbers = input().split()
numbers = [int(i) for i in numbers]

count = 0

for i in range(n):
    try:
        if eratosthenes.index(numbers[i]):
            count += 1

    except ValueError:
        continue

print(count)
