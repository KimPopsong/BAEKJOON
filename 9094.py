for _ in range(int(input())):
    n, m = map(int, input().split())

    count = 0

    for b in range(n):
        for a in range(1, b):
            if (a ** 2 + b ** 2 + m) % (a * b) == 0:
                count += 1

    print(count)
