import sys, math

while (True):
    slideA = int(sys.stdin.readline().rstrip())

    if (slideA == 0):
        break

    count = 0
    
    divSqrtA1 = []  # A의 제곱의 약수. 작은 부분
    divSqrtA2 = []  # A의 제곱의 약수. 큰 부분

    sqrtA = slideA ** 2  # A의 제곱
    for i in range(1, slideA):
        if (sqrtA % i == 0):  # A의 제곱의 약수라면
            divSqrtA1.append(i)
            divSqrtA2.append(sqrtA // i)

    while (len(divSqrtA1)):
        num1 = divSqrtA1.pop()
        num2 = divSqrtA2.pop()

        # A^2 + B^2 == C^2이므로, A^2 == (B+C)(B-C).
        slideB = (num2 - num1) // 2  # B는 큰 약수에서 작은 약수를 뺀 후 나누기 2
        slideC = (num1 + num2) // 2  # C는 약수 두 개를 더한 후 나누기 2

        if (slideB > slideA):  # B가 더 길고
            if (sqrtA + slideB ** 2 == slideC ** 2):  # 모든 변이 정수라면
                count += 1

    print(count)
