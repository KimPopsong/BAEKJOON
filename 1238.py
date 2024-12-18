import sys, heapq

studentNumber, roadNumber, party = map(int, sys.stdin.readline().rsplit())  # 학생의 수, 도로의 수, 파티가 열리는 장소
road = dict()  # { 시작 : [시간, 도착] }
minTime = dict()
answer = 0

for i in range(1, studentNumber + 1):  # road 초기화
    road[i] = []
    minTime[i] = [sys.maxsize for i in range(studentNumber + 1)]

for i in range(roadNumber):
    start, end, time = map(int, sys.stdin.readline().rsplit())

    heapq.heappush(road[start], [time, end])

for i in range(1, studentNumber + 1):
    minTime[i][i] = 0

for startNode in range(1, studentNumber + 1):  # i번 도시부터 최소 거리 계산
    search = []

    heapq.heappush(search, [0, startNode])

    while (search):
        time, middleNode = heapq.heappop(search)

        for end in road[middleNode]:
            spendTime, endNode = end

            if (time + spendTime < minTime[startNode][endNode]):
                heapq.heappush(search, [time + spendTime, endNode])
                minTime[startNode][endNode] = time + spendTime

for i in range(1, studentNumber + 1):
    time = minTime[i][party] + minTime[party][i]  # 왕복 거리
    answer = max(answer, time)

print(answer)
