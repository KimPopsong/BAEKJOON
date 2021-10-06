import sys  # Use sys to save time

keywordNumber, postNumber = map(int, sys.stdin.readline().rsplit())

keyword = {}  # Use dict to save time

deletedKeyword = 0  # To reduce operation

for _ in range(keywordNumber):
    keyword[input()] = ' '

for _ in range(postNumber):
    keywordInPost = list(sys.stdin.readline().replace(',', ' ').rsplit())  # Replace ',' to ' ' and rsplit to delete '\n'

    for key in keywordInPost:
        if key in keyword:  # Check if key is in keyword list
            del keyword[key]
            deletedKeyword += 1

    print(keywordNumber - deletedKeyword)
