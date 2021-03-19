import sys

cityNumber = int(sys.stdin.readline().rstrip())

roadLength = list(map(int, sys.stdin.readline().rsplit()))

oilPrice = list(map(int, sys.stdin.readline().rsplit()))

oilSum = 0
lowOilPrice = oilPrice[0]
location = 0

while True:
    if location >= cityNumber - 1:
        break

    oilSum += lowOilPrice * roadLength[location]
    location += 1

    if lowOilPrice > oilPrice[location]:
        lowOilPrice = oilPrice[location]

print(oilSum)
