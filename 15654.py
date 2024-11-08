from itertools import permutations
import sys

number, comb = map(int, sys.stdin.readline().split())

numbers = sorted(list(map(int, sys.stdin.readline().rsplit())))

answer = []

for num in permutations(numbers, comb):
    answer.append(num)

for ans in answer:
    for a in ans:
        print(a, end=" ")
    print()
