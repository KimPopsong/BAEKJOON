import sys, heapq

lectureNumber = int(sys.stdin.readline().rstrip())

lectureList = []
for i in range(lectureNumber):
    lectureList.append(list(map(int, sys.stdin.readline().rsplit())))
lectureList.sort()

rooms = []
heapq.heappush(rooms, lectureList[0][1])

for lecture in range(1, lectureNumber):
    start, end = lectureList[lecture]

    if (rooms[0] <= start):
        heapq.heappop(rooms)
    heapq.heappush(rooms, end)

print(len(rooms))
