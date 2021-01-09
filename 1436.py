n = int(input())

count = 0

for i in range(666, 2666800):
    flag = 0
    strI = str(i)

    for j in range(len(strI)):
        if strI[j] == '6':
            flag += 1

        else:
            flag = 0

        if flag >= 3:
            count += 1

            if count == n:
                print(i)
                exit()

            break
