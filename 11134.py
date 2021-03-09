import math

testCase = int(input())

for i in range(testCase):
    cookie, eat = map(int, input().split())

    print(math.ceil(cookie / eat))
