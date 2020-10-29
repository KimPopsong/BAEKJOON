k = input()
num = []

for i in range(0, len(k)):
    num.append((k[i]))

num.sort(reverse=True)

for i in range(0, len(num)):
    print(num[i], end='')
