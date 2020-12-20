import sys

sunshine, water = map(int, sys.stdin.readline().rsplit())

if sunshine > water:

    sunshineDecrease = water // 10

    sunshine += sunshineDecrease

    print(sunshine + water)

else:
    waterDecrease = sunshine // 10

    water += waterDecrease

    print(sunshine + water)
