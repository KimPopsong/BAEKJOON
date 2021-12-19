import sys

board = []

h, w = map(int, input().split())

for i in range(h):
    board.append(list(sys.stdin.readline().rstrip()))

for i in range(h):
    for j in range(w):
        if board[i][j] != '.':
           board[i][w - j - 1] = board[i][j]

for i in range(h):
    for j in range(w):
        print(board[i][j], end='')
    print()
