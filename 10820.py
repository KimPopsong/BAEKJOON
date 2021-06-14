import sys

#lines = sys.stdin.readlines()

for line in sys.stdin:
    small = 0
    large = 0
    number = 0
    blank = -1
    print(line)
    for i in range(len(line)):
        if 97 <= ord(line[i]) <= 122:
            small += 1

        elif 65 <= ord(line[i]) <= 90:
            large += 1

        elif 48 <= ord(line[i]) <= 57:
            number += 1

        else:
            blank += 1

    print(small, large, number, blank)
