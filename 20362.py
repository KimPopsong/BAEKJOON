import sys

submitP, correctP = sys.stdin.readline().rsplit()

submitP = int(submitP)

people = []
count = 0
ans = ''

for i in range(submitP):
    temp = sys.stdin.readline().rsplit()

    if temp[0] == correctP:
        ans = temp[1]
        break

    people.append(temp)

for p in people:
    if p[1] == ans:
        count += 1

print(count)
