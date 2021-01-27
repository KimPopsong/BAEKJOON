def PrintFront(count):
    print('Scenario #', end = '')
    print(count, end = '')
    print(': ', end = '')

def PrintRear(sumInt):
    print(sumInt)
    print()

testCase = int(input())

count = 1

for i in range(testCase):
    n, m = map(int, input().split())

    PrintFront(count)
    count += 1

    sumInt = 0
    start = n
    end = m

    if n < 0 and m > 0:
        if abs(n) > abs(m):
            end = m * - 1 - 1

        else:
            start = n * - 1 + 1

    countNum = (end - start + 1)

    if countNum % 2 == 0:
        sumInt = (start + end) * (countNum // 2)

    else:
        sumInt = (start + end) * (countNum // 2) + (start + end) // 2

    PrintRear(sumInt)
