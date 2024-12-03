import sys

testCase = int(sys.stdin.readline().rstrip())

for case in range(testCase):
    slime = int(sys.stdin.readline().rstrip())

    cumulEXP = slime * (slime + 1) // 2  # 누적 경험치

    leftNod = 0
    rightNod = cumulEXP * 2

    while (leftNod <= rightNod):
        midNod = (leftNod + rightNod) // 2

        midExp = midNod * (midNod - 1)

        if (cumulEXP < midExp):
            rightNod = midNod - 1

        elif (midExp < cumulEXP):
            leftNod = midNod + 1

        else:
            break

    print((leftNod + rightNod) // 2)
