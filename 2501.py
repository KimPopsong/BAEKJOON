num, time = map(int, input().split())

count = 0
for i in range(1, num + 1):
    if num % i == 0:
        count += 1

        if count == time:
            print(i)
            exit()

print(0)
