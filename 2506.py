problemNumber = int(input())

problem = list(map(int, input().split()))

score = 0
strike = 1

for p in problem:
    if p == 1:
        score += strike
        strike += 1

    else:
        strike = 1

print(score)
