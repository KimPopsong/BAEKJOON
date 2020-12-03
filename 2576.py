num = []

for i in range(7):
    n = int(input())

    if n % 2 == 1:
        num.append(n)

if len(num):
    num.sort()
    print(sum(num))
    print(num[0])

else:
    print(-1)
