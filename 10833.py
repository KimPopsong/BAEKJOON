number = int(input())

left = 0

for i in range(number):
    student, apple = map(int, input().split())

    left += apple % student

print(left)
