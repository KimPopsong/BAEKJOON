s, k, h = map(int, input().split())

if s + k + h >= 100:
    print('OK')

elif s < k and s < h:
    print('Soongsil')

elif k < s and k < h:
    print('Korea')

else:
    print('Hanyang')
