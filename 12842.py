import sys

breadNum, breadLeft = map(int, sys.stdin.readline().rsplit())

peopleNum = int(sys.stdin.readline().rstrip())
people = []

for i in range(peopleNum):
    people.append(int(sys.stdin.readline().rstrip()))

breadEat = breadNum - breadLeft
breadCount = 0

time = 0

while True:
    for i in range(peopleNum):
        if time % people[i] == 0:
            breadCount += 1

            if breadCount == breadEat:
                print(i + 1)
                exit()

    time += 1
