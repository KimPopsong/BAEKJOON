color1 = input()
color2 = input()
color3 = input()

sum = 0

if color1 == 'black':
    sum += 0

elif color1 == 'brown':
    sum += 10

elif color1 == 'red':
    sum += 20

elif color1 == 'orange':
    sum += 30

elif color1 == 'yellow':
    sum += 40

elif color1 == 'green':
    sum += 50

elif color1 == 'blue':
    sum += 60

elif color1 == 'violet':
    sum += 70

elif color1 == 'grey':
    sum += 80

else:
    sum += 90

if color2 == 'black':
    sum += 0

elif color2 == 'brown':
    sum += 1

elif color2 == 'red':
    sum += 2

elif color2 == 'orange':
    sum += 3

elif color2 == 'yellow':
    sum += 4

elif color2 == 'green':
    sum += 5

elif color2 == 'blue':
    sum += 6

elif color2 == 'violet':
    sum += 7

elif color2 == 'grey':
    sum += 8

else:
    sum += 9

if color3 == 'black':
    sum *= 1

elif color3 == 'brown':
    sum *= 10

elif color3 == 'red':
    sum *= 100

elif color3 == 'orange':
    sum *= 1000

elif color3 == 'yellow':
    sum *= 10000

elif color3 == 'green':
    sum *= 100000

elif color3 == 'blue':
    sum *= 1000000

elif color3 == 'violet':
    sum *= 10000000

elif color3 == 'grey':
    sum *= 100000000

else:
    sum *= 1000000000

print(sum)
