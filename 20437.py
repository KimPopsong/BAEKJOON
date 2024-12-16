import sys
from collections import deque

gameNumber = int(sys.stdin.readline().rstrip())

for game in range(gameNumber):
    strings = deque(sys.stdin.readline().rstrip())
    wordInclue = int(sys.stdin.readline().rstrip())

    if (wordInclue == 1):
        print(1, 1)

        continue

    game3 = sys.maxsize
    game4 = 0

    for s in range(97, 123):  # a부터 z까지 찾기
        word = chr(s)  # 찾는 문자

        find = 0  # game3
        copyString = deque(strings)

        while (copyString):  # word가 나올때까지 앞에 문자 제거
            t = copyString.popleft()

            if (t == word):
                copyString.appendleft(t)
                break

        tempString = deque()

        while (copyString):
            t = copyString.popleft()

            tempString.append(t)

            if (t == word):
                find += 1

                if (find == wordInclue):  # 원하는 개수가 같다면
                    game3 = min(game3, len(tempString))

                    tempString.popleft()
                    while (tempString):  # word가 나올때까지 다시 제거
                        tt = tempString.popleft()

                        if (tt == word):
                            tempString.appendleft(tt)
                            break

                    find -= 1

        find = 0  # game4
        copyString = deque(strings)

        while (copyString):  # word가 나올때까지 앞에 문자 제거
            t = copyString.popleft()

            if (t == word):
                copyString.appendleft(t)
                break

        tempString = deque()

        while (copyString):
            t = copyString.popleft()

            tempString.append(t)

            if (t == word):
                find += 1

                if (find == wordInclue):  # 원하는 개수가 같다면
                    game4 = max(game4, len(tempString))

                    tempString.popleft()
                    while (tempString):  # word가 나올때까지 다시 제거
                        tt = tempString.popleft()

                        if (tt == word):
                            tempString.appendleft(tt)
                            break

                    find -= 1

    if (game3 != sys.maxsize and game4 != 0):
        print(game3, game4)

    else:
        print(-1)
