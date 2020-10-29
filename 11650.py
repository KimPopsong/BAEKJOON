n = int(input())

location = []

for i in range(n):
    temp = input()
    temp = temp.split(' ')

    temp[0] = int(temp[0])
    temp[1] = int(temp[1])

    location.append(temp)

location.sort()

for i in range(n):
    print('%d %d' %(location[i][0], location[i][1]))
