testCase = int(input())

for i in range(testCase):
    caseNum, length, spd1, spd2, flySpeed = map(float, input().split())

    time = length / (spd1 + spd2)

    flyLength = flySpeed * time

    print('%d %.6f'%(caseNum, flyLength))
