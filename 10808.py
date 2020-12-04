alpha = [0 for i in range(27)]

s = input()

for i in range(len(s)):
    alpha[ord(s[i]) - 97] += 1

for i in range(26):
    print(alpha[i], end=' ')
