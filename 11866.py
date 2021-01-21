n, k = map(int, input().split())

josephus = [i for i in range(0, n + 1)]
answer = []

nod = 1

for i in range(n):
    count = 0

    while True:
        if nod > n:
            nod = 1

        elif josephus[nod] == 0:
            nod += 1

        else:
            count += 1

            if count == k:
                answer.append(josephus[nod])
                josephus[nod] = 0
                break

            else:
                nod += 1

print('<', end='')
for i in range(len(answer)):
    print(answer[i], end='')

    if i == len(answer) - 1:
        break

    print(',', end=' ')

print('>')
