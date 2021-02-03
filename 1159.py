import sys

playerNum = int(sys.stdin.readline().rstrip())

player = []

flag = False

for i in range(playerNum):
    player.append(sys.stdin.readline().rstrip())

player.sort()

for i in range(97, 123):
    count = 0

    for p in player:
        if p[0] == chr(i):
            count += 1

    if count >= 5:
        flag = True
        print(chr(i), end = '')

if not flag:
    print('PREDAJA')
