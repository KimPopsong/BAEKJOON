for i in range(int(input())):
    triangle = list(map(int, input().split()))

    triangle.sort()

    print('Scenario #' + str(i + 1) + ':')

    if triangle[0] ** 2 + triangle[1] ** 2 == triangle[2] ** 2:
        print('yes')

    else:
        print('no')
    print()
