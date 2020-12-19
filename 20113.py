n = int(input())

t = list(map(int, input().split()))

t.sort()

count = 0
imposter = 0
flag = 0

for i in t:
    if i == 0:
        continue

    c = t.count(i)

    if c > count:
        flag = 0
        imposter = i
        count = c

    elif c == count and i != imposter:
        flag = 1

if flag:
    print('skipped')

else:
    print(imposter)
