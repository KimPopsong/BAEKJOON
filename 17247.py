row, col = map(int, input().split())

taxiMap = []

for i in range(row):
    taxiMap.append(list(map(int, input().split())))

startX = -1
startY = -1
endX = 0
endY = 0

for i in range(row):
    for j in range(col):
        if taxiMap[i][j] == 1:
            if startX != -1 and startY != -1:
                endX = i
                endY = j

            else:
                startX = i
                startY = j

print(abs(startX - endX) + abs(startY - endY))
