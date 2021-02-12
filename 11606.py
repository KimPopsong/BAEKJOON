import sys

testCase, highest = map(int, sys.stdin.readline().rsplit())

safeFloor = 1
dangerFloor = highest

for i in range(testCase):
    experiment = list(sys.stdin.readline().rsplit())

    if experiment[1] == 'SAFE':
        if int(experiment[0]) > safeFloor:
            safeFloor = int(experiment[0])

    else:
        if int(experiment[0]) < dangerFloor:
            dangerFloor = int(experiment[0])

print(safeFloor + 1, dangerFloor - 1)
