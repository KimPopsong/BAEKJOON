import sys

def Clean(x1, y1):
    global cleanedRoom

    if cleanMap[x1][y1] == 0:
        cleanMap[x1][y1] = 2
        cleanedRoom += 1

def Find(x1, y1, drct):
    notCleanedRoomFlag = False

    if drct == 0:
        if y1 > 0:
            if cleanMap[x1][y1 - 1] == 0:
                notCleanedRoomFlag = True

    elif drct == 1:
        if x1 > 0:
            if cleanMap[x1 - 1][y1] == 0:
                notCleanedRoomFlag = True

    elif drct == 2:
        if y1 < col - 1:
            if cleanMap[x1][y1 + 1] == 0:
                notCleanedRoomFlag = True

    else:
        if x1 < row - 1:
            if cleanMap[x1 + 1][y1] == 0:
                notCleanedRoomFlag = True

    return notCleanedRoomFlag

def Rotate(drct):
    drct -= 1

    if drct < 0:
        drct = 3

    return drct

def Move(x1, y1, drct):
    if drct == 0:
        if x1 > 0:
            x1 -= 1

    elif drct == 1:
        if y1 < col - 1:
            y1 += 1

    elif drct == 2:
        if x1 < row - 1:
            x1 += 1

    else:
        if y1 > 0:
            y1 -= 1

    return x1, y1

def MoveBack(x1, y1, drct):
    moveBackFlag = False

    if drct == 0:
        if x1 < row - 1:
            x1 += 1
            moveBackFlag = True

    elif drct == 1:
        if y1 > 0:
            y1 -= 1
            moveBackFlag = True

    elif drct == 2:
        if x1 > 0:
            x1 -= 1
            moveBackFlag = True

    else:
        if y1 < col - 1:
            y1 += 1
            moveBackFlag = True

    if cleanMap[x1][y1] == 1:
        moveBackFlag = False

    return x1, y1, moveBackFlag

row, col = map(int, sys.stdin.readline().rsplit())

x, y, direction = map(int, sys.stdin.readline().rsplit())  # In direction, 0, 1, 2, 3 -> N, E, S, W

cleanMap = []  # 0 is uncleaned room, 1 is wall and 2 is cleaned room
cleanedRoom = 0
rotateCount = 0

for i in range(row):
    temp = list(map(int, sys.stdin.readline().rsplit()))

    cleanMap.append(temp)

while True:
    if rotateCount >= 4:
        x, y, flag = MoveBack(x, y, direction)

        if not flag:
            break

        else:
            rotateCount = 0

    Clean(x, y)

    if Find(x, y, direction):
        rotateCount = 0
        direction = Rotate(direction)
        x, y = Move(x, y, direction)

    else:
        direction = Rotate(direction)
        rotateCount += 1

print(cleanedRoom)
