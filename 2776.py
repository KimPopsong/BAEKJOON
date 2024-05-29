import sys

testCase = int(sys.stdin.readline().strip())

for t in range(testCase):
    question = dict()

    questionNumber = int(sys.stdin.readline().strip())
    questions = list(map(int, sys.stdin.readline().split()))

    for q in questions:
        question[q] = True

    answerNumber = int(sys.stdin.readline().strip())
    answers = list(map(int, sys.stdin.readline().split()))

    for a in answers:
        if question.get(a):
            print(1)

        else:
            print(0)
