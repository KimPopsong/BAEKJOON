import sys

destination = int(sys.stdin.readline().rstrip())

brokenButtonNumber = int(sys.stdin.readline().rstrip())

brokenButton = []
if brokenButtonNumber != 0:
    brokenButton = list(map(int, sys.stdin.readline().rsplit()))

count = 0

upChannel = destination
downChannel = destination

if destination == 100:
    print(0)
    exit()

elif destination == 99 or destination == 101:
    print(1)
    exit()

elif destination == 98 or destination == 102:
    print(2)
    exit()

while True:
    upFlag = False
    downFlag = False

    for i in range(len(str(upChannel))):
        t = str(upChannel)[i]

        if brokenButton.count(int(t)):
            upFlag = True
            break

    for i in range(len(str(downChannel))):
        t = str(downChannel)[i]

        if brokenButton.count(int(t)):
            downFlag = True
            break

    if 98 <= upChannel <= 102:
        upFlag = False

    if 98 <= downChannel <= 102:
        downFlag = False

    if not upFlag or not downFlag:
        tempUp = 500000
        tempDown = 500000

        if not upFlag:
            if not (98 <= upChannel <= 102):
                tempUp = count + len(str(upChannel))

            else:
                if upChannel == 98 or upChannel == 102:
                    tempUp = count + 2

                elif upChannel == 99 or upChannel == 101:
                    tempUp = count + 1

                else:
                    tempUp = count

        if not downFlag:
            if not (98 <= downChannel <= 102):
                tempDown = count + len(str(downChannel))

            else:
                if downChannel == 98 or downChannel == 102:
                    tempDown = count + 2

                elif downChannel == 99 or downChannel == 101:
                    tempDown = count + 1

                else:
                    tempDown = count

        count = min(tempUp, tempDown)

        break

    upChannel += 1
    downChannel -= 1

    if downChannel < 0:
        downChannel = 0

    count += 1

print(count)
