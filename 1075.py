n = int(input())
divNum = int(input())

number = 0
while True:
    if number >= (n // 100) * 100:
        break

    else:
        number += divNum

answer = ''
answer += str(number % 100)

if len(answer) == 1:
    print(0, end='')

print(answer)
