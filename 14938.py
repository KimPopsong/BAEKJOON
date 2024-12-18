import sys, heapq

nodeNumber, searchRange, roadNumber = map(int, sys.stdin.readline().rsplit())  # 지역의 개수, 수색 범위, 길의 개수
nodeItem = [0] + list(map(int, sys.stdin.readline().split()))  # 아이템 목록
maxItem = 0  # 최대로 먹을 수 있는 아이템

roads = dict()  # { 지역1 : [거리, 지역2] }

distance = dict()  # 노드별 거리

for i in range(1, nodeNumber + 1):  # 초기화
    roads[i] = []
    distance[i] = [sys.maxsize for i in range(nodeNumber + 1)]
    distance[i][i] = 0

for i in range(roadNumber):  # 길은 양방향
    node1, node2, dis = map(int, sys.stdin.readline().split())

    heapq.heappush(roads[node1], [dis, node2])
    heapq.heappush(roads[node2], [dis, node1])

for startNode in range(1, nodeNumber + 1):
    search = []

    heapq.heappush(search, [0, startNode])

    while (search):
        dis, node = heapq.heappop(search)

        for end in roads[node]:
            endDist, endNode = end

            if (dis + endDist < distance[startNode][endNode]):
                heapq.heappush(search, [dis + endDist, endNode])
                distance[startNode][endNode] = dis + endDist

for i in range(1, nodeNumber + 1):
    itemEat = 0

    for j in range(1, nodeNumber + 1):
        if (distance[i][j] <= searchRange):
            itemEat += nodeItem[j]

    maxItem = max(maxItem, itemEat)

print(maxItem)
