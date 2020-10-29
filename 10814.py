n = int(input())

list = []

for i in range(n):
    k = input()

    k = k.split(' ')
    k[0] = int(k[0])

    list.append(k)

list = sorted(list, key = lambda x : x[0])

for i in range(n):
    print(list[i][0], end=' ')
    print(list[i][1])
