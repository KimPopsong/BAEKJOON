###############################
#Eratosthenes
import math

eratosthenes = []
maximum = int(input())

for i in range(0, maximum + 1):
    if i % 2 == 0:
        eratosthenes.append(False)

    else:
        eratosthenes.append(True)

eratosthenes[0] = False
eratosthenes[1] = False
eratosthenes[2] = True

i = 1
while True:
    i += 1

    if i % 2 == 0:
        continue

    if i > math.sqrt(maximum) + 1:
        break

    k = 2
    while i * k <= maximum:
        eratosthenes[k * i] = False
        k += 1

print(eratosthenes)

###############################
#Sorted List
list1 = [[1, 2], [3, 4], [5, 6]]

sorted_list = sorted(list1, key=lambda x: x[0], reverse=True)

print(sorted_list)

###############################
#Stdin
import sys

a = sys.stdin.readline()
x, y = sys.stdin.readline().rsplit()
l = list(map(int, sys.stdin.readline().rsplit()))
c = int(sys.stdin.readline().rstrip())  # rstrip not rsplit

###############################
#Heap Queue
import heapq

list = []
data = int(input())

heapq.heappush(list, data)
n = heapq.heappop(list)

###############################
#EOF
import sys

for line in sys.stdin:

###############################
#존재 유무 확인
list1 = [[1, 1], [2, 2], [3, 3]]
list2 = [1, 2, 3, 4, 5]

if list2.count(list1[0][0]) == 0:

if list1[0][0] not in list2:
# 아래 방법이 위 방법보다 빠름

###############################
# 문자열 리스트로 입력 받기
import sys

board = [list(sys.stdin.readline().rstrip()) for _ in range(5)]
