times = [3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]

str1 = input()
str2 = input()

num = []

for i in range(len(str1)):
    num.append(times[ord(str1[i]) - 65])
    num.append(times[ord(str2[i]) - 65])

for t in range(len(str1) * 2, 2, -1):
    tp = []

    for i in range(t - 1):
        temp = num[i] + num[i + 1]

        if temp >= 10:
            temp -= 10

        tp.append(temp)

    num = tp

print(num[0], end = '')
print(num[1], end = '')
