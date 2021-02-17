number = list(map(int, input().split()))
number.sort()

flag = False

nod = 1

while True:
    count = 0

    for num in number:
        if nod % num == 0:
            count += 1

    if count >= 3:
        print(nod)
        break

    nod += 1
