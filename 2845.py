l, p = map(int, input().split())

humanSum = l * p

article = list(map(int, input().split()))

for num in article:
    print(num - humanSum, end=' ')
