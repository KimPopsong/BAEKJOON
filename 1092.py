import bisect

def Check():
    for box in boxes:
        if box != 0:
            return False

    return True

craneNumber = int(input())
cranes = list(map(int, input().split()))
boxNumber = int(input())
boxes = list(map(int, input().split()))

node = [0 for i in range(craneNumber)]
count = 0

cranes.sort()
boxes.sort()

if boxes[-1] > cranes[-1]:
    print(-1)
    exit()

for i in range(craneNumber):
    node[i] = bisect.bisect_right(boxes, cranes[i]) - 1

for i in range(boxNumber):
    for j in range(craneNumber):
        if node[j] < 0:
            continue

        if boxes[node[j]] == 0:
            while True:
                node[j] -= 1

                if node[j] < 0:
                    break

                if boxes[node[j]]:
                    break

        if node[j] < 0:
            continue

        boxes[node[j]] = 0
        node[j] -= 1

    count += 1

    if Check():
        break

print(count)
