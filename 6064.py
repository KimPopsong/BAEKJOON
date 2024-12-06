import sys

testCase = int(sys.stdin.readline().strip())

for case in range(testCase):
    m, n, x, y = map(int, sys.stdin.readline().split())

    maxYear = m * n

    xAvail = set()
    yAvail = set()

    while (x <= maxYear):
        xAvail.add(x)

        x += m

    while (y <= maxYear):
        yAvail.add(y)

        y += n

    year = -1

    for xx in xAvail:
        if (xx in yAvail):
            year = xx
            break

    print(year)
