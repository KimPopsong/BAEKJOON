import sys
from itertools import combinations

size, chickenMax = map(int, sys.stdin.readline().rsplit())

city = []  # 지도
house = []  # 집의 좌표
chicken = []  # 치킨 집의 좌표
minChickenDistance = sys.maxsize  # 도시의 치킨 거리

for i in range(size):  # 지도 입력
    city.append(list(map(int, sys.stdin.readline().rsplit())))

for r in range(size):
    for c in range(size):
        if (city[r][c] == 1):  # 집
            house.append([r, c])

        elif (city[r][c] == 2):  # 치킨 집
            chicken.append([r, c])

for comb in combinations(chicken, chickenMax):
    chickenDistance = 0

    for r, c in house:
        distance = sys.maxsize

        for cr, cc in comb:
            distance = min(distance, abs(r - cr) + abs(c - cc))

        chickenDistance += distance
    minChickenDistance = min(minChickenDistance, chickenDistance)

print(minChickenDistance)
