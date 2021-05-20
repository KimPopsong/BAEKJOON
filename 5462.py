import sys

attendanceNumber, problemNumber, philipsId = map(int, input().split())

attendance = []
attendanceScore = []
problemScore = [0] * problemNumber

philipsScore = 0
philipsProblemSolved = 0
philipsRank = 1

for i in range(attendanceNumber):
    temp = list(map(int, sys.stdin.readline().rsplit()))

    for j in range(problemNumber):
        if temp[j] == 0:
            problemScore[j] += 1

    attendance.append(temp)

# Calc Attendances' Score
for i in range(attendanceNumber):
    score = 0
    for j in range(problemNumber):
        score += attendance[i][j] * problemScore[j]

    attendanceScore.append(score)

philipsProblemSolved = sum(attendance[philipsId - 1])  # How many problem Philip solve
philipsScore = attendanceScore[philipsId - 1]

for i in range(attendanceNumber):
    if i == philipsId - 1:
        continue

    if philipsScore < attendanceScore[i]:
        philipsRank += 1

    elif philipsScore == attendanceScore[i]:
        if philipsProblemSolved < sum(attendance[i]):
            philipsRank += 1

        elif philipsProblemSolved == sum(attendance[i]):
            if i < philipsId - 1:
                philipsRank += 1

print(philipsScore, philipsRank)
