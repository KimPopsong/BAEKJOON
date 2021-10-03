n = int(input())

number = []

for _ in range(n):
    number.append(int(input()))
number.sort()

maxStrike = 0

for num in number:
    strike = 0

    for i in range(num, num + 5):
        if number.count(i):
            strike += 1

    maxStrike = max(strike, maxStrike)

print(5 - maxStrike)
