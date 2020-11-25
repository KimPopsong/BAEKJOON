def IsLucky(num):
    strNum = str(num)

    leftNum = 0
    rightNum = 0

    for i in range(0, len(strNum) // 2):
        leftNum += int(strNum[i])

    for i in range(len(strNum) // 2, len(strNum)):
        rightNum += int(strNum[i])

    if leftNum == rightNum:
        return True

    else:
        return False

number = int(input())

if IsLucky(number):
    print('LUCKY')

else:
    print('READY')
