# Don't code like this...
n = int(input())

length = 0

if n <= 9:
    length += n

else:
    length += 9

    if n <= 99:
        length += (n - 9) * 2

    else:
        length += 90 * 2

        if n <= 999:
            length += (n - 99) * 3

        else:
            length += 900 * 3

            if n <= 9999:
                length += (n - 999) * 4

            else:
                length += 9000 * 4

                if n <= 99999:
                    length += (n - 9999) * 5

                else:
                    length += 90000 * 5

                    if n <= 999999:
                        length += (n - 99999) * 6

                    else:
                        length += 900000 * 6

                        if n <= 9999999:
                            length += (n - 999999) * 7

                        else:
                            length += 9000000 * 7

                            if n <= 99999999:
                                length += (n - 9999999) * 8

                            else:
                                length += 90000000 * 8

                                if n <= 999999999:
                                    length += (n - 99999999) * 9

print(length)
