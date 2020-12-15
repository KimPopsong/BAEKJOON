time = list(map(int, input().split()))
timeSpend = int(input())

time[2] += timeSpend
while time[2] >= 60:
    time[2] -= 60
    time[1] += 1

    if time[1] >= 60:
        time[1] -= 60
        time[0] += 1

    if time[0] >= 24:
        time[0] = 0

print(time[0], time[1], time[2])
