import sys

peopleNumber, classNumber = map(int, sys.stdin.readline().rsplit())  # 사람의 수, 요구하는 반의 수

people_set = set(map(int, sys.stdin.readline().rsplit()))  # 중복 제거
people = list(people_set)  # 중복 제거 후 리스트 변환

sumPrice = 0  # 비용의 합

diff = []  # 차이 값을 저장할 list

if len(people) <= classNumber:  # 중복제거 후, 요구하는 반의 개수보다 사람이 적다면, 0 출력 후 종료
    print(0)
    exit()

for i in range(len(people) - 1):  # 차이값
    diff.append(people[i + 1] - people[i])
    
diff.sort()

for i in range(peopleNumber - classNumber):
    sumPrice += diff[i]

print(sumPrice)
