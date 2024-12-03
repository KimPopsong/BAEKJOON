import sys

testCase = int(sys.stdin.readline().rstrip())

for case in range(testCase):
    sounds = list(sys.stdin.readline().rsplit())

    soundSet = set()

    while (True):
        question = sys.stdin.readline().split()

        if (question[0] == "what"):
            break

        else:  # 동물 울음소리 저장
            soundSet.add(question[2])

    for i in range(len(sounds) - 1, - 1, -1):
        if (sounds[i] in soundSet):
            sounds.pop(i)

    for s in sounds:
        print(s, end=" ")
    print()
