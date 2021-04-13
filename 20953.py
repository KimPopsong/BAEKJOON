import sys

testCase = int(sys.stdin.readline().rstrip())

numbers = [0] * (777 * 2 + 1)
numbers[1] = 1

for i in range(2, len(numbers)):
    numbers[i] = numbers[i - 1] + i

for case in range(testCase):
    number = sum(map(int, sys.stdin.readline().rsplit()))

    print(numbers[number - 1] * number)
