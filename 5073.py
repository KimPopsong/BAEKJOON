while True:
    side = list(map(int, input().split()))

    side.sort()

    if side[0] == side[1] == side[2] == 0:
        break

    elif side[0] == side[1] == side[2]:
        print('Equilateral')

    elif side[0] + side[1] <= side[2]:
        print('Invalid')

    elif side[0] != side[1] != side[2]:
        print('Scalene')

    else:
        print('Isosceles')
