import sys

n = int(sys.stdin.readline())

number = [] #숫자 배열
sum = 0 #합계
frequency = [] #최빈값이 들어가는 배열
before = -4001
count = 0 #같은 숫자가 나온 횟수
modeCount = 0 #최빈값의 횟수

for i in range(0, n):
    k = int(sys.stdin.readline())
    number.append(k)
    sum += k

number.sort()

print('%d' %round(sum / n)) #산술평균
print('%d' %number[n // 2]) #중앙값

count = 1
before = number[0]

for i in range(1, n):
    if(before == number[i]):
        count += 1

    else:
        if(modeCount < count):
            frequency.clear()
            frequency.append(before)
            modeCount = count

        elif(modeCount == count):
            frequency.append(before)

        count = 1
        before = number[i]

if(modeCount < count):
    frequency.clear()
    frequency.append(before)

elif(modeCount == count):
    frequency.append(before)

frequency.sort()

if(len(frequency) > 1):
    print(frequency[1]) #최빈값

else:
    print(frequency[0])

print(number[-1] - number[0]) #범위
