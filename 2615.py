import sys

global size, omok


def checkWidth(r, c):  # 가로 확인
    team = omok[r][c]

    if (size < c + 5):  # 범위를 벗어나면 5개가 안되므로
        return False

    for cc in range(c, c + 5):
        if (omok[r][cc] != team):
            return False

    if (c + 5 < size):  # 육목 확인
        if (omok[r][c + 5] == team):
            return False

    if (0 <= c - 1):  # 육목 확인
        if (omok[r][c - 1] == team):
            return False

    return True


def checkLength(r, c):  # 세로 확인
    team = omok[r][c]

    if (size < r + 5):  # 범위를 벗어나면 5개가 안되므로
        return False

    for rr in range(r, r + 5):
        if (omok[rr][c] != team):
            return False

    if (r + 5 < size):  # 육목 확인
        if (omok[r + 5][c] == team):
            return False

    if (0 <= r - 1):  # 육목 확인
        if (omok[r - 1][c] == team):
            return False

    return True


def check5Diagonal(r, c):  # 오른쪽 아래 대각선 확인
    team = omok[r][c]

    if (size < r + 5 or size < c + 5):  # 범위를 벗어나면 5개가 안되므로
        return False

    for n in range(5):
        if (omok[r + n][c + n] != team):
            return False

    if (r + 5 < size and c + 5 < size):  # 육목 확인
        if (omok[r + 5][c + 5] == team):
            return False

    if (0 <= r - 1 and 0 <= c - 1):  # 육목 확인
        if (omok[r - 1][c - 1] == team):
            return False

    return True


def check1Diagonal(r, c):  # 오른쪽 위 대각선 확인
    team = omok[r][c]

    if (r - 4 < 0 or size < c + 5):  # 범위를 벗어나면 5개가 안되므로
        return False

    for n in range(5):
        if (omok[r - n][c + n] != team):
            return False

    if (0 <= r - 5 and c + 5 < size):  # 육목 확인
        if (omok[r - 5][c + 5] == team):
            return False

    if (r + 1 < size and 0 <= c - 1):  # 육목 확인
        if (omok[r + 1][c - 1] == team):
            return False

    return True


def check():
    for r in range(size):
        for c in range(size):
            if (omok[r][c] != 0):  # 바둑알이 놓여있을 경우
                if (checkWidth(r, c) or checkLength(r, c) or check5Diagonal(r, c) or check1Diagonal(r, c)):  # 이겼다면
                    print(omok[r][c])
                    print(r + 1, c + 1)

                    exit()


size = 19  # 가로 세로 길이
omok = []  # 오목판. 0 : 빈 칸, 1 : 검정 돌, 2: 흰 돌

for i in range(size):
    omok.append(list(map(int, sys.stdin.readline().rsplit())))

check()

print(0)  # 승부가 결정되지 않았을 경우
