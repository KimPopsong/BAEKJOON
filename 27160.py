import sys

number = int(sys.stdin.readline().strip())

fruits = {"STRAWBERRY": 0, "BANANA": 0, "LIME": 0, "PLUM": 0}

for i in range(number):
    fruit, num = sys.stdin.readline().split()

    fruits[fruit] += int(num)

for fruit in fruits:
    if (fruits[fruit] == 5):
        print("YES")
        exit()

print("NO")
