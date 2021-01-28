import math

k, w, m = map(int, input().split())

goal = w - k

goal /= m

print(math.ceil(goal))
