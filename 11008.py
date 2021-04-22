testCase = int(input())

for i in range(testCase):
    word, copied = input().split()

    while True:
        if word.find(copied) != -1:
            word = word.replace(copied, '-')

        else:
            break

    print(len(word))
