student, endTime = map(int, input().split())

time = [False] * (endTime + 1)

for i in range(student):
    n = int(input())
    origin = n
    i = 2

    while n <= endTime:
        time[n] = True

        n = origin * i
        i += 1

print(time.count(True))
