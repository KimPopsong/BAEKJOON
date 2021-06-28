import sys

gameNumber, member = map(int, sys.stdin.readline().rsplit())

gameCost = []
vote = [0] * gameNumber

for i in range(gameNumber):
    gameCost.append(int(sys.stdin.readline().rstrip()))

for i in range(member):
    judgement = int(sys.stdin.readline().rstrip())

    for j in range(gameNumber):
        if judgement >= gameCost[j]:
            vote[j] += 1
            break

print(vote.index(max(vote)) + 1)
