humanNumber = int(input())

human = []
rankList = [0] * (humanNumber + 1)

for i in range(humanNumber):
    temp = list(map(int, input().split()))
    temp.append(i)
    human.append(temp)

for i in range(humanNumber):
    rank = 1

    weight = human[i][0]
    height = human[i][1]

    for j in range(humanNumber):
        if i == j:
            continue

        if human[j][0] > weight and human[j][1] > height:
            rank += 1

    rankList[i] += rank

for i in range(humanNumber):
    print(rankList[i], end=' ')
