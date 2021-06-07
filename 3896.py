import math, sys

eratosthenes = []
maximum = 1299710

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

testCase = int(sys.stdin.readline().rstrip())

for i in range(testCase):
    count = 0

    n = int(sys.stdin.readline().rstrip())

    if eratosthenes[n]:  # 소수일 시, 길이는 0
        print(0)
        continue

    leftNod = n - 1
    rightNod = n + 1
    while True:  # 오른쪽의 소수 찾기
        if eratosthenes[rightNod]:
            break

        rightNod += 1

    while True:  # 왼쪽의 소수 찾기
        if eratosthenes[leftNod]:
            break

        leftNod -= 1

    print(rightNod - leftNod)
