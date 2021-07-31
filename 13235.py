string = input()

flag = True

for i in range(len(string)):
    if string[i] != string[len(string) - 1 - i]:
        flag = False
        break

if flag:
    print('true')

else:
    print('false')
