import sys

while True:
    string = sys.stdin.readline()

    if string == '.\n':
        break

    else:
        stack = []
        flag = True

        for i in range(len(string)):
            if string[i] == '(' or string[i] == '[':
                stack.append(string[i])

            if string[i] == ')' or string[i] == ']':
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

                    else:
                        if stack[-1] == '[':
                            stack.pop(-1)

                        else:
                            flag = False
                            break
                            
        if len(stack) != 0:
            flag = False

    if flag:
        print('yes')

    else:
        print('no')
