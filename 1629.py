base, exponent, divNum = map(int, input().split())

def power(b, e, d):
    if e == 1:
        return b % divNum

    else:
        temp = power(b, e // 2, d)

        if e % 2 == 0:
            return temp * temp % divNum

        else:
            return temp * temp * b % divNum

print(power(base, exponent, divNum))
