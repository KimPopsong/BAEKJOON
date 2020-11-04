import sys

number = int(sys.stdin.readline())

house = sys.stdin.readline().split()
house = [int(i) for i in house]
house.sort()

smallest = 0
left = 0
right = 0

for i in range(1, number):
    if house[0] == house[i]:
        continue

    else:
        smallest += house[i] - house[0]
place = house[0]
beforeLocation = house[0]

i = 1

if house[0] == house[-1]:
    print(place)
    sys.exit()

while i < number:
    while house[i - 1] == house[i]:
        if i < number - 1:
            i += 1

        else:
            break

    left = i
    right = number - i

    temp = smallest
    temp += (house[i] - beforeLocation) * left
    temp -= (house[i] - beforeLocation) * right

    if temp < smallest:
        smallest = temp
        place = house[i]

    beforeLocation = house[i]
    i += 1

print(place)
