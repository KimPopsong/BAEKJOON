import math

def Check(temp):
    distanceX = abs(temp[0] - temp[3])
    distanceY = abs(temp[1] - temp[4])
    radSum = temp[2] + temp[5]
    distance = abs(distanceX ** 2 + distanceY ** 2)

    if temp[0] == temp[3] and temp[1] == temp[4] and temp[2] == temp[5]:  # When same
        print(-1)

    elif radSum ** 2 == distance:  # When circumscribe
        print(1)

    elif math.sqrt(distance) + temp[2] == temp[5] or math.sqrt(distance) + temp[5] == temp[2]:  # When inscribe
        print(1)

    elif radSum ** 2 < distance:  # When intersection point is none
        print(0)

    elif math.sqrt(distance) + temp[2] < temp[5] or math.sqrt(distance) + temp[5] < temp[2]:  # When one circle is smaller and located in another circle
        print(0)

    else:  # When intersection point is more than one
        print(2)

testcase = int(input())

case = []

for i in range(testcase):
    temp = input().split()
    temp = [int(i) for i in temp]
    case.append(temp)

for n in case:
    Check(n)
