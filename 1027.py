def CountBuilding(inclines, start):
    rightNode = start + 1
    leftNode = start - 1

    rightCount = 0
    leftCount = 0

    if rightNode >= len(inclines):
        rightIncline = 0

    else:
        rightIncline = inclines[rightNode]
        rightCount += 1

    if leftNode < 0:
        leftIncline = 0

    else:
        leftIncline = inclines[leftNode]
        leftCount += 1

    for i in range(leftNode, -1, -1):
        if leftIncline > inclines[i]:
            leftCount += 1
            leftIncline = inclines[i]

    for i in range(rightNode, len(inclines)):
        if rightIncline < inclines[i]:
            rightCount += 1
            rightIncline = inclines[i]

    return leftCount + rightCount

buildingNumber = int(input())
buildings = list(map(int, input().split()))
answer = 0
flag = 0

if buildingNumber == 1:
    print(0)
    exit()

elif buildingNumber == 2:
    print(1)
    exit()

else:
    for i in range(1, buildingNumber):
        if buildings[0] != buildings[i]:
            flag = 1
            break
if not flag:
    print(2)
    exit()

for i in range(0, buildingNumber):
    incline = [0 for k in range(buildingNumber)]

    incline[i] = 0

    for j in range(0, buildingNumber):
        if i == j:
            continue

        xChange = i - j
        yChange = buildings[i] - buildings[j]

        inc = yChange / xChange

        incline[j] = inc

    temp = CountBuilding(incline, i)

    if answer < temp:
        answer = temp

print(answer)
