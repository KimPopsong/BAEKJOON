line1 = input()
line2 = input()
line3 = input()
line4 = input()
line5 = input()

for i in range(15):
    if len(line1) > i:
        print(line1[i], end='')

    if len(line2) > i:
        print(line2[i], end='')

    if len(line3) > i:
        print(line3[i], end='')

    if len(line4) > i:
        print(line4[i], end='')

    if len(line5) > i:
        print(line5[i], end='')
