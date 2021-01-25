import sys

row, col, blocks = map(int, sys.stdin.readline().rsplit())

land = []

for i in range(row):
    temp = sys.stdin.readline().rsplit()

    for t in temp:
        land.append(int(t))

land.sort(reverse = True)

highest = land[0]
lowest = land[-1]

time = 100000000000000000
height = -1

for i in range(lowest, highest + 1, 1):
    flag = True
    tempTime = 0
    tempBlock = blocks

    for l in land:
        if l == i:
            continue

        elif l > i:
            temp = l - i
            tempBlock += temp
            tempTime += temp * 2

        else:
            temp = i - l
            tempBlock -= temp

            if tempBlock < 0:
                flag = False
                break

            else:
                tempTime += temp

    if flag:
        if tempTime < time:
            time = tempTime
            height = i

        elif tempTime == time:
            if height < i:
                height = i

    else:
        continue

print(time, height)
