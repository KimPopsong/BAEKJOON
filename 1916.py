import sys
from collections import deque

cityNumber = int(sys.stdin.readline().rstrip())
busNumber = int(sys.stdin.readline().rstrip())

cities = [[sys.maxsize for i in range(cityNumber + 1)] for i in range(cityNumber + 1)]

for i in range(busNumber):
    city1, city2, price = map(int, sys.stdin.readline().rstrip().split())

    if (cities[city1][city2] > price):
        cities[city1][city2] = price

start, end = map(int, sys.stdin.readline().split())

for i in range(cityNumber + 1):
    cities[i][i] = 0

bfs = deque()
isVisit = [False for i in range(cityNumber + 1)]

bfs.append(start)
isVisit[start] = True

while (bfs):
    city = bfs.popleft()

    for i in range(1, cityNumber + 1):
        if (cities[city][i] != sys.maxsize):  # 연결되어있고
            if (cities[start][city] + cities[city][i] < cities[start][i]):  # 요금 비교
                cities[start][i] = cities[start][city] + cities[city][i]  # 요금이 갱신되었다면
                bfs.append(i)

            if (isVisit[i] == False):  # 방문한적이 없다면
                bfs.append(i)
                isVisit[i] = True

print(cities[start][end])
