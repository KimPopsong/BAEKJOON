sLen = int(input())
s = list(map(int, input().split()))
n = int(input())
s.sort()

rightNode = 1000
leftNode = 0
count = 0

if s.count(n) != 0:
    print(0)
    exit()

for i in range(sLen):
    if s[i] > n:
        rightNode = s[i] - 1

        if i != 0:
            leftNode = s[i - 1] + 1

        else:
            leftNode = 1

        break

for i in range(leftNode, n):
    count += rightNode - n + 1

count += rightNode - n

print(count)
