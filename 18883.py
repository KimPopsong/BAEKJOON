n, m = map(int, input().split())

count = 1

for i in range(n):
    for j in range(m - 1):
        print(count, end = ' ')
        count += 1
        
    print(count)
    count += 1
