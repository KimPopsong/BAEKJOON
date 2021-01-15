n = int(input())
alphabet = [i for i in range(27)]
sumHash = 0

string = input()

for i in range(n):
    sumHash += (alphabet[ord(string[i]) - 96]) * (31 ** i)

print(sumHash % 1234567891)
