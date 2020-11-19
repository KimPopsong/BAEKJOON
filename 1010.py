def Factorial(k):
    q = 1

    for j in range(2, k + 1):
        q *= j

    return q

def nCr(n, r):
    t = Factorial(n) / (Factorial(r) * Factorial(n - r))
    return t

testcase = int(input())

answer = []

for i in range(testcase):
    temp = input().split()
    answer.append(int(nCr(int(temp[1]), int(temp[0]))))

for n in answer:
    print(n)
