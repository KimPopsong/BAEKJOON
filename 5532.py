import math

vacation = int(input())
languageHomework = int(input())
mathHomework = int(input())
languageDay = int(input())
mathDay = int(input())

print(vacation - max(math.ceil(languageHomework / languageDay), math.ceil(mathHomework / mathDay)))
