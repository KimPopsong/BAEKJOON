testCase = int(input())

for i in range(testCase):
    flag = True

    n = input()

    if n == '2' or n == '3':
        print('NO')
        continue

    squareN = str(int(n) ** 2)

    for j in range(len(squareN) // 2):
        n = '0' + n

    for j in range(len(squareN) - 1, len(n) // 2 - 1, -1):
        if squareN[j] != n[j]:
            flag = False
            break

    if flag:
        print('YES')

    else:
        print('NO')
