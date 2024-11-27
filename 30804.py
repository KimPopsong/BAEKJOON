import sys

fruitsNumber = int(sys.stdin.readline().rstrip())

fruits = list(map(int, sys.stdin.readline().rsplit()))

nodL, nodR = 0, 0  # 왼쪽, 오른쪽을 가리키는 노드
fruitDict = dict()  # 과일의 종류 확인
fruitDict[fruits[0]] = 1
maxFruit = 1  # 과일의 최대 개수

while (nodR < fruitsNumber):
    if (len(fruitDict.keys()) <= 2):  # 과일이 2종류 이하라면
        nodR += 1  # 우측으로 1칸 이동

        if (nodR >= fruitsNumber):  # 범위 초과시 탈출
            break

        if (fruits[nodR] in fruitDict.keys()):  # 이미 있다면
            fruitDict[fruits[nodR]] += 1

        else:
            fruitDict[fruits[nodR]] = 1

    if (len(fruitDict.keys()) >= 3):  # 과일이 3종류 이상이라면
        fruitDict[fruits[nodL]] -= 1

        if (fruitDict[fruits[nodL]] <= 0):
            fruitDict.pop(fruits[nodL])

        nodL += 1

    maxFruit = max(maxFruit, nodR - nodL + 1)

print(maxFruit)
