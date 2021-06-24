import sys

telNumber = int(input())
tel = list(map(int, sys.stdin.readline().rsplit()))

youngCost = 0
minCost = 0

for i in range(telNumber):
    youngCost += (tel[i] // 30 + 1) * 10
    minCost += (tel[i] // 60 + 1) * 15

if youngCost < minCost:
    print('Y', youngCost)

elif youngCost > minCost:
    print('M', minCost)

else:
    print('Y M', youngCost)
