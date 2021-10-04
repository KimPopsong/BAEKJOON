import sys

for line in sys.stdin:
    isJollyJumper = list(map(int, line.split()))

    jolly = [False] * isJollyJumper[0]
    jolly[0] = True

    for i in range(1, isJollyJumper[0]):
        if abs(isJollyJumper[i] - isJollyJumper[i + 1]) < isJollyJumper[0]:
            jolly[abs(isJollyJumper[i] - isJollyJumper[i + 1])] = True

    if jolly.count(False):
        print('Not jolly')

    else:
        print('Jolly')
