import math

testCase = int(input())

case = list(map(int, input().split()))

for i in range(testCase):
    n = int(math.sqrt(case[i]))

    if case[i] == n ** 2:
        print(1, end = ' ')

    else:
        print(0, end = ' ')
