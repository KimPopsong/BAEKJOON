import sys, copy

global size


def calcMaxCandy(board):
    maxCandy = 0

    for r in range(size):  # 가로 최대 계산
        streak = 1

        for c in range(size - 1):
            if (board[r][c] == board[r][c + 1]):
                streak += 1

            else:
                maxCandy = max(maxCandy, streak)
                streak = 1

        maxCandy = max(maxCandy, streak)

    for c in range(size):  # 세로 최대 계산
        streak = 1

        for r in range(size - 1):
            if (board[r][c] == board[r + 1][c]):
                streak += 1

            else:
                maxCandy = max(maxCandy, streak)
                streak = 1

        maxCandy = max(maxCandy, streak)

    return maxCandy


size = int(sys.stdin.readline().rstrip())

board = []  # 보드 입력

for _ in range(size):
    temp = list(sys.stdin.readline().rstrip())

    board.append(temp)

maxCandy = 0

dr = [0, 1]  # 좌우, 상하 순
dc = [1, 0]
for nod in range(2):  # 좌우, 상하 순으로 교환
    for row in range(size - dr[nod]):
        for col in range(size - dc[nod]):
            boardCopy = copy.deepcopy(board)

            boardCopy[row][col], boardCopy[row + dr[nod]][col + dc[nod]] = boardCopy[row + dr[nod]][col + dc[nod]], \
                boardCopy[row][col]  # 인접한 열 교환

            maxCandy = max(calcMaxCandy(boardCopy), maxCandy)  # 먹을 수 있는 최대 사탕 수 계산

print(maxCandy)
