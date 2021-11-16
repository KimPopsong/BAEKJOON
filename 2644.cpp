#include <iostream>

int main()
{
	int peopleNumber, caseNumber;
	int family[101] = { 0 };
	int fam1, fam2;
	int fam1Count = 0, fam2Count = 0;

	bool isAncestor[101] = { false };
	int commonAncestor = 0;

	std::cin >> peopleNumber;
	std::cin >> fam1 >> fam2;
	std::cin >> caseNumber;

	for (int i = 0; i < caseNumber; i++)
	{
		int parent, child;

		std::cin >> parent >> child;

		family[child] = parent;
	}

	int nod1 = fam1;
	while (true)
	{
		isAncestor[nod1] = true;
		nod1 = family[nod1];

		if (nod1 == 0)
		{
			break;
		}
	}

	int nod2 = fam2;
	while (true)
	{
		if (isAncestor[nod2])
		{
			commonAncestor = nod2;

			break;
		}

		else
		{
			isAncestor[nod2] = true;
			nod2 = family[nod2];

			if (nod2 == 0)
			{
				break;
			}
		}		
	}

	if (commonAncestor == 0)  // When no common ancestor exists
	{
		std::cout << "-1" << std::endl;

		return 0;
	}

	else
	{
		int nod;

		nod = fam1;
		while (true)
		{
			if (nod == commonAncestor)
			{
				break;
			}

			else
			{
				nod = family[nod];

				fam1Count += 1;
			}
		}

		nod = fam2;
		while (true)
		{
			if (nod == commonAncestor)
			{
				break;
			}

			else
			{
				nod = family[nod];

				fam2Count += 1;
			}
		}
	}

	std::cout << fam1Count + fam2Count << std::endl;

	return 0;
}
