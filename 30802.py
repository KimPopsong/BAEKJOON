import sys

participants = int(sys.stdin.readline().rstrip())  # 참가자의 수
shirts = list(map(int, sys.stdin.readline().split()))  # 셔츠 사이즈별 필요 개수
shirtsBundle, penBundle = map(int, sys.stdin.readline().split())  # 셔츠와 펜의 묶음 개수

needShirtsBundle = 0
needPenBundle = 0
needPenSingle = 0

for s in shirts:
    needShirtsBundle += (s - 1) // shirtsBundle + 1

needPenBundle = participants // penBundle
needPenSingle = participants % penBundle

sys.stdout.write(str(needShirtsBundle) + "\n")  # 필요한 셔츠의 묶음 출력
sys.stdout.write(str(needPenBundle) + " " + str(needPenSingle))
