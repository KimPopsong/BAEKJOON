import sys

testCase = int(sys.stdin.readline().rstrip())

for case in range(testCase):
    answer = 1

    wearable = dict()
    wearableNumber = int(sys.stdin.readline().rstrip())

    for i in range(wearableNumber):
        wear, type = sys.stdin.readline().rsplit()

        if (type in wearable):
            wearable[type].append(wear)

        else:
            wearable[type] = [wear]

    for k, i in wearable.items():
        answer *= len(wearable[k]) + 1

    answer -= 1

    print(answer)
