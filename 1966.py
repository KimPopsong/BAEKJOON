import sys

testCase = int(input())

for i in range(testCase):
    docuNum, wantToKnow = map(int, input().split())
    document = list(map(int, sys.stdin.readline().rsplit()))

    count = 0
    while True:
        j = 0
        while j < docuNum:
            if document[0] < document[j]:
                document.append(document[0])
                document.pop(0)
                j = 0

                if wantToKnow == 0:
                    wantToKnow = docuNum - 1

                else:
                    wantToKnow -= 1

            else:
                j += 1

        count += 1
        document.pop(0)
        docuNum -= 1

        if wantToKnow == 0:
            break

        else:
            wantToKnow -= 1

    print(count)
