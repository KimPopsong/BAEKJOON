n1, n2, n3 = map(int, input().split())

flag = False  # Check odd

cocktail = 1

if n1 % 2 != 0:
    flag = True
    cocktail *= n1

if n2 % 2 != 0:
    flag = True
    cocktail *= n2

if n3 % 2 != 0:
    flag = True
    cocktail *= n3

if not flag:
    cocktail = n1 * n2 * n3

print(cocktail)
