import sys

commandNumber = int(sys.stdin.readline())

queue = []

for i in range(commandNumber):
    command = sys.stdin.readline().split()

    if command[0] == 'push':
        queue.append(int(command[1]))

    elif command[0] == 'pop':
        if len(queue):
            print(queue.pop(0))

        else:
            print(-1)

    elif command[0] == 'size':
        print(len(queue))

    elif command[0] == 'empty':
        if len(queue):
            print(0)

        else:
            print(1)

    elif command[0] == 'front':
        if len(queue):
            print(queue[0])

        else:
            print(-1)

    else:
        if len(queue):
            print(queue[-1])

        else:
            print(-1)
