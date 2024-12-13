import sys

global fib


def fibonacci(root):
    global fib

    if (root % 2 == 1):  # 홀수
        fib1 = root // 2 + 1
        fib2 = root // 2

        if (fib1 not in fib):  # 없다면 구하기
            fib[fib1] = fibonacci(fib1)

        if (fib2 not in fib):
            fib[fib2] = fibonacci(fib2)

        return (fib[fib1] ** 2 + fib[fib2] ** 2) % 1000000007

    else:  # 짝수
        fib1 = root // 2 + 1
        fib2 = root // 2 - 1

        if (fib1 not in fib):  # 없다면 구하기
            fib[fib1] = fibonacci(fib1)

        if (fib2 not in fib):
            fib[fib2] = fibonacci(fib2)

        return (fib[fib1] ** 2 - fib[fib2] ** 2) % 1000000007


n = int(sys.stdin.readline().rstrip())

fib = dict()

fib[0] = 0
fib[1] = 1
fib[2] = 1
fib[3] = 2
fib[4] = 3
fib[5] = 5

print(fibonacci(n))
