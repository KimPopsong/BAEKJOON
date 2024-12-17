import sys, heapq

nodeNumber, edgeNumber = map(int, sys.stdin.readline().rsplit())  # 정점의 개수, 간선의 개수
nodeStart = int(sys.stdin.readline().rstrip())  # 시작 정점의 번호

edges = dict()  # 간선
for i in range(edgeNumber):
    s, e, w = (map(int, sys.stdin.readline().rsplit()))  # 시작, 도착, 가중치

    if (s in edges.keys()):
        heapq.heappush(edges[s], [w, e])  # [가중치, 도착]

    else:
        edges[s] = []
        heapq.heappush(edges[s], [w, e])  # 가중치 낮은 순으로 입력

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

for i in range(1, nodeNumber + 1):
    if (isVisit[i] == sys.maxsize):
        print("INF")

    else:
        print(isVisit[i])
