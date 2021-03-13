n = input()

if n == '0':
    print(0)
    exit()

if n[0] == '1':
    print('1', end = '')

elif n[0] == '2':
    print('10', end = '')

elif n[0] == '3':
    print('11', end = '')

elif n[0] == '4':
    print('100', end = '')

elif n[0] == '5':
    print('101', end = '')

elif n[0] == '6':
    print('110', end = '')

elif n[0] == '7':
    print('111', end = '')

for i in range(1, len(n)):
    if n[i] == '0':
        print('000', end = '')

    elif n[i] == '1':
        print('001', end = '')

    elif n[i] == '2':
        print('010', end = '')

    elif n[i] == '3':
        print('011', end = '')

    elif n[i] == '4':
        print('100', end = '')

    elif n[i] == '5':
        print('101', end = '')

    elif n[i] == '6':
        print('110', end = '')

    elif n[i] == '7':
        print('111', end = '')
