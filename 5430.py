import sys
from collections import deque


def printAnswer(lst):
    print("[", end="")

    for i in range(len(lst)):
        print(lst[i], end="")

        if (i == len(lst) - 1):
            break

        else:
            print(",", end="")

    print("]")


testCase = int(sys.stdin.readline().rstrip())

for case in range(testCase):
    func = sys.stdin.readline().rstrip()

    listLength = int(sys.stdin.readline().rstrip())

    if (listLength == 0):
        tempLst = sys.stdin.readline().rstrip()
        lst = deque()

    else:
        tempLst = sys.stdin.readline().rstrip()
        tempLst = tempLst[1:len(tempLst) - 1]  # 양 끝 대괄호 제거
        lst = deque(map(int, tempLst.split(",")))

    reverseFlag = False  # True일시 뒤집기 상태
    errorFlag = False

    for command in func:
        if (command == "R"):  # 뒤집기
            if (reverseFlag):
                reverseFlag = False

            else:
                reverseFlag = True

        else:  # 지우기
            if (len(lst) == 0):  # 배열이 비었다면
                errorFlag = True

                break

            elif (reverseFlag):  # 뒤집기 상태일시 뒤에 있는 숫자 제거
                lst.pop()

            else:  # 뒤집기가 아닐시 앞 숫자 제거
                lst.popleft()

    if (errorFlag):
        print("error")

        continue

    elif (reverseFlag):
        lst.reverse()

    printAnswer(lst)
