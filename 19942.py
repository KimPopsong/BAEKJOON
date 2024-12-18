import sys
from itertools import combinations

foodNumber = int(sys.stdin.readline().rstrip())
minProtein, minFat, minCalbo, minVitamin = map(int, sys.stdin.readline().rsplit())  # 필요한 단백질, 지방, 탄수화물, 비타민

foods = []  # [단백질, 지방, 탄수화물, 비타민, 가격, 식품 번호]
for i in range(foodNumber):
    foods.append(list(map(int, sys.stdin.readline().rsplit())))
    foods[i].append(i + 1)

minPrice = sys.maxsize
minComb = []

for i in range(1, foodNumber + 1):
    for comb in combinations(foods, i):
        p = 0
        f = 0
        c = 0
        v = 0
        price = 0

        for com in comb:
            p += com[0]
            f += com[1]
            c += com[2]
            v += com[3]
            price += com[4]

        if (p >= minProtein and f >= minFat and c >= minCalbo and v >= minVitamin):
            if (price < minPrice):
                minPrice = price
                minComb.clear()

                tempComb = []
                for c in comb:
                    tempComb.append(c[5])
                minComb.append(tempComb)

            elif (price == minPrice):
                tempComb = []
                for c in comb:
                    tempComb.append(c[5])
                minComb.append(tempComb)

if (minPrice == sys.maxsize):
    print(-1)

else:
    minComb.sort()

    print(minPrice)

    for m in minComb[0]:
        print(m, end=" ")
