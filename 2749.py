n = int(input())

pisano = 1500000

fib = [0 for i in range(pisano + 1)]
fib[0] = 0
fib[1] = 1

for i in range(2, pisano):
    fib[i] = (fib[i - 1] + fib[i - 2]) % 1000000

print(fib[n % pisano])
