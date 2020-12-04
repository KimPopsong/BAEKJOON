n = int(input())
number = []

for i in range(n):
    s = int(input())

    if not s:  # if s == 0
        number.pop()

    else:
        number.append(s)

print(sum(number))
