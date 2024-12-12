import sys
from itertools import combinations
from collections import deque

peopleNumber = int(sys.stdin.readline().strip())  # 사람의 숫자
stats = []  # 능력치
minGap = sys.maxsize  # 최솟값
combs = deque()
people = set(i for i in range(peopleNumber))

for i in range(peopleNumber):
    stats.append(list(map(int, sys.stdin.readline().rsplit())))

for comb in combinations(people, peopleNumber // 2):  # 모든 조합을 구하고 저장
    combs.append(comb)

while (combs):
    comb1 = combs.popleft()
    comb2 = combs.pop()

    score1 = 0
    score2 = 0

    for comb in combinations(comb1, 2):
        score1 += stats[comb[0]][comb[1]]
        score1 += stats[comb[1]][comb[0]]

    for comb in combinations(comb2, 2):
        score2 += stats[comb[0]][comb[1]]
        score2 += stats[comb[1]][comb[0]]

    gap = score1 - score2

    if (gap < 0):
        gap *= -1

    if (minGap > gap):
        minGap = gap

print(minGap)
