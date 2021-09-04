import math

a, b = map(int, input().split())

solution1 = int(math.sqrt(a ** 2 - b) - a)

solution2 = -2 * a - solution1

if solution1 == solution2:
    print(solution1)

else:
    print(min(solution1, solution2), max(solution1, solution2))
