testCase = int(input())

for i in range(testCase):
    n = int(input())

    number = 1
    for j in range(n, 1, -1):
        number *= j

        if number % 10 == 0:
            number //= 10

    print(number % 10)
