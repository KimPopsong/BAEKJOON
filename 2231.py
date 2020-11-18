n = int(input())

for i in range(1, n):
    temp = i
    strInt = str(i)

    for j in range(len(strInt)):
        temp += int(strInt[j])

    if temp == n:
        print(strInt)
        exit()
        
print(0)
