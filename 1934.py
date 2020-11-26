def LCM(n1, n2):
    divisor = 1

    if n1 > n2:
        n1, n2 = n2, n1

    for i in range(2, n1 + 1):
        if n1 % i == 0 and n2 % i == 0:
            divisor = i

    return (n1 / divisor) * n2

testcase = int(input())
case = []
answer = []

for i in range(testcase):
    temp = list(map(int, input().split()))
    answer.append(int(LCM(temp[0], temp[1])))

for ans in answer:
    print(ans)
