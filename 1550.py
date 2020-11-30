num = input()

binary = 0

for i in range(len(num)):
    temp = num[i]

    if temp == 'A':
        temp = 10

    elif temp == 'B':
        temp = 11

    elif temp == 'C':
        temp = 12

    elif temp == 'D':
        temp = 13

    elif temp == 'E':
        temp = 14

    elif temp == 'F':
        temp = 15

    else:
        temp = int(temp)

    binary += temp * (16 ** (len(num) - i - 1))

print(binary)
