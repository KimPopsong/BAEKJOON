import sys

startTime, endTime, exitTime = sys.stdin.readline().split(" ")

students = dict()
attendance = 0

for line in sys.stdin:  # EOF
    time, student = line.split(" ")

    if (time <= startTime):
        students[student] = True

    elif (endTime <= time <= exitTime):
        if student in students:
            students.pop(student)
            attendance += 1

print(attendance)
