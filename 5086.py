while True:
    num1, num2 = map(int, input().split())

    if not num1 and not num2:
        break

    else:
        if num2 % num1 == 0:
            print('factor')

        elif num1 % num2 == 0:
            print('multiple')

        else:
            print('neither')
