import math

def CheckCoprime(n1, n2):
    for i in range(2, n1 + 1):
        if n1 % i == 0 and n2 % i == 0:
            return False

    return True

s = list(map(int, input().split()))

lcm = s[0]
gcd = s[1]

div = gcd // lcm

num1 = 1
num2 = gcd

for i in range(1, int(math.sqrt(div) + 1)):
    if div % i == 0:
        if CheckCoprime(i, div // i):
            num1 = i * lcm
            num2 = (div // i) * lcm

print(num1, num2)
