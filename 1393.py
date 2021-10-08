def CalcDistance(x, y):
    global stationX, stationY

    return (x - stationX) ** 2 + (y - stationY) ** 2

stationX, stationY = map(int, input().split())

trainX, trainY, trainDx, trainDy = map(int, input().split())

jumpX = trainX
jumpY = trainY

distance = CalcDistance(trainX, trainY)

nod = 2
while True:
    if nod > min(abs(trainDx), abs(trainDy)):
        break

    if abs(trainDx) % nod == 0 and abs(trainDy) % nod == 0:
        trainDx //= nod
        trainDy //= nod

    else:
        nod += 1

# Check if one of trainDx or trainDy is 0
if trainDx == 0 and trainDy != 0:
    trainDy //= abs(trainDy)

if trainDx != 0 and trainDy == 0:
    trainDx //= abs(trainDx)

while True:
    trainX += trainDx
    trainY += trainDy

    distanceNow = CalcDistance(trainX, trainY)

    if distanceNow < distance:
        jumpX = trainX
        jumpY = trainY

        distance = distanceNow

    else:
        break

print(jumpX, jumpY)
