# I refer to the blog

def Print():  # Print number in sequence
    global sequence

    for n in sequence:
        print(n, end = ' ')
    print()

def Backtracking():  # I'm not sure if this is backtracking
    global sequence

    for i in range(1, maxNumber + 1):
        if len(sequence) == sequenceLength:
            Print()
            return

        if i not in sequence:
            sequence.append(i)
            Backtracking()
            sequence.pop()

maxNumber, sequenceLength = map(int, input().split())

sequence = []

Backtracking()
