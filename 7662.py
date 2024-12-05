import sys, heapq

testCase = int(sys.stdin.readline().rstrip())

for case in range(testCase):
    inputNumber = int(sys.stdin.readline().rstrip())

    maxHeap = []
    minHeap = []
    heapNumber = 0

    eraseMaxDict = dict()  # 최대 힙에서 삭제된 숫자와 개수
    eraseMinDict = dict()  # 최소 힙에서 삭제된 숫자와 개수

    for inputData in range(inputNumber):
        command, number = sys.stdin.readline().rsplit()  # I는 데이터 입력, D -1은 최솟값을 D 1은 최댓값을 삭제

        number = int(number)

        if (command == "I"):  # 숫자 추가
            heapNumber += 1

            heapq.heappush(maxHeap, (-number, number))
            heapq.heappush(minHeap, number)

        else:  # 숫자 제거
            if (heapNumber <= 0):  # 저장된 숫자가 없을시 무시
                continue

            elif (number == -1):  # 최솟값 삭제
                while (True):
                    number = heapq.heappop(minHeap)

                    if (number in eraseMaxDict.keys()):
                        eraseMaxDict[number] -= 1

                        if (eraseMaxDict[number] <= 0):
                            del eraseMaxDict[number]

                        continue

                    if (number in eraseMinDict.keys()):
                        eraseMinDict[number] += 1

                    else:
                        eraseMinDict[number] = 1

                    break

            else:  # 최댓값 삭제
                while (True):
                    number = heapq.heappop(maxHeap)[1]

                    if (number in eraseMinDict.keys()):
                        eraseMinDict[number] -= 1

                        if (eraseMinDict[number] <= 0):
                            del eraseMinDict[number]

                        continue

                    if (number in eraseMaxDict.keys()):
                        eraseMaxDict[number] += 1

                    else:
                        eraseMaxDict[number] = 1

                    break

            heapNumber -= 1

    if (heapNumber <= 0):  # 남아있는 값이 없다면
        print("EMPTY")

    else:
        maxNumber, minNumber = 0, 0

        while (True):
            number = heapq.heappop(maxHeap)[1]

            if (number in eraseMinDict.keys()):
                eraseMinDict[number] -= 1

                if (eraseMinDict[number] <= 0):
                    del eraseMinDict[number]

            else:
                maxNumber = number

                break

        while (True):
            number = heapq.heappop(minHeap)

            if (number in eraseMaxDict.keys()):
                eraseMaxDict[number] -= 1

                if (eraseMaxDict[number] <= 0):
                    del eraseMaxDict[number]

            else:
                minNumber = number

                break

        print(maxNumber, minNumber)
