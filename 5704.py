while(True):
    pangram = input()

    if pangram == '*':  # * 입력시 탈출
        break

    alphabet = [False] * 26  # 알파벳 list 생성

    for i in range(len(pangram)):
        if pangram[i] == ' ':  # 띄어쓰기
            continue

        alphabet[ord(pangram[i]) - 97] = True  # 알파벳에 해당하는 index를 True로 변환

    if alphabet.count(False):  # False가 있다면 사용하지 않은 알파벳이 존재하므로
        print('N')  # N 출력

    else:
        print('Y')
