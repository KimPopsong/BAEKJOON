import sys, copy

global number, seqLength, numbers, isMade, sequences, isVisit


def recursion(depth, sequence):
    if (depth == seqLength):
        if (tuple(sequence) not in isMade):  # 없다면
            sequences.append(copy.deepcopy(sequence))
            isMade.add(tuple(sequence))

        return

    for i in range(number):
        if (isVisit[i] == False):
            sequence.append(numbers[i])
            isVisit[i] = True

            recursion(depth + 1, sequence)

            isVisit[i] = False
            sequence.pop()


number, seqLength = map(int, sys.stdin.readline().split())

numbers = sorted(list(map(int, sys.stdin.readline().rsplit())))  # 오름차순 정렬

isMade = set()  # 수열이 이미 있는지 중복 확인
sequences = list()  # 수열을 저장하여 순서대로 출력

for i in range(number):
    isVisit = [False for _ in range(number)]  # 방문여부 확인
    sequence = []  # 수열을 저장

    isVisit[i] = True
    sequence.append(numbers[i])

    recursion(1, sequence)

for sequence in sequences:
    for seq in sequence:
        print(seq, end=" ")
    print()
