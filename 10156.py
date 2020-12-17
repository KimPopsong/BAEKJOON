price, number, money = map(int, input().split())

need = price * number - money

if need <= 0:
    print(0)

else:
    print(need)
