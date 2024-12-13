import sys
from collections import deque, defaultdict

peopleNumber, partyNumber = map(int, sys.stdin.readline().rsplit())  # 파티에 참석하는 사람의 수, 파티의 수

knowTruth = list(map(int, sys.stdin.readline().rsplit()))  # [진실을 아는 사람의 수, 사람의 번호]
party = []  # [인원 수, 사람의 번호]
meet = dict((i, set()) for i in range(1, peopleNumber + 1))  # 파티에서 만나는 사람 목록 {번호 : set(만나는 사람)}
answer = 0

for i in range(partyNumber):
    p = list(map(int, sys.stdin.readline().rsplit()))
    party.append(p)  # party 입력

    for j in range(1, p[0] + 1):  # meet 입력. meet의 key
        for k in range(1, p[0] + 1):  # meet의 value
            meet[p[j]].add(p[k])

bfs = deque()
isKnow = [False for i in range(peopleNumber + 1)]  # 진실을 아는 사람

for i in range(1, len(knowTruth)):
    bfs.append(knowTruth[i])
    isKnow[knowTruth[i]] = True

while (bfs):  # 진실을 아는 사람 갱신
    person = bfs.popleft()

    for p in meet[person]:
        if (isKnow[p] == False):
            bfs.append(p)
            isKnow[p] = True

for p in party:
    if (isKnow[p[1]] == False):
        answer += 1

print(answer)
