import sys

def GCD(a, b):
    if b == 0 or a % b == 0:
        return b

    else:
        return GCD(b, a % b)

testCase = int(sys.stdin.readline().rstrip())

for i in range(testCase):
    case = list(map(int, sys.stdin.readline().rsplit()))

    n = case[0]
    case.pop(0)
    case.sort()

    sumGCD = 0

    for j in range(0, n - 1):
        for k in range(j + 1, n):
            sumGCD += GCD(case[k], case[j])

    print(sumGCD)
