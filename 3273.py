n = int(input())
numbers = list(map(int, input().split()))
numbers.sort()
value = int(input())

count = 0

for i in range(0, n - 1):
    for j in range(i + 1, n):
        temp = numbers[i] + numbers[j]
        
        if temp == value:
            count += 1
            
        elif temp > value:
            break

print(count)
