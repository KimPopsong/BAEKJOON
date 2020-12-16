import math

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

testcase = []

while True:
    n = int(input())

    if not n:
        break

    else:
        testcase.append(n)

for case in testcase:
    for i in range(3, case // 2 + 1):
        if eratosthenes[i] and eratosthenes[case - i]:
            print(case, '=', i, '+', case - i)
            break
