for _ in range(int(input())):
    bin1 = input()
    bin2 = input()

    hammingDistance = 0

    for i in range(len(bin1)):
        if bin1[i] != bin2[i]:
            hammingDistance += 1

    print('Hamming distance is %d.' % hammingDistance)
