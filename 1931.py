def Choice(conf : list, start : int):
    for i in range(0, len(conf)):
        if conf[i][1] >= start and conf[i][0] >= start:
            return conf[i][1], i

    return -1, -1

conferenceNumber = int(input())

conference = []

for i in range(conferenceNumber):
    temp = list(map(int, input().split()))
    conference.append(temp)

conference.sort()
conference = sorted(conference, key = lambda x : x[1])

end = 0
count = 0

while True:
    end, index = Choice(conference, end)

    if end == -1:
        break

    else:
        count += 1
        conference.pop(index)

print(count)
