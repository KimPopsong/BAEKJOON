n = int(input())

count = 0

if n > 198:
    print(0)
    exit()

for i in range(0, 100):
    if n - i < 100:
        count += 1

print(count)
