import sys
from collections import deque

ladderNumber, snakeNumber = map(int, sys.stdin.readline().rsplit())  # 사다리와 뱀의 개수

ladders = []  # 만나면 위로 올라감
snakes = []  # 만나면 내려감

for i in range(ladderNumber):
    ladders.append(list(map(int, sys.stdin.readline().rsplit())))
ladders.sort()

for i in range(snakeNumber):
    snakes.append(list(map(int, sys.stdin.readline().rsplit())))
snakes.sort()

time = 0  # 주사위를 굴린 횟수

bfs = deque()
bfs.append(1)

isVisit = [False for _ in range(101)]
isVisit[1] = True

while (len(bfs)):
    time += 1

    tempBFS = deque(bfs)
    bfs.clear()

    while (len(tempBFS)):
        location = tempBFS.pop()

        location1 = location + 1  # 1칸 앞
        location6 = location + 6  # 6칸 앞

        for ladder in ladders:  # 사다리 탑승
            if (location1 <= ladder[0] <= location6):  # 사다리가 범위 안에 있고
                if (isVisit[ladder[0]] == False):  # 방문한적이 없다면
                    if (isVisit[ladder[1]] == False):  # 도착 지점도 방문한적이 없다면
                        bfs.append(ladder[1])  # 탑승
                        isVisit[ladder[1]] = True  # 하차지점

                    isVisit[ladder[0]] = True  # 탑승지점

            elif (location6 < ladder[0]):  # 최적화
                break

        for snake in snakes:  # 뱀 탑승
            if (location1 <= snake[0] <= location6):  # 뱀이 범위 안에 있고
                if (isVisit[snake[0]] == False):  # 방문한적이 없다면
                    if (isVisit[snake[1]] == False):  # 도착 지점도 방문한적이 없다면
                        bfs.append(snake[1])  # 탑승
                        isVisit[snake[1]] = True

                    isVisit[snake[0]] = True

            elif (location6 < snake[0]):
                break

        for location in range(location1, location6 + 1):  # 나머지 연산
            if (location >= 100):  # 도착할 경우
                print(time)
                bfs.clear()
                tempBFS.clear()

                break

            elif (isVisit[location] == False):  # 사다리나 뱀을 타지않고 걸어가기
                bfs.append(location)
                isVisit[location] = True
