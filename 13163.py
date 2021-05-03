testCase = int(input())

for i in range(testCase):
    name = list(input().split())

    print('god', end = '')
    for j in range(len(name)):
        if j == 0:
            continue

        else:
            print(name[j], end = '')
    print()
