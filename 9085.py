testCase = int(input())

for i in range(testCase):
    n = int(input())

    sumNum = 0

    t = list(map(int, input().split()))

    for j in range(len(t)):
        sumNum += t[j]

    print(sumNum)
