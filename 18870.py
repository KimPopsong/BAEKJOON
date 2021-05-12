import sys

positionNumber = int(sys.stdin.readline().rstrip())

position = list(map(int, sys.stdin.readline().rsplit()))

positionSorted = list(sorted(set(position)))

positionDictionary = {positionSorted[i] : i for i in range(len(positionSorted))}

for num in position:
    print(positionDictionary[num], end = ' ')
