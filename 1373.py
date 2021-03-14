n = input()

while len(n) % 3 != 0:
    n = '0' + n

sumN = 0
nod = 4
count = 1

octNum = ''

for i in range(len(n)):
    sumN += int(n[i]) * nod
    nod //= 2
    count += 1

    if count > 3:
        print(sumN, end = '')
        sumN = 0
        count = 1
        nod = 4
