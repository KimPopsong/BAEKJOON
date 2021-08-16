fib = [1, 1]

nod = 2
while True:
    fib.append(fib[nod - 1] + fib[nod - 2])

    if fib[-1] >= 1000000000:
        break

    nod += 1

for _ in range(int(input())):
    target = int(input())

    nod = 0
    answer = []

    for i in range(len(fib)):
        if fib[i] < target:
            continue

        elif fib[i] == target:
            nod = -1
            break

        else:
            nod = i - 1
            break

    if nod == -1:
        print(target)
        continue

    for i in range(nod, -1, -1):
        if target - fib[i] >= 0:
            answer.append(fib[i])
            target -= fib[i]

    answer.sort()

    for ans in answer:
        print(ans, end = ' ')
    print()
