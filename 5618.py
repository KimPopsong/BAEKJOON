n = int(input())

numbers = list(map(int, input().split()))

if n == 2:
    for i in range(1, min(numbers) + 1):
        if numbers[0] % i == 0 and numbers[1] % i == 0:
            print(i)
                
else:
    for i in range(1, min(numbers) + 1):
        if numbers[0] % i == 0 and numbers[1] % i == 0 and numbers[2] % i == 0:
            print(i)
