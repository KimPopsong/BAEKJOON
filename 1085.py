n = input().split()

x = int(n[0])
y = int(n[1])
w = int(n[2])
h = int(n[3])

minimum = min(x, y, w - x, h - y)
print(minimum)
