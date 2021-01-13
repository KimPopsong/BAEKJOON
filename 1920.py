import sys

n = int(input())

number = list(map(int, sys.stdin.readline().rsplit()))
number.sort()

check = int(input())

numCheck = list(map(int, sys.stdin.readline().rsplit()))

for i in range(check):
    num = numCheck[i]
    flag = 0

    left = 0
    right = n - 1

    while left <= right:
        mid = (left + right) // 2

        if number[mid] > num:
            right = mid - 1

        elif number[mid] < num:
            left = mid + 1

        else:
            flag = 1
            break

    print(flag)
