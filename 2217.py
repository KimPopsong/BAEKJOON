ropeNumber = int(input())
ropes = []

sum = 0

for i in range(ropeNumber):
    ropes.append(int(input()))

ropes.sort()

for i in range(ropeNumber):
    temp = ropes[i] * (ropeNumber - i)

    if temp > sum:
        sum = temp

print(sum)
