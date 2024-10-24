import sys

number = 0

for i in range(3, 0, -1):
    temp = sys.stdin.readline().strip()

    if (temp == "Fizz"):
        continue

    elif (temp == "Buzz"):
        continue

    elif (temp == "FizzBuzz"):
        continue

    else:
        number = int(temp) + i
        break

if (number % 3 == 0 and number % 5 == 0):
    print("FizzBuzz")

elif (number % 3 == 0):
    print("Fizz")

elif (number % 5 == 0):
    print("Buzz")

else:
    print(number)
