n = int(input())

calc = [0 for i in range(n + 1)]

for i in range(2, n + 1):
    calc[i] = calc[i - 1] + 1

    if i % 3 == 0 and calc[i] > calc[i // 3] + 1:
        calc[i] = calc[i // 3] + 1

    if i % 2 == 0 and calc[i] > calc[i // 2] + 1:
        calc[i] = calc[i // 2] + 1

print(calc[n])
