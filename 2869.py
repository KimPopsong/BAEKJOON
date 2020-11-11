import math

s = input().split()

up = int(s[0])
down = int(s[1])
top = int(s[2])

top -= up

if top <= 0:
    top = 0

gap = up - down

top /= gap
top = math.ceil(top)
top += 1

print(top)
