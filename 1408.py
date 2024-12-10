import sys

nowTime = list(map(int, sys.stdin.readline().rsplit(":")))
missionTime = list(map(int, sys.stdin.readline().rsplit(":")))

nowTime60 = 3600 * nowTime[0] + 60 * nowTime[1] + nowTime[2]
missionTime60 = 3600 * missionTime[0] + 60 * missionTime[1] + missionTime[2]

timeLeft = missionTime60 - nowTime60

if (timeLeft < 0):  # 남은 시간이 음수라면
    timeLeft += 24 * 3600

hour = str(timeLeft // 3600)
minute = str((timeLeft % 3600) // 60)
seconds = str(timeLeft % 60)

if (len(hour) < 2):
    hour = "0" + hour

if (len(minute) < 2):
    minute = "0" + minute

if (len(seconds) < 2):
    seconds = "0" + seconds

print(hour + ":" + minute + ":" + seconds)
