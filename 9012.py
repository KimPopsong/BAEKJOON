import sys

n = int(input())

for k in range(n):
    string = sys.stdin.readline()

    stack = []

    flag = True

    for i in range(len(string)):
        if string[i] == '(':
            stack.append(string[i])

        if string[i] == ')':
            if len(stack) == 0:
                flag = False
                break

            else:
                if string[i] == ')':
                    if stack[-1] == '(':
                        stack.pop(-1)

                    else:
                        flag = False
                        break

    if len(stack) != 0:
        flag = False

    if flag:
        print('YES')

    else:
        print('NO')
