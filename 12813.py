binary1 = input()
binary2 = input()

while True:  # make two binary's length equal
    if len(binary1) == len(binary2):
        break

    elif len(binary1) > len(binary2):
        binary2 = '0' + binary2

    else:
        binary1 = '0' + binary1

for i in range(len(binary1)):  # & operation
    if binary1[i] == '1' and binary2[i] == '1':
        print('1', end = '')

    else:
        print('0', end = '')
print()

for i in range(len(binary1)):  # | operation
    if binary1[i] == '1' or binary2[i] == '1':
        print('1', end = '')

    else:
        print('0', end = '')
print()

for i in range(len(binary1)):  # ^ operation
    if (binary1[i] == '1' and binary2[i] == '1') or (binary1[i] == '0' and binary2[i] == '0'):
        print('0', end = '')

    else:
        print('1', end = '')
print()

for i in range(len(binary1)):  # ~binary1 operation
    if binary1[i] == '1':
        print('0', end = '')

    else:
        print('1', end = '')
print()

for i in range(len(binary1)):  # ~binary2 operation
    if binary2[i] == '1':
        print('0', end = '')

    else:
        print('1', end = '')
print()
