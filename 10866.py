import sys

commandNumber = int(sys.stdin.readline().rstrip())

deque = []

for i in range(commandNumber):
    command = list(sys.stdin.readline().rsplit())

    if command[0] == 'push_front':
        deque.insert(0, int(command[1]))

    elif command[0] == 'push_back':
        deque.append(int(command[1]))

    elif command[0] == 'pop_front':
        if len(deque) == 0:
            print(-1)

        else:
            print(deque[0])
            del deque[0]

    elif command[0] == 'pop_back':
        if len(deque) == 0:
            print(-1)

        else:
            print(deque[-1])
            del deque[-1]

    elif command[0] == 'size':
        print(len(deque))

    elif command[0] == 'empty':
        if len(deque) == 0:
            print(1)

        else:
            print(0)

    elif command[0] == 'front':
        if len(deque) == 0:
            print(-1)

        else:
            print(deque[0])

    elif command[0] == 'back':
        if len(deque) == 0:
            print(-1)

        else:
            print(deque[-1])
