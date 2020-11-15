import math

def CountPrime(n):
    count = 0

    for i in range(n + 1, 2 * n + 1):
        flag = 0

        for j in range(2, int(math.sqrt(i)) + 1):
            if i % j == 0:
                flag = 1
                break

        if flag:
            continue

        else:
            count += 1

    return count

numbers = []

while True:
    n = int(input())

    if n == 0:
        break

    numbers.append(n)

for num in numbers:
    print(CountPrime(num))
