while True:
    num = input()
    flag = 0

    if num == '0':
        break

    for i in range(len(num) // 2 + 1):
        if num[i] != num[len(num) - 1 - i]:
            flag = 1
            break

    if flag:
        print('no')

    else:
        print('yes')