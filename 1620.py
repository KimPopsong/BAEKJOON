import sys

pokemonNumber, examNum = map(int, sys.stdin.readline().rsplit())

pokemonEncyclopedia = []
exam = []
answer = []

for i in range(pokemonNumber):
    temp = sys.stdin.readline().rstrip()
    pokemonEncyclopedia.append(temp)

for i in range(examNum):
    temp = sys.stdin.readline().rstrip()
    exam.append(temp)

for i in range(examNum):
    if 65 <= ord(exam[i][0]) <= 90:
        answer.append(pokemonEncyclopedia.index(exam[i]) + 1)

    else:
        answer.append(pokemonEncyclopedia[int(exam[i]) - 1])

for ans in answer:
    print(ans)
