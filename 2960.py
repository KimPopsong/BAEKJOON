t = list(map(int, input().split()))

eratosthenes = []
max = t[0]
for i in range(0, max + 1):
    eratosthenes.append(int(i))

eratosthenes[1] = 0
count = 0

i = 1
while True:
    i += 1

    k = 1
    while i * k <= max:
        if eratosthenes[k * i] == 0:
            k += 1
            continue

        else:
            count += 1
            if count == t[1]:
                print(eratosthenes[k * i])
                exit()

            eratosthenes[k * i] = 0
            k += 1
