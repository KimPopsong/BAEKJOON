n = int(input())

dictionary = []

for i in range(n):
    k = input()

    if k in dictionary:
        continue

    dictionary.append(k)

dictionary.sort()

dictionary = sorted(dictionary, key = lambda x : len(x))

for i in range(len(dictionary)):
    print(dictionary[i])
