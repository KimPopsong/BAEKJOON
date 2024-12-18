import sys, heapq, copy

cityNumber = int(sys.stdin.readline().rstrip())  # 도시의 개수
busNumber = int(sys.stdin.readline().rstrip())  # 버스의 개수
minPrice = dict()  # { 시작도시 : [도시별 비용] }

buses = dict()  # { 시작도시 : [비용, 도착도시] }
for i in range(1, cityNumber + 1):
    buses[i] = []
    minPrice[i] = [sys.maxsize for i in range(cityNumber + 1)]

for i in range(busNumber):  # 버스 경로 입력
    start, end, price = map(int, sys.stdin.readline().rsplit())

    heapq.heappush(buses[start], [price, end])

for i in range(1, cityNumber + 1):
    minPrice[i][i] = 0

for startNode in range(1, cityNumber + 1):  # i번 도시부터 최소 거리 계산
    search = []

    heapq.heappush(search, [0, startNode])

    while (search):
        price, middleNode = heapq.heappop(search)

        for end in buses[middleNode]:
            endPrice, endNode = end

            if (price + endPrice < minPrice[startNode][endNode]):
                heapq.heappush(search, [price + endPrice, endNode])
                minPrice[startNode][endNode] = price + endPrice

for k in range(1, cityNumber + 1):
    for i in range(1, cityNumber + 1):
        if (minPrice[k][i] == sys.maxsize):
            print(0, end=" ")

        else:
            print(minPrice[k][i], end=" ")
    print()
