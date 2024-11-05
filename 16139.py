import sys

string = sys.stdin.readline().rstrip()

questionNum = int(sys.stdin.readline().rstrip())

preSum = dict()  # { 알파벳 : 누적 합 리스트 }

for _ in range(questionNum):
    question = sys.stdin.readline().rsplit()

    alphabet = question[0]  # 찾으려는 알파벳
    left = int(question[1])  # 왼쪽 노드
    right = int(question[2])  # 오른쪽 노드

    if (alphabet not in preSum):  # 기존에 검색했던 기록이 없다면
        tempList = [0]
        tempSum = 0

        for i in range(len(string)):
            if (string[i] == alphabet):
                tempSum += 1

            tempList.append(tempSum)

        preSum[alphabet] = tempList

    findResult = preSum[alphabet][right + 1] - preSum[alphabet][left]

    sys.stdout.write(str(findResult) + '\n')
