n = int(input())

strLen = 0

for i in range(1, n + 1):
    strLen += len(str(i))

print(strLen)
