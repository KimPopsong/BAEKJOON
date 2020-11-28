def Factorial(num):
    n = 1

    for i in range(num, 1, -1):
        n *= i

    return n

def Combination(n, k):
    return int(Factorial(n) / Factorial(n - k) / Factorial(k))

number = list(map(int, input().split()))

n = number[0]
k = number[1]

print(Combination(n, k))
