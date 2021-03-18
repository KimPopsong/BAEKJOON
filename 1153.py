import math

def SumNum():
    return primeNumber[nod1] + primeNumber[nod2] + primeNumber[nod3] + primeNumber[nod4]

def Adjust():
    global nod1, nod2, nod3, nod4

    nod3 += 1
    nod4 = nod3

    if SumNum() > n:
        nod2 += 1
        nod3 = nod2
        nod4 = nod2

        if SumNum() > n:
            nod1 += 1
            nod2 = nod1
            nod3 = nod1
            nod4 = nod1

            if SumNum() > n:
                print(-1)
                exit()

eratosthenes = []
maximum = 1000000
for i in range(0, maximum + 1):
    eratosthenes.append(True)

    if i % 2 == 0:
        eratosthenes[i] = False

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

primeNumber = []

for i in range(maximum + 1):
    if eratosthenes[i]:
        primeNumber.append(i)

n = int(input())

nod1, nod2, nod3, nod4 = 0, 0, 0, 0
flag = 4

while True:
    sumNum = primeNumber[nod1] + primeNumber[nod2] + primeNumber[nod3] + primeNumber[nod4]

    if sumNum < n:
        nod4 += 1

        t = len(primeNumber)

        if nod1 >= t or nod2 >= t or nod3 >= t or nod4 >= t:
            Adjust()

    elif sumNum > n:
        Adjust()

    else:
        print(primeNumber[nod1], primeNumber[nod2], primeNumber[nod3], primeNumber[nod4])
        exit()
