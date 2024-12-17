import sys, heapq

nodeNumber, edgeNumber = map(int, sys.stdin.readline().rsplit())  # 정점의 개수, 간선의 개수
v1 = 0  # 반드시 거쳐야 하는 정점의 번호
v2 = 0

edges = dict()  # 간선. 방향이 없음
for i in range(edgeNumber):
    s, e, w = (map(int, sys.stdin.readline().rsplit()))  # 시작, 도착, 가중치

    if (s in edges.keys()):
        heapq.heappush(edges[s], [w, e])  # [가중치, 도착]

    else:
        edges[s] = []
        heapq.heappush(edges[s], [w, e])  # 가중치 낮은 순으로 입력

    if (e in edges.keys()):
        heapq.heappush(edges[e], [w, s])

    else:
        edges[e] = []
        heapq.heappush(edges[e], [w, s])

v1, v2 = map(int, sys.stdin.readline().rsplit())

graph = dict()

for nodeStart in [1, v1, v2]:
    search = []
    isVisit = [sys.maxsize for i in range(nodeNumber + 1)]

    heapq.heappush(search, (0, nodeStart))

    while (search):
        weight, node = heapq.heappop(search)

        if (weight >= isVisit[node]):  # isVisit 갱신
            continue

        else:
            isVisit[node] = weight

        if (node not in edges.keys()):  # 간선이 없는 경우
            continue

        for value in edges[node]:
            weight, endNode = value

            if (weight + isVisit[node] < isVisit[endNode]):
                heapq.heappush(search, (weight + isVisit[node], endNode))

    graph[nodeStart] = isVisit

minDistance = sys.maxsize  # 거리 계산
# 1번에서 v1, v2를 거쳐서 n번 정점으로 가는 방법은 4가지
minDistance = min(minDistance, (graph[1][v1] + graph[v1][v2] + graph[v2][nodeNumber]))  # 1 - v1 - v2 - N
minDistance = min(minDistance,
                  (graph[1][v1] + graph[v1][v2] + graph[v2][v1] + graph[v1][nodeNumber]))  # 1 - v1 - v2 - v1 - N
minDistance = min(minDistance, (graph[1][v2] + graph[v2][v1] + graph[v1][nodeNumber]))  # 1 - v2 - v1 - N
minDistance = min(minDistance,
                  (graph[1][v2] + graph[v2][v1] + graph[v1][v2] + graph[v2][nodeNumber]))  # 1 - v2 - v1 - v2 - N

if (minDistance == sys.maxsize):
    minDistance = -1

print(minDistance)
