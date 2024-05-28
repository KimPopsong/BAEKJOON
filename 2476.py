import sys

game = int(sys.stdin.readline().strip())
maxMoney = 0

for i in range(game):
    money = 0

    dice = list(map(int, sys.stdin.readline().split()))

    if (dice[0] == dice[1] == dice[2]):
        money += 10000 + 1000 * dice[0]

    elif (dice[0] == dice[1]):
        money += 1000 + 100 * dice[0]

    elif (dice[0] == dice[2]):
        money += 1000 + 100 * dice[0]

    elif (dice[1] == dice[2]):
        money += 1000 + 100 * dice[1]

    else:
        money += 100 * max(dice[0], dice[1], dice[2])

    if (money > maxMoney):
        maxMoney = money

print(maxMoney)
