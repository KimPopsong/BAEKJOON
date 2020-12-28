import sys

row, col = map(int, input().split())
square = []

for i in range(row):
    temp = sys.stdin.readline().rsplit()
    t = []

    for j in range(col):
        t.append(temp[0][j])

    square.append(t)

size = 1
slide = max(row, col)
flag = 0

while True:
    slide -= 1

    if slide < 0 or flag:
        break

    for i in range(row - slide):
        for j in range(col - slide):
            if square[i][j] == square[i][j + slide] == square[i + slide][j] == square[i + slide][j + slide]:
                size = slide
                flag = 1
                break

print((size + 1) ** 2)
