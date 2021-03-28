while True:
    n = input()

    if n == '0':
        break

    digitalRoot = 0

    while True:
        for i in range(len(n)):
            digitalRoot += int(n[i])

        if digitalRoot >= 10:
            n = str(digitalRoot)
            digitalRoot = 0

        else:
            break

    print(digitalRoot)
