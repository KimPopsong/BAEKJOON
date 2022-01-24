#include <iostream>

int paper[2200][2200];
int minusPaper, zeroPaper, plusPaper;

bool isSameNumber(int startI, int startJ, int size)
{
	int number = paper[startI][startJ];

	for (int i = startI; i < startI + size; i++)
	{
		for (int j = startJ; j < startJ + size; j++)
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

void Check(int startI, int startJ, int size)
{
	if (isSameNumber(startI, startJ, size))
	{
		return;
	}

	else
	{
		for (int i = startI; i < startI + size; i += size / 3)
		{
			for (int j = startJ; j < startJ + size; j += size / 3)
			{
				Check(i, j, size / 3);
			}
		}
	}
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int size;

	std::cin >> size;

	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size; j++)
		{
			std::cin >> paper[i][j];
		}
	}

	Check(0, 0, size);

	std::cout << minusPaper << "\n" << zeroPaper << "\n" << plusPaper << "\n";

	return 0;
}
