import math

diagonal, height, width = map(int, input().split())

x = math.sqrt((diagonal ** 2) / (height ** 2 + width ** 2))

print(math.floor(height * x), math.floor(width * x))
