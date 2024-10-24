import sys, math

opinionNumber = int(sys.stdin.readline().rstrip())  # 의견의 개수

opinions = []
opinionAvg = 0

if (opinionNumber == 0):
    print(0)

    exit()

for i in range(opinionNumber):
    opinions.append(int(sys.stdin.readline().rstrip()))
opinions.sort()

notDeflect = math.floor(opinionNumber / 100 * 15 + 0.5)  # 절사평균 30% 반영

for i in range(notDeflect, opinionNumber - notDeflect):
    opinionAvg += opinions[i]
opinionAvg /= opinionNumber - (2 * notDeflect)
opinionAvg = math.floor(opinionAvg + 0.5)  # 반올림

print(opinionAvg)
