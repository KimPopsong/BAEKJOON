# 1, 6, 19, 44...
#  5, 13, 25...

block = int(input())

floor = 0
while True:
    floor += 1

    block -= floor ** 2 + (floor - 1) ** 2

    if block < 0:
        floor -= 1
        break

print(floor)
