def Calc(lst, ans):
    temp = 0

    for i in range(n - 1):
        temp += abs(lst[i] - lst[i + 1])

    if temp > ans:
        ans = temp

    return ans

def SortList(stList, originList, flag):
    while len(originList) != 0:
        if flag:
            stList.append(originList[-1])
            originList.pop(len(originList) - 1)

        else:
            stList.append(originList[0])
            originList.pop(0)

        flag = not flag

    return stList

n = int(input())

numbers = list(map(int, input().split()))
numbers.sort()

temp = sorted(numbers)
sortedList1 = []
sortedList2 = []

answer = 0

if n % 2 == 0:
    sortedList1.append(temp[n // 2 - 1])
    temp.pop(n // 2 - 1)

else:
    sortedList1.append(temp[n // 2])
    temp.pop(n // 2)

answer = Calc(SortList(sortedList1, temp, True), answer)

sortedList2 = SortList(sortedList2, numbers, False)
sortedList2.insert(0, sortedList2.pop(-1))

answer = Calc(sortedList2, answer)
print(answer)
