n = int(input())

sumPrime = 0

for i in range(1, n + 1):
    sumPrime += (n // i) * i

print(sumPrime)
