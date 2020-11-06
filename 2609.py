n = input().split()

n2 = int(n[1])
n1 = int(n[0])

if n1 > n2:
    n1, n2 = n2, n1

GCD = 1

for i in range(1, n1 + 1):
    if n1 % i == 0 and n2 % i == 0:
        GCD = i

    else:
        continue

LCM = (n1 / GCD) * (n2 / GCD) * GCD

print(GCD)
print(int(LCM))
