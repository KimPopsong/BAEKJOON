import sys
from collections import deque


def printAnswer(people, case):
    print("SET " + str(case))

    for person in people:
        print(person)


case = 1
while (True):
    peopleNumber = int(sys.stdin.readline().rstrip())

    if (peopleNumber == 0):
        break

    people = []

    for _ in range(peopleNumber):
        people.append(sys.stdin.readline().rstrip())

    output = deque()

    if (peopleNumber % 2 == 1):  # 사람이 홀수일 경우
        flag = True

    else:
        flag = False

    for person in reversed(people):
        if (flag):
            output.appendleft(person)
            flag = False

        else:
            output.append(person)
            flag = True

    printAnswer(output, case)

    case += 1
