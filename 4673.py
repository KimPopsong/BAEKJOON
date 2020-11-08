def SumNum(num):
    sum = num + num % 10

    while num > 0:
        sum += int((num / 10) % 10)
        num = int(num / 10)

    return sum

number = []

for i in range(1, 10001):
    number.append(i)

for i in range(1, 10001):
    x = SumNum(i)

    if number.count(x) > 0:
        number.remove(x)

for i in number:
    print(i)
