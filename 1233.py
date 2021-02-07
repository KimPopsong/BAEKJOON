s1, s2, s3 = map(int, input().split())

countSum = [0] * 81

for i in range(1, s1 + 1):
    for j in range(1, s2 + 1):
        for k in range(1, s3 + 1):
            countSum[i + j + k] += 1

maxNum = 0
maxSum = 0
for i in range(len(countSum)):
    if countSum[i] > maxSum:
        maxSum = countSum[i]
        maxNum = i

print(maxNum)
