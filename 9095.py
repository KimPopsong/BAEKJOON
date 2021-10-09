def Factorial(n):
    num = 1

    for i in range(2, n + 1):
        num *= i

    return num


def Permutation(one, two, three):
    return Factorial(one + two + three) / Factorial(one) / Factorial(two) / Factorial(three)


number = []

for n in range(1, 11):
    count = 0

    for three in range(0, n // 3 + 1):
        for two in range(0, (n - 3 * three) // 2 + 1):
            count += Permutation(n - 3 * three - 2 * two, two, three)
    number.append(int(count))

for _ in range(int(input())):
    print(number[int(input()) - 1])
