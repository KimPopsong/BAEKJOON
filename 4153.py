while True:
    slide = sorted(list(map(int, input().split())))

    if slide[0] == slide[1] == slide[2] == 0:
        exit()

    if slide[2] ** 2 == slide[1] ** 2 + slide[0] ** 2:
        print('right')

    else:
        print('wrong')
