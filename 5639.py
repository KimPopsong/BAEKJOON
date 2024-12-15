import sys
from collections import deque

sys.setrecursionlimit(10 ** 5)
global numbers, graph


def preTopost(numbers):
    # 전위 순회에서 맨 앞의 값은 노드
    # 노드를 기준으로 좌우 분리 가능
    # 좌 우 분리된 값을 기준으로 후위순회로 출력

    leftNode = deque()

    root = numbers.popleft()

    if (len(numbers) == 0):
        print(root)

        return

    while (numbers):
        t = numbers.popleft()

        if (t > root):
            numbers.appendleft(t)

            break

        else:
            leftNode.append(t)
    rightNode = deque(numbers)
    numbers.clear()

    if (len(leftNode)):
        preTopost(leftNode)

    if (len(rightNode)):
        preTopost(rightNode)

    print(root)


def postOrder(index):  # left - right - root
    if (index * 2 + 1 in graph.keys()):  # 왼쪽 자식이 있다면
        postOrder(index * 2 + 1)

    if (index * 2 + 2 in graph.keys()):  # 오른쪽 자식이 있다면
        postOrder(index * 2 + 2)

    print(graph[index])


numbers = deque()

while (True):  # 숫자 입력
    try:
        n = int(sys.stdin.readline().strip())

        numbers.append(n)

    except:
        break

preTopost(numbers)
