def Decide(a, b, c):
    if a == b:
        return c

    elif a == c:
        return b

    else:
        return a

first = input().split()
second = input().split()
third = input().split()

x = Decide(first[0], second[0], third[0])
y = Decide(first[1], second[1], third[1])

print(x, y)
