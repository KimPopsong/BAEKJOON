n = int(input())

strN = ''

while n > 0:
    strN += str(n % 2)

    n //= 2

nod = 1
reversedN = 0

for i in range(len(strN) - 1, -1, -1):
    reversedN += nod * int(strN[i])
    nod *= 2

print(reversedN)
