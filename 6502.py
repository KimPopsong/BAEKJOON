import math

count = 0

while True:
    count += 1

    size = list(map(int, input().split()))

    if size[0] == 0:
        break

    if (size[0] * 2) >= math.sqrt(size[1] ** 2 + size[2] ** 2):
        print('Pizza ' + str(count) + ' fits on the table.')

    else:
        print('Pizza ' + str(count) + ' does not fit on the table.')
