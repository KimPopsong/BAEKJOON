fib = [0] * 10001
fib[0], fib[1] = 1, 1

for i in range(2, 10000):
    fib[i] = fib[i - 1] + fib[i - 2]

testCase = int(input())

for i in range(1, testCase + 1):
    p, q = map(int, input().split())

    print('Case #%d' %i, end = '')
    print(':', fib[p - 1] % q)
