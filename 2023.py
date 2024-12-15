import sys, math


def isPrime(number):  # 소수 판별
    for i in range(3, int(math.sqrt(number)) + 1):
        if (number % i == 0):  # 소수가 아니라면
            return False

    return True


def findPrime(number, depth):
    if (depth == nDigit):
        if (isPrime(number)):
            print(number)

        return

    number *= 10

    for i in range(1, 10, 2):  # [1, 3, 5, 7, 9]
        if (isPrime(number + i)):
            findPrime(number + i, depth + 1)


nDigit = int(sys.stdin.readline().rstrip())

oneDigitPrime = [2, 3, 5, 7]

for o in oneDigitPrime:
    findPrime(o, 1)
