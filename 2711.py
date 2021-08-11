import sys

for _ in range(int(sys.stdin.readline().rstrip())):
    typoLocation, typoString = sys.stdin.readline().rsplit()

    typoLocation = int(typoLocation) - 1

    for i in range(len(typoString)):
        if i == typoLocation:
            continue

        else:
            print(typoString[i], end = '')
    print()
