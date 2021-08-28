count = 1

for _ in range(int(input())):
    string = input().split()

    print('Case #' + str(count) + ':', end = ' ')
    for s in range(len(string) - 1, -1, -1):
        print(string[s], end = ' ')
    print()

    count += 1
