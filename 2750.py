n = int(input())

number = []

for i in range(0, n):
    k = int(input())
    number.append(k)

number.sort()

for i in range(0, n):
    print(number[i])
