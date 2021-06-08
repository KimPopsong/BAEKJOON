lamp = list(input().strip())

count = 0

nod = -1
while True:  # 모든 전구를 N으로 만드는 경우
    nod += 1

    if lamp.count('Y') == 0:
        break

    if lamp[nod] == 'Y':
        count += 1

        for i in range(nod, len(lamp), nod + 1):
            if lamp[i] == 'N':
                lamp[i] = 'Y'

            else:
                lamp[i] = 'N'

    else:
        if nod >= len(lamp):
            nod = -1

print(count)
