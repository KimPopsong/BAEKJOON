t = input()

for i in range(0, len(t) // 2):
    if t[i] != t[len(t) - 1 - i]:
        print(0)
        exit()

print(1)
