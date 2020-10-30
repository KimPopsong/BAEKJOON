n = int(input())
test = []

zero = [1, 0]
one = [0, 1]

for i in range(n):
    test.append(int(input()))

for i in range(2, 42):
    zero.append(zero[i - 1] + zero[i - 2])
    one.append(one[i - 1] + one[i - 2])

for i in range(n):
    print(zero[test[i]], end=' ')
    print(one[test[i]])
