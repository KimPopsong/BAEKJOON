n = int(input())

magnet = list(map(int, input().strip()))

for i in range(len(magnet) - 1):
    if magnet[i] == magnet[i + 1]:
        print('No')
        exit()

print('Yes')
