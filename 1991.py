import sys

global nods, preOrder, inOrder, postOrder


def order(rootNod):
    global preOrder, inOrder, postOrder

    leftNod = nods[rootNod][0]
    rightNod = nods[rootNod][1]

    preOrder += rootNod

    if (leftNod != "."):  # 왼쪽 노드가 있을 경우
        order(leftNod)

    inOrder += rootNod

    if (rightNod != "."):  # 오른쪽 노드가 있을 경우
        order(rightNod)

    postOrder += rootNod


nodNumber = int(sys.stdin.readline().rstrip())

nods = dict()
preOrder = ""  # 전위 순회
inOrder = ""  # 중위 순회
postOrder = ""  # 후위 순회

for i in range(nodNumber):
    rootNod, leftNod, rightNod = sys.stdin.readline().split()

    nods[rootNod] = [leftNod, rightNod]

order("A")

print(preOrder)
print(inOrder)
print(postOrder)
