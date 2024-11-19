import sys, copy

stringNumber, stringLength = map(int, sys.stdin.readline().rsplit())  # 문자열의 개수, 문자열의 길이

strings = ["" for i in range(stringLength)]  # 문자열을 저장

for _ in range(stringNumber):
    str = sys.stdin.readline().rstrip()

    for i, s in enumerate(str):
        strings[i] += s

stringSets = set()  # 문자열의 중복을 확인
for str in strings:
    stringSets.add("".join(str))

answer = 0

for _ in range(stringNumber):
    tempSet = set(stringSets)
    stringSets.clear()

    for str in tempSet:
        tempStr = str[1:]

        stringSets.add(tempStr)

    if (len(stringSets) == stringLength):
        answer += 1

    else:
        break

print(answer)
