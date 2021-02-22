X = int(input())
YStandard = int(input())
YMax = int(input())
Y = int(input())

waterUse = int(input())

XWater = X * waterUse
YWater = YStandard

if waterUse > YMax:
    YWater += Y * (waterUse - YMax)

print(min(XWater, YWater))
