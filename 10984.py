import sys

semesterNumber = int(sys.stdin.readline().rstrip())

for i in range(semesterNumber):
    gradeSum = 0
    creditSum = 0

    subjectNumber = int(sys.stdin.readline().rstrip())

    for j in range(subjectNumber):
        credit, grade = map(float, sys.stdin.readline().rsplit())

        gradeSum += credit * grade
        creditSum += credit

    print(int(creditSum), round(gradeSum / creditSum, 1))
