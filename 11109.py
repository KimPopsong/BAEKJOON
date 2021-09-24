for _ in range(int(input())):
    developTime, runCount, serialRunningTime, parallelRunningTime = map(int, input().split())

    parallelTime = developTime + runCount * parallelRunningTime
    serialTime = runCount * serialRunningTime

    if parallelTime > serialTime:
        print('do not parallelize')

    elif parallelTime < serialTime:
        print('parallelize')

    else:
        print('does not matter')
