testcase = int(input())

case = []
answer = []

for i in range(testcase):
    t = input().split()
    case.append(int(t[1]) - int(t[0]))

for n in case:
    count = 0

    left = 0
    right = n
    move = 1

    while True:
        if left >= right:
            break

        else:
            left += move
            count += 1

        if left >= right:
            break

        else:
            right -= move
            count += 1

        move += 1

    answer.append(count)

for n in answer:
    print(n)
