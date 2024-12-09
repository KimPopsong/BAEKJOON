import sys, copy

size = int(sys.stdin.readline().rstrip())

table = []

for _ in range(size):
    table.append(list(map(int, sys.stdin.readline().split())))

dpMax = [table[0][0], table[0][1], table[0][2]]  # 최대 숫자를 구하는 dp
dpMin = [table[0][0], table[0][1], table[0][2]]  # 최소 숫자를 구하는 dp

for i in range(1, size):
    dpTemp = []

    dpTemp.append(table[i][0] + max(dpMax[0], dpMax[1]))
    dpTemp.append(table[i][1] + max(max(dpMax[0], dpMax[1]), dpMax[2]))
    dpTemp.append(table[i][2] + max(dpMax[1], dpMax[2]))

    dpMax = copy.deepcopy(dpTemp)

for i in range(1, size):
    dpTemp = []

    dpTemp.append(table[i][0] + min(dpMin[0], dpMin[1]))
    dpTemp.append(table[i][1] + min(min(dpMin[0], dpMin[1]), dpMin[2]))
    dpTemp.append(table[i][2] + min(dpMin[1], dpMin[2]))

    dpMin = copy.deepcopy(dpTemp)

print(max(dpMax), min(dpMin))
