import sys
from collections import deque

leftQueue = deque(sys.stdin.readline().rstrip())
rightQueue = deque()

commandNumber = int(sys.stdin.readline().rstrip())

for i in range(commandNumber):
    command = list(sys.stdin.readline().rsplit())

    if (command[0] == "L"):  # 커서를 왼쪽으로 한 칸 옮김
        if (len(leftQueue) <= 0):  # 커서가 가장 왼쪽이라면
            continue  # 무시

        else:
            rightQueue.appendleft(leftQueue.pop())  # 커서 한 칸 왼쪽으로 이동


    elif (command[0] == "D"):  # 커서를 오른쪽으로 한 칸 옮김
        if (len(rightQueue) <= 0):  # 커서가 가장 오른쪽이면
            continue  # 무시

        else:
            leftQueue.append(rightQueue.popleft())

    elif (command[0] == "B"):  # 커서 왼쪽에 있는 문자를 삭제. 커서가 가리키는 index의 문자를 삭제
        if (len(leftQueue) <= 0):  # 커서가 가장 왼쪽이라면
            continue  # 무시

        else:
            leftQueue.pop()

    else:  # 문자를 커서 왼쪽에 추가.
        leftQueue.append(command[1])

while (leftQueue):  # 답안 출력
    print(leftQueue.popleft(), end="")

while (rightQueue):
    print(rightQueue.popleft(), end="")
