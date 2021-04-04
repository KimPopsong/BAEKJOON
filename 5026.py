n = int(input())

for i in range(n):
    temp = input()

    if temp == 'P=NP':
        print('skipped')
        continue

    else:
        temp = temp.split('+')

        print(int(temp[0]) + int(temp[1]))
