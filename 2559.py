import sys

day, sumDay = map(int, sys.stdin.readline().split())  # 측정한 날짜, 연속적인 날짜

temperature = list(map(int, sys.stdin.readline().split()))  # 측정한 기온

highestTemperature = sum(temperature[0:sumDay])

temp = highestTemperature
for i in range(1, day - sumDay + 1):
    temp -= temperature[i - 1]
    temp += temperature[i + sumDay - 1]

    if (temp > highestTemperature):
        highestTemperature = temp

print(highestTemperature)
