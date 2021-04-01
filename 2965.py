a, b, c = map(int, input().split())

count = 0

while True:
    first = b - a
    second = c - b

    if second == 1 and first == 1:
        break

    if second > first:
        a = b
        b = c - 1

    else:
        c = b
        b = a + 1

    count += 1

print(count)
