chang = 100
sang = 100

for _ in range(int(input())):
    changDice, sangDice = map(int, input().split())

    if changDice > sangDice:
        sang -= changDice

    elif changDice < sangDice:
        chang -= sangDice

print(chang)
print(sang)
