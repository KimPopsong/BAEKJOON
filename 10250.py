n = int(input())
output = []

for i in range(n):
    s = input().split()

    height = int(s[0])
    width = int(s[1])
    customer = int(s[2])

    floor = customer % height

    if customer % height != 0:
        room = 1 + int(customer / height)

    else:
        room = int(customer / height)

    if floor == 0:
        floor += height

    output.append(floor * 100 + room)

for i in output:
    print(i)
