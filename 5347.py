n = int(input())

for i in range(n):
    n1, n2 = map(int, input().split())

    cd = []

    j = 2
    while True:
        if min(n1, n2) < j:
            break

        if n1 % j == 0 and n2 % j == 0:
            cd.append(j)
            n1 //= j
            n2 //= j
            j = 2

        else:
            j += 1

    GCD = 1

    for k in cd:
        GCD *= k

    print(GCD * n1 * n2)
