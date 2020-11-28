import math

testCase = int(input())
candidates = list(map(int, input().split()))
mainObserver, subObserver = input().split()

mainObserver = int(mainObserver)
subObserver = int(subObserver)

count = 0

for i in range(testCase):
    candidates[i] -= mainObserver
    count += 1

    temp = math.ceil(candidates[i] / subObserver)

    if temp > 0:
        count += temp

print(count)
