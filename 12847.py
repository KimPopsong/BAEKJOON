def Calc(start, end):
    sumPay = 0

    for i in range(start, end):
        sumPay += day[i]

    return sumPay

n, m = map(int, input().split())

day = list(map(int, input().split()))

bestPay = 0

for i in range(n - m + 1):
    pay = Calc(i, i + m)

    if bestPay < pay:
        bestPay = pay

print(bestPay)
