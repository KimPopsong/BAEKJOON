def CheckRight(ii, jj, bck, cnt):
    if ii >= 12 or jj >= 6:
        return cnt

    if cnt >= 4:
        return cnt

    if line[ii][jj] == bck:
        cnt += 1

        cnt = CheckRight(ii, jj + 1, bck, cnt)
        cnt = CheckBlocks(ii + 1, jj, bck, cnt)

    return cnt

def CheckLeft(ii, jj, bck, cnt):
    if ii >= 12 or jj < 0:
        return cnt

    if cnt >= 4:
        return cnt

    if line[ii][jj] == bck:
        cnt += 1

        cnt = CheckLeft(ii, jj - 1, bck, cnt)
        cnt = CheckBlocks(ii + 1, jj, bck, cnt)

    return cnt

def CheckBlocks(ii, jj, bck, cnt):
    if ii >= 12 or jj >= 6 or jj < 0:
        return cnt

    if cnt >= 4:
        return cnt

    if line[ii][jj] == bck:
        cnt += 1

        cnt = CheckBlocks(ii + 1, jj, bck, cnt)
        cnt = CheckRight(ii, jj + 1, bck, cnt)
        cnt = CheckLeft(ii, jj - 1, bck, cnt)

    return cnt

def Check():
    avl = []

    for i in range(12):
        for j in range(6):
            if line[i][j] == '.':
                continue

            else:
                count = CheckBlocks(i, j, line[i][j], 0)

                if count >= 4:
                    temp = [i, j]
                    avl.append(temp)
    return avl

def PopBlocks(ii, jj, blk):
    if ii >= 12 or jj >= 6 or jj < 0:
        return

    if line[ii][jj] == blk:
        line[ii][jj] = '.'

        if ii < 11:
            if line[ii + 1][jj] == blk:
                PopBlocks(ii + 1, jj, blk)

        if jj < 5:
            if line[ii][jj + 1] == blk:
                PopBlocks(ii, jj + 1, blk)

        if jj > 0:
            if line[ii][jj - 1] == blk:
                PopBlocks(ii, jj - 1, blk)

def Pop(avl):
    for i in range(len(avl)):
        blk = line[avl[i][0]][avl[i][1]]

        if blk != '.':
            PopBlocks(avl[i][0], avl[i][1], blk)

def Down():
    for j in range(6):
        lower = 11

        while True:
            if lower < 1:
                break

            if line[lower][j] == '.':
                upper = lower - 1

                while True:
                    if line[upper][j] != '.' or upper == 0:
                        break

                    else:
                        upper -= 1

                if line[upper][j] != '.':
                    line[lower][j], line[upper][j] = line[upper][j], line[lower][j]  # Change

            lower -= 1

line = []
chain = 0

for i in range(12):
    t = list(input())
    line.append(t)

while True:
    avail = Check()  # Check if Pop is available

    if not len(avail):
        print(chain)
        exit()

    Pop(avail)  # Remove blocks if more than 4 blocks are gathered

    Down()  # Remove blanks

    chain += 1
