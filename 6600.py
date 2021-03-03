import math, sys

def GetSide(xx1, yy1, xx2, yy2):
    side = math.sqrt((xx1 - xx2) ** 2 + (yy1 - yy2) ** 2)

    return side

def GetRadius(__area, aa, bb, cc):
    rad = (aa * bb * cc) / (4 * __area)

    return rad

def GetArea(aa, bb, cc):
    s = (aa + bb + cc) / 2

    _area = math.sqrt(s * (s - aa) * (s - bb) * (s - cc))

    return _area

def GetCircumference(rad):
    PI = 3.141592653589793

    circum = 2 * PI * rad

    return circum

for line in sys.stdin:
    x1, y1, x2, y2, x3, y3 = map(float, line.rsplit())

    a, b, c = GetSide(x1, y1, x2, y2), GetSide(x2, y2, x3, y3), GetSide(x3, y3, x1, y1)

    area = GetArea(a, b, c)

    radius = GetRadius(area, a, b, c)

    circumference = GetCircumference(radius)

    print('%0.2f' % circumference)
