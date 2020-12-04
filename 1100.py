count = 0

for i in range(8):
    s = input()

    for j in range(8):
        if i % 2 == 0:
            if j % 2 == 0 and s[j] == 'F':
                count += 1

        else:
            if j % 2 == 1 and s[j] == 'F':
                count += 1

print(count)
