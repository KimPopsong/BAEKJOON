number = int(input())
humans = list(map(int, input().split()))

humans.sort()

sumTime = 0
accume = 0

for human in humans:
    accume += human
    sumTime += accume

print(sumTime)
