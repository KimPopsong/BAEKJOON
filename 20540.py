MBTI = input()

answer = ''

if MBTI[0] == 'E':
    answer += 'I'

else:
    answer += 'E'

if MBTI[1] == 'S':
    answer += 'N'

else:
    answer += 'S'

if MBTI[2] == 'T':
    answer += 'F'

else:
    answer += 'T'

if MBTI[3] == 'J':
    answer += 'P'

else:
    answer += 'J'

print(answer)
