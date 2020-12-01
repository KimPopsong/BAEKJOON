n = int(input())
alphabet = [0 for i in range(27)]

for i in range(n):
    t = input()

    for j in range(len(t)):
        alphabet[ord(t[j]) - ord('A')] += 10 ** (len(t) - 1 - j)

alphabet.sort(reverse=True)

start = 9
sumMax = 0

for n in alphabet:
    sumMax += n * start
    start -= 1

    if start == 0:
        break

print(sumMax)
