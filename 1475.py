def ReFill():
    for i in range(len(numberSet)):
        numberSet[i] += 1
    numberSet[6] += 1

roomNumber = list(input())

numberSet = [1] * 9
numberSet[6] += 1
setCount = 1

for i in range(len(roomNumber)):
    if roomNumber[i] == '9':
        roomNumber[i] = '6'

    if numberSet[int(roomNumber[i])] <= 0:
        ReFill()
        setCount += 1

    numberSet[int(roomNumber[i])] -= 1

print(setCount)
