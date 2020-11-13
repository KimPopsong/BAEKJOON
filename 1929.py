import math

def IsPrime(number):
    if number == 1:
        return False

    else:
        for i in range(2, int(math.sqrt(number)) + 1 ):
            if number % i == 0:
                return False

    return True

s = input().split()

minimum = int(s[0])
maximum = int(s[1])

for i in range(minimum, maximum + 1):
    if IsPrime(i):
        print(i)
