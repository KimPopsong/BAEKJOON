testCase = int(input())

for i in range(testCase):
    t = int(input())

    s1, s2, s3 = 0, 0, 0

    for j in range(t + 1):
        s1 += j

    s2 = t * t
    s3 = t * (t + 1)

    print(s1, s2, s3)
