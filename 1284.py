import sys

while True:
    number = sys.stdin.readline().rstrip()

    if number == '0':
        break

    sumBlank = 2  # Front & End

    sumBlank += (len(number) - 1)

    for i in range(len(number)):
        if number[i] == '1':
            sumBlank += 2

        elif number[i] == '0':
            sumBlank += 4

        else:
            sumBlank += 3

    print(sumBlank)
