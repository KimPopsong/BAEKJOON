time = int(input())

buttonA = 0
buttonB = 0
buttonC = 0

while time >= 10:
    if time >= 300:
        buttonA += 1
        time -= 300

    elif time >= 60:
        buttonB += 1
        time -= 60

    elif time >= 10:
        buttonC += 1
        time -= 10

if not time:
    print(buttonA, buttonB, buttonC)

else:
    print(-1)
