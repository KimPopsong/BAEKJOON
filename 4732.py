scale = ['A', 'A#', 'B', 'C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', ]

while True:
    answer = []  # answer to print

    scaleMove = list(input().split())  # scales need to move

    if scaleMove == ['***']:  # end
        break

    moveCount = int(input())  # movement count

    if moveCount >= 12:
        moveCount %= 12

    elif moveCount <= -12:
        moveCount %= -12

    for i in range(len(scaleMove)):  # check note not exists in scale such as 'Bb' or 'B#'
        if not scale.count(scaleMove[i]):
            index = scale.index(scaleMove[i][0])

            if scaleMove[i][1] == '#':
                index += 1

            else:
                index -= 1

            if index >= 12:
                index -= 1

            elif index < 0:
                index += 1

            scaleMove[i] = scale[index]

    for sc in scaleMove:  # move
        indexOrigin = scale.index(sc)

        indexMove = indexOrigin + moveCount

        if indexMove >= 12:
            indexMove -= 12

        elif indexMove < 0:
            indexMove += 12

        answer.append(scale[indexMove])

    for ans in answer:
        print(ans, end = ' ')
    print()
