import sys

girlGroupNumber, quizNumber = map(int, sys.stdin.readline().split())

dictNameGroup = dict()
dictGroupName = dict()

for _ in range(girlGroupNumber):
    group = []

    groupName = sys.stdin.readline().strip()
    memberNum = int(sys.stdin.readline().strip())

    for n in range(memberNum):
        name = sys.stdin.readline().strip()

        dictNameGroup[name] = groupName
        group.append(name)

    group = sorted(group)
    dictGroupName[groupName] = group

for _ in range(quizNumber):
    quiz = sys.stdin.readline().strip()
    quizType = int(sys.stdin.readline().strip())

    if (quizType == 1):  # 해당 멤버가 속한 팀의 이름 출력
        print(dictNameGroup[quiz])

    else:  # 해당 팀에 속한 멤버의 이름을 사전순으로 출력
        group = dictGroupName[quiz]

        for g in group:
            print(g)
