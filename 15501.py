import sys

def PrintBad():
    print('bad puzzle')

def PrintGood():
    print('good puzzle')

n = int(sys.stdin.readline().rstrip())

s1 = list(map(int, sys.stdin.readline().rsplit()))
s2 = list(map(int, sys.stdin.readline().rsplit()))

if n == 1:
    if s1 == s2:
        PrintGood()
        exit()

temp = s2.index(s1[0])

if s2[temp - 1] == s1[1]:
    s2.reverse()

nodS1 = 0
nodS2 = s2.index(s1[0])

while nodS1 < n:
    if not(s1[nodS1] == s2[nodS2]):
        PrintBad()
        exit()

    nodS1 += 1
    nodS2 += 1

    if nodS2 >= n:
        nodS2 = 0

PrintGood()
