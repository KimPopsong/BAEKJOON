import math

def Segment(x1, y1, x2, y2):
    return math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)

aX, aY, bX, bY, cX, cY = map(int, input().split())

abc = Segment(aX, aY, bX, bY) + Segment(bX, bY, cX, cY)
bca = Segment(bX, bY, cX, cY) + Segment(cX, cY, aX, aY)
cab = Segment(cX, cY, aX, aY) + Segment(aX, aY, bX, bY)

if (aY - bY) * (bX - cX) == (bY - cY) * (aX - bX):
    print(-1.0)

else:
    print(2 * (max(abc, bca, cab) - min(abc, bca, cab)))
