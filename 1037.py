number = int(input())
divisors = list(map(int, input().split()))

divisors.sort()

print(divisors[-1] * divisors[0])
