kingHave, queenHave, rookHave, bishopHave, knightHave, pawnHave = map(int, input().split())

print(1 - kingHave, 1 - queenHave, 2 - rookHave, 2 - bishopHave, 2 - knightHave, 8 - pawnHave)
