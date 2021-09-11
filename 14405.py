string = input()

while True:
    if string.find('pi') >= 0:
        string = string.replace('pi', '-')

    elif string.find('ka') >= 0:
        string = string.replace('ka', '-')

    elif string.find('chu') >= 0:
        string = string.replace('chu', '-')

    else:
        break

if len(string.strip('-')) == 0:
    print('YES')

else:
    print('NO')
