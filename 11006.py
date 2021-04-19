testCase = int(input())

for i in range(testCase):
    chickenLegSum, chickenNum = map(int, input().split())

    goodChicken = chickenLegSum - chickenNum
    badChicken = chickenNum - goodChicken

    print(badChicken, goodChicken)
