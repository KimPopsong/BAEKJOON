row, col = map(int, input().split())

castle = []
count = 0

for i in range(row):
    castle.append(list(input().strip()))

while True:
    nodX = -1
    nodY = -1

    for i in range(row):
        flag = False

        for j in range(col):  # 행 단위로 먼저 찾기
            if castle[i][j] == 'X':
                flag = True
                break

        if not flag:  # 행에 경비원이 없다면
            nodX = i
            break

    for j in range(col):
        flag = False

        for i in range(row):  # 열 단위로 찾기
            if castle[i][j] == 'X':
                flag = True
                break

        if not flag:  # 열에 경비원이 없다면
            nodY = j
            break

    if nodX == -1 and nodY == -1:
        break

    elif nodX == -1:
        castle[0][nodY] = 'X'

    elif nodY == -1:
        castle[nodX][0] = 'X'

    else:
        castle[nodX][nodY] = 'X'

    count += 1

print(count)
