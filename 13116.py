for _ in range(int(input())):
    n, m = map(int, input().split())

    biggestCommonNumber = 1

    treeN = []
    treeM = []

    while n >= 1:
        treeN.append(n)

        if n % 2:
            n -= 1
            n //= 2

        else:
            n //= 2

    while m >= 1:
        treeM.append(m)

        if m % 2:
            m -= 1
            m //= 2

        else:
            m //= 2

    treeN.sort()
    treeM.sort()

    for i in range(min(len(treeN), len(treeM))):
        if treeN[i] == treeM[i]:
            biggestCommonNumber = treeN[i]

        else:
            break

    print(biggestCommonNumber * 10)
