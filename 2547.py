import sys

testCase = int(sys.stdin.readline().rstrip())

for i in range(testCase):
    sys.stdin.readline()
    candy = 0
    studentNumber = int(sys.stdin.readline().rstrip())

    for k in range(studentNumber):
        candy += int(sys.stdin.readline().rstrip())

    if candy % studentNumber == 0:
        print('YES')

    else:
        print('NO')
