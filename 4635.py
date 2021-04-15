while True:
    n = int(input())

    if n == -1:
        break

    data = []
    mile = 0

    for i in range(n):
        temp = list(map(int, input().split()))
        data.append(temp)

    mile += data[0][0] * data[0][1]

    for i in range(1, n):
        mile += data[i][0] * (data[i][1] - data[i - 1][1])

    print(mile, 'miles')
