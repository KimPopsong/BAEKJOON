import sys

n = int(sys.stdin.readline().rstrip())

tiles = [0, 1, 3]

for i in range(3, n + 1):
    tiles.append((tiles[i - 1] + 2 * tiles[i - 2]) % 10007)

print(tiles[n] % 10007)
