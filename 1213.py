isPalindrome = input()

alphabet = [0] * 26

for i in range(len(isPalindrome)):
    alphabet[ord(isPalindrome[i]) - 65] += 1

flag = False
for i in range(26):  # Check if two or more alphabets are odd
    if alphabet[i] % 2 == 1:
        if flag:
            print('I\'m Sorry Hansoo')
            exit()

        else:
            flag = True

answer = ''

nod = 0
midAlphabet = ''

while nod <= 25:
    if alphabet[nod] >= 2:
        answer += chr(nod + 65)
        alphabet[nod] -= 2

    elif alphabet[nod] == 1:
        midAlphabet = chr(nod + 65)
        alphabet[nod] -= 1

    else:
        nod += 1

print(answer + midAlphabet + answer[::-1])
