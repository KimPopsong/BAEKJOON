n = input()

name = input()

nameScore = 0

for i in range(len(name)):
    nameScore += ord(name[i]) - 64

print(nameScore)
