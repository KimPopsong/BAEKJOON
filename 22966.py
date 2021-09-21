easiestP = ''
easiestLevel = 5

for i in range(int(input())):
	p, l = input().split()
	
	l = int(l)
	
	if l < easiestLevel:
		easiestLevel = l
		easiestP = p
		
print(easiestP)
