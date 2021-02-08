n = int(input())

singer = 1
count = 0

while True:
    if n <= 0:
        break

    if n < singer:
        singer = 1

    n -= singer
    singer += 1
    count += 1

print(count)
