def Check(t):
    global count

    t = str(t)

    flag = True

    for i in range(len(t) - 1, -1, -1):
        if t[i] != '0':
            break

        else:
            count += 1


n = int(input())

nod = 1

count = 0

for i in range(2, n + 1):
    nod *= i

Check(nod)

print(count)
