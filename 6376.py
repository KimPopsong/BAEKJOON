def Fact(n):
    t = 1

    for i in range(n, 1, -1):
        t *= i

    return t

print('n e')
print('- -----------')

for i in range(0, 10):
    e = 0

    for j in range(0, i + 1):
        e += 1 / Fact(j)

    if i == 8:
        print("%d %.9f" % (i, e))

    else:
        print("%d %.10g"%(i, e))

