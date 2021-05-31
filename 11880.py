import sys

def calc(n1, n2, n3):
    return (n1 + n2) ** 2 + (n3 ** 2)

testCase = int(sys.stdin.readline().rstrip())

for i in range(testCase):
    a, b, c = map(int, sys.stdin.readline().rsplit())

    minimum = min(calc(a, b, c), calc(a, c, b), calc(b, a, c), calc(b, c, a), calc(c, a, b), calc(c, b, a))

    print(minimum)
