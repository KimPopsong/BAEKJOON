triangleNumber = int(input())

for i in range(triangleNumber):
    tri1, tri2 = map(int, input().split())

    print((tri1 // tri2) ** 2)
