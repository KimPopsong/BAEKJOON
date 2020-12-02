import math

n = int(input())

number = [0 for i in range(n + 1)]
number[1] = 1

count = 0

for i in range(2, n + 1):
    number[i] = i

    for j in range(int(math.sqrt(i)) + 1):
        number[i] = min(number[i], number[i - j * j] + 1)

print(number[n])
