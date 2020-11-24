stick = [64, 32, 16, 8, 4, 2, 1]

need = int(input())

node = 0
count = 0

while True:
    if node > 6:
        break

    if stick[node] > need:
        node += 1

    else:
        need -= stick[node]
        count += 1

print(count)
