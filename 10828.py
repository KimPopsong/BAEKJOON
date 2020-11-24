def Push(n):
    stack.append(n)

def Pop():
    if len(stack) == 0:
        answer.append(-1)

    else:
        answer.append(stack.pop())

def Size():
    answer.append(len(stack))

def Empty():
    if len(stack) == 0:
        answer.append(1)

    else:
        answer.append(0)

def Top():
    if len(stack) == 0:
        answer.append(-1)

    else:
        answer.append(stack[-1])

repeat = int(input())
stack = []
node = -1
command = []
answer = []

for i in range(repeat):
    command.append(input())

for i in range(repeat):
    cmd = command[i].split()

    if cmd[0] == 'push':
        Push(int(cmd[1]))

    elif cmd[0] == 'pop':
        Pop()

    elif cmd[0] == 'size':
        Size()

    elif cmd[0] == 'empty':
        Empty()

    else:
        Top()

for n in answer:
    print(n)
