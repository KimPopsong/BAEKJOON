problemN = int(input())

s = input()

b = 0
r = 0

flag = ''

if s[0] == 'B':
    flag = 'B'
    b += 1

else:
    flag = 'R'
    r += 1

for i in range(len(s)):
    nod = s[i]

    if nod == flag:
        continue

    else:
        flag = nod

        if s[i] == 'B':
            b += 1

        else:
            r += 1

if b >= r:
    print(r + 1)

else:
    print(b + 1)
