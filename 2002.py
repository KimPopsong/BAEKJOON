import sys
from collections import deque

carNumber = int(sys.stdin.readline().strip())

carIn = deque()
carOut = deque()

overtake = 0

for i in range(carNumber):
    car = sys.stdin.readline().strip()
    carIn.append(car)

for i in range(carNumber):
    car = sys.stdin.readline().strip()
    carOut.append(car)

nod = 0
for car in carOut:
    if car == carIn[nod]:
        nod += 1

    else:
        overtake += 1
        carIn.remove(car)

print(overtake)
