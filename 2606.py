computerNumber = int(input())
connectedComputerNumber = int(input())

connectedComputer = []
virusComputer = [False] * (computerNumber + 1)
virusComputer[1] = True

for i in range(connectedComputerNumber):
    temp = list(map(int, input().split()))
    if temp[0] > temp[1]:
        temp[1], temp[0] = temp[0], temp[1]

    connectedComputer.append(temp)

connectedComputer.sort()

queue = []

for com in connectedComputer:
    if com[0] == 1:
        queue.append(com[1])
        virusComputer[com[1]] = True

    else:
        break

while len(queue) != 0:
    for com in connectedComputer:
        if com[0] == queue[0]:
            if not virusComputer[com[1]]:
                virusComputer[com[1]] = True
                queue.append(com[1])
                continue

        if com[1] == queue[0]:
            if not virusComputer[com[0]]:
                virusComputer[com[0]] = True
                queue.append(com[0])

    queue.pop(0)

print(virusComputer.count(True) - 1)
