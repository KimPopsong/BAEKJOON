def A():
    print('PLAYER A')

def B():
    print('PLAYER B')

def DRAW():
    print('DRAW')

aA, aH = map(int, input().split())
bA, bH = map(int, input().split())

while aH > 0 and bH > 0:
    bH -= aA
    aH -= bA

    if aH <= 0 and bH <= 0:
        DRAW()

    elif aH <= 0:
        B()

    elif bH <= 0:
        A()
