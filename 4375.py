import sys

for n in sys.stdin:
    number = int(n)

    nod = '1'

    while True:
        if int(nod) % number == 0:
            print(len(nod))
            break

        else:
            nod += '1'
