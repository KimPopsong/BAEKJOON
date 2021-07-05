def calcGCD(n1, n2):
    gcd = 1

    nod = 2
    while True:
        if n1 < nod or n2 < nod:
            break

        if n1 % nod == 0 and n2 % nod == 0:
            gcd *= nod
            n1 //= nod
            n2 //= nod

        else:
            nod += 1

    return gcd

testCase = int(input())

for i in range(testCase):
    num1, num2 = map(int, input().split())

    gcd = calcGCD(num1, num2)

    print(num1 * num2 // gcd)
