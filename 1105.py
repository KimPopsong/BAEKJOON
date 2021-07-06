minNum, maxNum = input().split()

countEight = 0

if len(minNum) != len(maxNum):
    print(0)
    exit()

for i in range(len(minNum)):
    if minNum[i] == maxNum[i]:
        if minNum[i] == '8':
            countEight += 1

    else:
        break

print(countEight)
