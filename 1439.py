def Check():
    t = s[0]

    for i in range(1, len(s)):
        if s[i] != t:
            return False

    return True

def Reverse(l, r):
    for i in range(l, r + 1):
        if s[i] == 0:
            s[i] = 1

        else:
            s[i] = 0

def Find(n):
    global leftNode, rightNode

    for i in range(0, len(s)):
        if s[i] == n:
            leftNode = i
            break

    for i in range(len(s) - 1, -1, -1):
        if s[i] == n:
            rightNode = i
            break

s = input()
s = [int(i) for i in s]

leftNode = 0
rightNode = len(s) - 1
count = 0

while True:
    if Check():
        break

    if s[leftNode] == 0:
        Find(1)
        Reverse(leftNode, rightNode)
        count += 1

    else:
        Find(0)
        Reverse(leftNode, rightNode)
        count += 1

print(count)
