import sys

sys.setrecursionlimit(15000)  # 재귀함수 제한 해제

def dfs(ii, jj):  # BFS Algorithm
    global checkedLand

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    for c in range(4):
        x = ii + dx[c]
        y = jj + dy[c]

        if 0 <= x <= size - 1 and 0 <= y <= size - 1:  # land 범위 안이라면
            if land[x][y] != 0:  # 침수되지 않았다면
                if not checkedLand[x][y]:  # 가보지 않았다면
                    checkedLand[x][y] = True  # 검사된 지역에 추가
                    dfs(x, y)  # DFS로 검사

size = int(sys.stdin.readline().rstrip())

land = []

minHeight = 0  # 최소 높이
maxHeight = 100  # 최대 높이

maxSafeArea = 1  # 안전한 영역의 최대 개수

for i in range(size):
    land.append(list(map(int, sys.stdin.readline().rsplit())))

minHeight = min(map(min, land))
maxHeight = max(map(max, land))

for height in range(minHeight, maxHeight):  # 최소 높이 이상, 최대 높이 미만
    countSafeArea = 0  # 현재 물 높이에서 안전한 영역의 개수

    for i in range(size):
        for j in range(size):
            if land[i][j] <= height:  # 높이가 비의 양보다 작거나 같다면
                land[i][j] = 0  # 침수

    checkedLand = [[False for i in range(size)] for i in range(size)]  # BFS로 검사된 지역들

    for i in range(size):
        for j in range(size):
            if land[i][j] != 0:  # 침수되지 않았고
                if not checkedLand[i][j]:  # 확인되지 않았다면
                    checkedLand[i][j] = True  # 검사된 지역에 추가
                    dfs(i, j)  # DFS로 검사
                    countSafeArea += 1

    maxSafeArea = max(maxSafeArea, countSafeArea)

print(maxSafeArea)
