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
