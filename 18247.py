testCase = int(input())

for i in range(testCase):
    n, m = map(int, input().split())

    if n < 12 or m < 4:
        print(-1)
        continue

    print(11 * m + 4)
