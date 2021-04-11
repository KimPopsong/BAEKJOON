best = 0
bestSnack = ''

for i in range(3):
    temp = list(map(int, input().split()))

    sumWeight = temp[1] * 10
    sumPrice = temp[0] * 10

    if sumPrice >= 5000:
        sumPrice -= 500

    temp = sumWeight / sumPrice

    if best < temp:
        best = temp

        if i == 0:
            bestSnack = 'S'

        elif i == 1:
            bestSnack = 'N'

        else:
            bestSnack = 'U'

print(bestSnack)
