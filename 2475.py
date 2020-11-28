numbers = list(map(int, input().split()))

sum = 0

for n in numbers:
    sum += n * n

print(sum % 10)
