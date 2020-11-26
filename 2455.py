firstStation = list(map(int, input().split()))
secondStation = list(map(int, input().split()))
thirdStation = list(map(int, input().split()))
lastStation = list(map(int, input().split()))

human = 0
maximum = 0

human += firstStation[1]

maximum = max(human, maximum)

human -= secondStation[0]
human += secondStation[1]

maximum = max(human, maximum)

human -= thirdStation[0]
human += thirdStation[1]

maximum = max(human, maximum)

print(maximum)
