def getPower(s, e, minP):
    global programmer

    return (e - s - 1) * minP


programmerNumber = int(input())
programmer = list(map(int, input().split()))

maxPower = 0

start = 0
end = programmerNumber - 1

while start < end:
    power = getPower(start, end, min(programmer[start], programmer[end]))

    if power > maxPower:
        maxPower = power

    if programmer[start] < programmer[end]:
        start += 1

    else:
        end -= 1

print(maxPower)
