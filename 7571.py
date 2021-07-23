import sys

size, dotNumber = map(int, sys.stdin.readline().rsplit())  # 격자의 한 변의 길이, 점의 개수

dot = []  # 점의 list

xList = []  # 점의 x좌표만 모아둔 list
yList = []  # 점의 y좌표만 모아둔 list

xMedian = 0  # 점의 x좌표의 중앙값
yMedian = 0  # 점의 y좌표의 중앙값

moveCount = 0  # 움직인 횟수

for i in range(dotNumber):
    temp = list(map(int, sys.stdin.readline().rsplit()))  # 점의 좌표를 입력받고

    xList.append(temp[0])  # x값만 추출
    yList.append(temp[1])  # y값만 추출

    dot.append(temp)  # 점의 좌표 저장

xList.sort()  # 크기순 정렬
yList.sort()  # 크기순 정렬

xMedian = xList[dotNumber // 2]  # x좌표의 중앙값
yMedian = yList[dotNumber // 2]  # y좌표의 중앙값

for d in dot:
    moveCount += abs(xMedian - d[0]) + abs(yMedian - d[1])  # 움직인 횟수 구하기

print(moveCount)
