#include <iostream>

#define DATATYPE int

DATATYPE paper[2200][2200];
DATATYPE minusPaper, zeroPaper, plusPaper;

bool isSameNumber(DATATYPE startI, DATATYPE startJ, DATATYPE size)
{
	DATATYPE number = paper[startI][startJ];

	for (DATATYPE i = startI; i < startI + size; i++)
	{
		for (DATATYPE j = startJ; j < startJ + size; j++)
		{
			if (paper[i][j] != number)
			{
				return false;
			}
		}
	}

	if (number == -1)
	{
		minusPaper += 1;
	}

	else if (number == 0)
	{
		zeroPaper += 1;
	}

	else
	{
		plusPaper += 1;
	}

	return true;
}

void Check(DATATYPE startI, DATATYPE startJ, DATATYPE size)
{
	if (isSameNumber(startI, startJ, size))
	{
		return;
	}

	else
	{
		for (DATATYPE i = startI; i < startI + size; i += size / 3)
		{
			for (DATATYPE j = startJ; j < startJ + size; j += size / 3)
			{
				Check(i, j, size / 3);
			}
		}
	}
}

DATATYPE main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	DATATYPE size;

	std::cin >> size;

	for (DATATYPE i = 0; i < size; i++)
	{
		for (DATATYPE j = 0; j < size; j++)
		{
			std::cin >> paper[i][j];
		}
	}

	Check(0, 0, size);

	std::cout << minusPaper << "\n" << zeroPaper << "\n" << plusPaper << "\n";

	return 0;
}
