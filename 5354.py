def boxTop(n):
    for i in range(n):
        print('#', end = '')
    print()

def boxMid(n):
    print('#', end = '')

    for i in range(n - 2):
        print('J', end = '')

    print('#')

def boxBot(n):
    for i in range(n):
        print('#', end = '')
    print()

for _ in range(int(input())):
    boxSize = int(input())
    
    if boxSize == 0:
        continue

    if boxSize == 1:
        boxTop(1)
        print()
        continue

    boxTop(boxSize)

    for _ in range(boxSize - 2):
        boxMid(boxSize)

    boxBot(boxSize)
    print()
