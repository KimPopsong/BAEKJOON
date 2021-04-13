import sys, math

n = sys.stdin.readline().rstrip()
numbers1 = list(map(int, sys.stdin.readline().rsplit()))

m = sys.stdin.readline().rstrip()
numbers2 = list(map(int, sys.stdin.readline().rsplit()))

eratosthenes = []
primeNumber = []
maximum = 100000

divisor1 = []
divisor2 = []
gcd = 1

nod1 = 0
nod2 = 0
flag = False

#################eratosthenes###########################
for i in range(0, maximum + 1):
    if i % 2 == 0:
        eratosthenes.append(False)

    else:
        eratosthenes.append(True)

eratosthenes[0] = False
eratosthenes[1] = False
eratosthenes[2] = True

i = 1
while True:
    i += 1

    if i % 2 == 0:
        continue

    if i > math.sqrt(maximum) + 1:
        break

    k = 2
    while i * k <= maximum:
        eratosthenes[k * i] = False
        k += 1

for i in range(maximum + 1):  # add prime numbers into primeNumber
    if eratosthenes[i]:
        primeNumber.append(i)
########################################################

for num in numbers1:
    nod = 0

    while True:
        if len(primeNumber) <= nod:
            divisor1.append(num)
            break

        elif num < primeNumber[nod]:
            break

        if num % primeNumber[nod] == 0:
            divisor1.append(primeNumber[nod])
            num //= primeNumber[nod]

        else:
            nod += 1

for num in numbers2:
    nod = 0

    while True:
        if len(primeNumber) <= nod:
            divisor2.append(num)
            break

        elif num < primeNumber[nod]:
            break

        if num % primeNumber[nod] == 0:
            divisor2.append(primeNumber[nod])
            num //= primeNumber[nod]

        else:
            nod += 1

divisor1.sort()
divisor2.sort()

while True:
    if nod1 >= len(divisor1) or nod2 >= len(divisor2):
        break

    num1 = divisor1[nod1]
    num2 = divisor2[nod2]

    if num1 > num2:
        nod2 += 1

    elif num1 < num2:
        nod1 += 1

    else:
        gcd *= num1

        nod1 += 1
        nod2 += 1

        if gcd > 1000000000:
            gcd %= 1000000000
            flag = True

if flag:
    for i in range(9, len(str(gcd)), -1):
        print('0', end = '')

print(gcd)
