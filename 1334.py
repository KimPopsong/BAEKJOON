import math

n = input()

if len(n) == 1:  # When n is single digit
    if n == '9':  # When n is 9, print 11
        print('11')

    else:
        print(int(n) + 1)

    exit()

tempStr = n[0:math.ceil(len(n) / 2)] + n[len(n) // 2 - 1::-1]  # Divide it into the middle and put the left side upside down on the right side

if tempStr > n:  # If tempStr is bigger than n
    print(tempStr)  # Print

else:  # Add 1 into middle and repeat
    intN = int(n)

    intN += 10 ** (len(n) // 2)

    n = str(intN)

    tempStr = n[0:math.ceil(len(n) / 2)] + n[len(n) // 2 - 1::-1]

    print(tempStr)
