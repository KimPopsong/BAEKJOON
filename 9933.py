import sys

passwordNumber = int(sys.stdin.readline().rstrip())

password = []

for i in range(passwordNumber):
    password.append(sys.stdin.readline().rstrip())

for i in range(0, passwordNumber):
    targetPass = password[i]

    for j in range(0, passwordNumber):
        if len(targetPass) != len(password[j]):  # 길이가 같지 않다면 탈출
            continue

        flag = True

        length = len(targetPass)

        for k in range(0, length):
            if targetPass[k] != password[j][length - 1 - k]:
                flag = False
                break

        if flag:
            print(length, targetPass[length // 2])
            exit()
