testCase = int(input())

for i in range(testCase):
    score = list(map(int, input().split()))

    scoreSum = 0

    scoreSum += int(9.23076 * ((26.7 - score[0]) ** 1.835))
    scoreSum += int(1.84523 * ((score[1] - 75) ** 1.348))
    scoreSum += int(56.0211 * ((score[2] - 1.5) ** 1.05))
    scoreSum += int(4.99087 * ((42.5 - score[3]) ** 1.81))
    scoreSum += int(0.188807 * ((score[4] - 210) ** 1.41))
    scoreSum += int(15.9803 * ((score[5] - 3.8) ** 1.04))
    scoreSum += int(0.11193 * ((254 - score[6]) ** 1.88))

    print(scoreSum)
