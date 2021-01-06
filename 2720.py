testCase = int(input())

for i in range(testCase):
    change = int(input())

    quarter = change // 25

    change -= quarter * 25

    dime = change // 10

    change -= dime * 10

    nickel = change // 5

    change -= nickel * 5

    print(quarter, dime, nickel, change)
