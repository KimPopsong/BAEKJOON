n = int(input())

words = input().split()

alphabet = words[0][0]

for word in words:
    if not word[0] == word[-1] == alphabet:
        print(0)
        exit()
        
print(1)
