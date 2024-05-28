import sys

height = 0

dishes = sys.stdin.readline();

for i in range(len(dishes) - 1):
    if (dishes[i] != dishes[i + 1]):
       height += 10

    else:
        height += 5

print(height)
