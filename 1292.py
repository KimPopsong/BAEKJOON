start, end = map(int, input().split())

sumNum = 0
i = 0
count = 0
for k in range(end + 1):
    i += 1

    for ii in range(i):
        count += 1

        if start <= count <= end:
            sumNum += i

print(sumNum)
