import sys

elecNumber, socketNumber = map(int, sys.stdin.readline().rsplit())

elecSocket = [0] * socketNumber
electric = list(map(int, sys.stdin.readline().rsplit()))

electric.sort()

time = 0
while True:
    for s in range(socketNumber):
        if elecSocket[s] <= 0:
            if len(electric) != 0:
                elecSocket[s] = electric[-1]
                electric.pop()

    f = True
    while f:
        time += 1

        for s in range(socketNumber):
            elecSocket[s] -= 1

            if elecSocket[s] <= 0:
                f = False

    if len(electric) == 0:
        flag = True

        for s in elecSocket:
            if s > 0:
                flag = False
                break

        if flag:
            break

print(time)
