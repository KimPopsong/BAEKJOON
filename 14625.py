import sys

startHour, startMinute = map(int, sys.stdin.readline().split())
endHour, endMinute = map(int, sys.stdin.readline().split())
number = int(sys.stdin.readline().strip())
display = 0

while True:
    if int(startHour / 10) == number or startHour % 10 == number or int(startMinute / 10) == number or startMinute % 10 == number:
        display += 1

    if startHour == endHour and startMinute == endMinute:
        break

    startMinute += 1

    if startMinute == 60:
        startHour += 1
        startMinute = 0

print(display)
