string = input().split()

diff = len(string[1])

for i in range(len(string[1]) - len(string[0]) + 1):
    temp = 0

    for j in range(len(string[0])):
        if string[0][j] != string[1][i + j]:
            temp += 1

    if temp < diff:
        diff = temp

print(diff)
