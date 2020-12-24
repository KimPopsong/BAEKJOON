case = int(input())

for i in range(case):
    n = int(input())

    room = [True] * (n + 1)

    for j in range(2, n + 1):
        node = 1

        while True:
            if node * j > n:
                break

            if room[node * j]:
                room[node * j] = False

            else:
                room[node * j] = True

            node += 1

    count = 0
    for r in room:
        if r:
            count += 1

    print(count - 1)
