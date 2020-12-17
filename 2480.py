dice = list(map(int, input().split()))

dice.sort()

if dice[0] == dice[2]:  # When all numbers are same
    print(10000 + dice[0] * 1000)

elif dice[0] == dice[1]:  # When two numbers are same#
    print(1000 + dice[1] * 100)

elif dice[1] == dice[2]:  # When two numbers are same
    print(1000 + dice[1] * 100)

else:  # When all numbers are different
    print(dice[2] * 100)
