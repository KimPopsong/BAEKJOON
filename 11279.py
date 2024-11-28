import sys, heapq

commandNumber = int(sys.stdin.readline().rstrip())

commands = []
for _ in range(commandNumber):
    commands.append(int(sys.stdin.readline().rstrip()))

hq = []

for command in commands:
    if (command == 0):  # 가장 큰 값을 출력하곡 제거
        if (len(hq) == 0):  # 값이 없을 경우 0 출력
            print(0)

        else:
            num = -1 * heapq.heappop(hq)

            print(num)

    else:  # 배열에 값 추가
        heapq.heappush(hq, -1 * command)  # 최대 힙이므로 -1을 곱하기
