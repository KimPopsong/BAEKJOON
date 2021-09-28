zeroCount = []  # display zeroes in number

for number in range(0, 1000001):
    count = 0  # count zero in number

    strNumber = str(number)

    for i in range(len(strNumber)):
        if strNumber[i] == '0':
            count += 1

    zeroCount.append(count)

for _ in range(int(input())):
    sumZero = 0

    start, end = map(int, input().split())

    for i in range(start, end + 1):
        sumZero += zeroCount[i]

    print(sumZero)
