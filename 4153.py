def IsTriangle(tri):
    if tri[0] * tri[0] + tri[1] * tri[1] == tri[2] * tri[2]:
        return True

    else:
        return False

numbers = []

while True:
    temp = input().split()
    temp = [int(i) for i in temp]

    if temp[0] == 0 and temp[1] == 0 and temp[2] == 0:
        break

    else:
        temp.sort()
        numbers.append(temp)

for num in numbers:
    if IsTriangle(num):
        print('right')

    else:
        print('wrong')
