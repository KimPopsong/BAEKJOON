n = int(input())

string = input().strip()

answer = ''

for i in range(n):
    if string[i] == '?':
        if string[n - i - 1] != '?':
            answer += string[n - i - 1]

        else:
            answer += 'a'

    else:
        answer += string[i]

print(answer)
