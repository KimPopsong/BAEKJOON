def count_chocolates(k, a, b):
    return (b // k) - ((a - 1) // k)

# 입력 받기
k, a, b = map(int, input().split())

# 결과 출력
print(count_chocolates(k, a, b))
