n = int(input())

a = 1
b = 0

for i in range(n):
    tempB = b

    b += a
    a = tempB

print(a, b)
