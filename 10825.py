number = int(input())
student = []

for i in range(number):
    temp = input()
    temp = temp.split(' ')

    for j in range(1, 4):
        temp[j] = int(temp[j])  # change str to int

    student.append(temp)  # make two-dimension list

student = sorted(student, key = lambda x : x[0])  # sort NAME first
student = sorted(student, key = lambda x : x[3], reverse=True)  # sort MATH second
student = sorted(student, key = lambda x : x[2])  # sort ENGLISH third
student = sorted(student, key = lambda x : x[1], reverse=True)  # sort KOREAN last

for i in range(number):
    print(student[i][0])
