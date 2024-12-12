import sys, copy

global size, isVisit, rowQueen, rPc, rMc, answer


def recursion(depth):
    global size, isVisit, rowQueen, rPc, rMc, answer

    if (depth == size):  # 모든 queen을 놓았다면
        answer += 1

        return

    for c in range(0, size):  # 각 행마다 queen을 놓기
        if (c in rowQueen):  # queen을 놓을 수 없다면
            continue

        elif (depth + c in rPc):
            continue

        elif (depth - c in rMc):
            continue

        rowQueen.add(c)  # 세로 줄 체크
        rPc.add(depth + c)
        rMc.add(depth - c)

        recursion(depth + 1)  # 재귀

        rowQueen.remove(c)  # 방문체크 해제
        rPc.remove(depth + c)
        rMc.remove(depth - c)

    return


size = int(sys.stdin.readline().rstrip())  # 크기 & queen의 개수
rowQueen = set()  # 행 검사
rPc = set()  # 대각선 검사
rMc = set()  # 대각선 검사
answer = 0  # 답의 개수

recursion(0)

print(answer)
