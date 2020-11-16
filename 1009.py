testcase = int(input())

number = []

for i in range(testcase):
    t = input().split()
    t = [int (i) for i in t]
    n = t[0] % 10

    for i in range(t[1] - 1):
        n = (n * t[0]) % 10

    if n == 0:
        n = 10
    number.append(n)

for n in number:
    print(n)
