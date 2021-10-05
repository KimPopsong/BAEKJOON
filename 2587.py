number = []

for _ in range(5):
    number.append(int(input()))

number.sort()

print(sum(number) // 5)
print(number[2])
