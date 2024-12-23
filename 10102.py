import sys

voteNumber = int(sys.stdin.readline().rstrip())

vote = list(sys.stdin.readline().rstrip())

if (vote.count("A") > vote.count("B")):
    print("A")

elif (vote.count("A") < vote.count("B")):
    print("B")

else:
    print("Tie")
