import sys, re

n = int(sys.stdin.readline().rstrip())

stringLength = int(sys.stdin.readline().rstrip())

str = sys.stdin.readline().rstrip()

pn = "I" + ("OI" * n)  # IOI... 문자열 만들기

answer = 0

nn = 2 * n + 1
nod = 0
j = 0
while (nod <= stringLength - nn):
    flag = True

    while (j < nn):  # 글자 비교
        if (str[nod + j] != pn[j]):  # 패턴 불일치시
            flag = False

            if (j % 2 == 0):
                nod += j + 1

            else:
                nod += j

            j = 0
            break

        else:
            j += 1

    if (flag):  # 패턴 일치시
        answer += 1

        nod += 2
        j -= 2

print(answer)
