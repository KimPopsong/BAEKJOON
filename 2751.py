n = int(input())

number = []

for i in range(0, n):
    number.append(int(input()))

for i in sorted(number):
    print(i)
