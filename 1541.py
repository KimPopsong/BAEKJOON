import sys

line = sys.stdin.readline()

sumNum = 0
temp = ''
minusSum = 0
minusFlag = False

for i in range(len(line)):
    if line[i] != '+' and line[i] != '-':
        temp += line[i]

    else:
        if line[i] == '-':
            if minusFlag:
                minusSum += int(temp)

            else:
                sumNum += int(temp)

            minusFlag = True

        else:
            if minusFlag:
                minusSum += int(temp)

            else:
                sumNum += int(temp)

        temp = ''

if minusFlag:
    minusSum += int(temp)
    sumNum -= minusSum

else:
    sumNum += int(temp)

print(sumNum)
