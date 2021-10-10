import math

size, destRow, destCol = map(int, input().split())

count = 0

block = (2 ** size) ** 2

while block > 1:
    slideSize = 2 ** (size - 1)

    if destRow < slideSize:  # When destRow is in the first or second quadrants
        if destCol < slideSize:  # When destination is second quadrant
            count += 0

        else:  # When destination is first quadrant
            count += block // 4

            destCol -= slideSize

    else:  # When destRow is in the third or fourth quadrants
        if destCol >= slideSize:  # When destination is fourth quadrant
            count += block // 4 * 3

            destRow -= slideSize
            destCol -= slideSize

        else:  # When destination is third quadrant
            count += block // 4 * 2

            destRow -= slideSize

    block //= 4
    size -= 1

print(count)
