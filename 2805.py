import sys

treeNum, treeNeed = map(int, sys.stdin.readline().rsplit())

tree = list(map(int, sys.stdin.readline().rsplit()))

tree.sort(reverse=True)

left = tree[0]
right = 0
answer = 0

while left >= right:
    sumTree = 0
    height = (left + right) // 2

    for t in tree:
        if t <= height:
            break

        sumTree += (t - height)

    if sumTree < treeNeed:
        left = height - 1

    else:
        answer = max(answer, height)
        right = height + 1

print(answer)
