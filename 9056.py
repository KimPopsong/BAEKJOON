testCase = int(input())

for i in range(testCase):
    flag = True
    count = 0

    word, sentence = input().split()

    for j in range(len(word)):
        if sentence.count(word[j]) == 0:
            flag = False
            break

        else:
            count += sentence.count(word[j])

    if len(sentence) != count:
        flag = False

    if flag:
        print('YES')

    else:
        print('NO')
