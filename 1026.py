n = int(input())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
B.sort(reverse = True)

sumNum = 0

for i in range(n):
    sumNum += A[i] * B[i]

print(sumNum)
