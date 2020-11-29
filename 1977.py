import math

minimum = int(input())
maximum = int(input())

sum = 0
minPerfectSquare = -1
flag = 0

for i in range(1, int(math.sqrt(maximum)) + 1):
    if minimum <= i * i <= maximum:
        sum += i * i

        if flag:
            continue

        else:
            minPerfectSquare = i * i
            flag = 1

if sum == 0:
    print(-1)
    exit()

else:
    print(sum)
    print(minPerfectSquare)
