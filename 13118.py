human = list(map(int, input().split()))

x, y, r = map(int, input().split())

if human.count(x) == 0:
    print(0)

else:
    print(human.index(x) + 1)
