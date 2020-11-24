caseNumber = int(input())

commands = []
answer = ''

for i in range(caseNumber):
    commands.append(input())

for i in range(0, len(commands[0])):
    flag = 0
    node = commands[0][i]

    for command in commands:
        if command[i] != node:
            flag = 1
            break

    if flag:
        answer += '?'

    else:
        answer += node

print(answer)
