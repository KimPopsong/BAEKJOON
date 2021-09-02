import math

r, c = map(int, input().split())

cards = r * c

minimum = cards // 2

maximum = cards - 1

print(minimum, maximum)
