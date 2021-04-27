while True:
    sentence = input()

    if sentence == '#':
        break

    alphabet = [0] * 26

    for i in range(len(sentence)):
        if 97 <= ord(sentence[i]) <= 122:
            alphabet[ord(sentence[i]) - 97] += 1

        elif 65 <= ord(sentence[i]) <= 90:
            alphabet[ord(sentence[i]) - 65] += 1

        else:
            continue

    print(26 - alphabet.count(0))
