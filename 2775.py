n = int(input())

apt = [[0] * 15 for n in range(0, 15)]

for i in range(0, 15):
    apt[0][i] = i

for floor in range(1, 15):
    for room in range(0, 15):
        sum = 0

        for j in range(0, room + 1):
            sum += apt[floor - 1][j]

        apt[floor][room] = sum

output = []

for i in range(n):
    floor = int(input())
    room = int(input())

    output.append(apt[floor][room])

for out in output:
    print(out)
