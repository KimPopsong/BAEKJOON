import math

n, m, cctv = map(int, input().split())

print(math.ceil(n / cctv) * math.ceil(m / cctv))
