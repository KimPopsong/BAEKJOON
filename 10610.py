n = input()
s = []

for i in range(len(n)):
    s.append(n[i])

s.sort(reverse=True)

n = ''

for num in s:
    n += num

if int(n) % 30 == 0:
    print(n)

else:
    print(-1)
