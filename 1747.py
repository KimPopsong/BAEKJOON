def IsPalindrome(i):
    strI = str(i)

    for k in range(len(strI) // 2):
        if strI[k] != strI[len(strI) - k - 1]:
            return False

    return True

n = int(input())

if n >= 100000:
    print(1003001)
    exit()

eratosthenes = []
max = 100000

for i in range(0, max + 1):
    eratosthenes.append(int(i))

eratosthenes[1] = 0

i = 1
while True:
    i += 1

    if i == max // 2 + 1:
        break

    k = 2
    while i * k <= max:
        eratosthenes[k * i] = 0
        k += 1

for i in range(n, max):
    if eratosthenes[i] != 0:
        if IsPalindrome(i):
           print(i)
           exit()
