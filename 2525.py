time = list(map(int, input().split()))

timeSpend = int(input())

time[1] += timeSpend

while time[0] >= 24 or time[1] >= 60:
    if time[1] >= 60:
        time[1] -= 60
        time[0] += 1

    if time[0] >= 24:
        time[0] -= 24

print(time[0], time[1])
