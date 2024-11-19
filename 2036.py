import sys

number = int(sys.stdin.readline().rstrip())
numbersPlus = []  # 양수
numbersMinus = []  # 음수
numberOne = []  # 1만 제외

for _ in range(number):
    num = int(sys.stdin.readline().rstrip())

    if (num == 1):
        numberOne.append(num)

    elif (num > 0):
        numbersPlus.append(num)

    else:
        numbersMinus.append(num)

numbersPlus.sort()
numbersMinus.sort(reverse=True)  # 절대값이 클 수록 빨리 pop

sumNumber = 0

while (len(numbersPlus) > 1):
    num1 = numbersPlus.pop()
    num2 = numbersPlus.pop()

    sumNumber += num1 * num2

while (len(numbersMinus) > 1):
    num1 = numbersMinus.pop()
    num2 = numbersMinus.pop()

    sumNumber += num1 * num2

if (len(numbersPlus)):
    sumNumber += numbersPlus.pop()

if (len(numbersMinus)):
    sumNumber += numbersMinus.pop()

if (len(numberOne)):
    sumNumber += len(numberOne)

print(sumNumber)
