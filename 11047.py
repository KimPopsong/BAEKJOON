n = input()

n = n.split(' ')

k = int(n[1])
n = int(n[0])

money = []

for i in range(0, n):
    money.append(int(input()))

count = 0
i = n - 1

while True:
    if k == 0:
        break

    elif k - money[i] >= 0:
        count += 1
        k -= money[i]

    else:
        i -= 1

print(count)
