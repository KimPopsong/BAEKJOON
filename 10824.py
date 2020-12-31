a, b, c, d = map(int, input().split())

a = a * (10 ** (len(str(b))))
c = c * (10 ** (len(str(d))))

print(a + b + c + d)
