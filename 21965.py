length = int(input())

isMountain = list(map(int, input().split()))

nod = 0
flag = True

while nod < length - 1:
    if isMountain[nod] >= isMountain[nod + 1]:
        break

    nod += 1

while nod < length - 1:
    if isMountain[nod] <= isMountain[nod + 1]:
        flag = False
        break

    nod += 1

if flag:
    print('YES')

else:
    print('NO')
