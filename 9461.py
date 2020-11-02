n = int(input())
number = []
tri = [1,1,1]

for i in range(n):
    number.append(int(input()))

for i in range(3, 101):
    tri.append(tri[i - 2] + tri[i - 3])

for i in range(n):
    print(tri[number[i] - 1])
