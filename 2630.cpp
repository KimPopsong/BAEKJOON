#include <iostream>

int paper[129][129];
int whitePaper, bluePaper;

void Cut(int startRow, int startCol, int endRow, int endCol)
{
	bool flag = true;

	for (int i = startRow; i < endRow; i++)
	{
		for (int j = startCol; j < endCol; j++)
		{
			if (paper[startRow][startCol] != paper[i][j])
			{
				flag = false;

				break;
			}
		}

		if (!flag)
		{
			break;
		}
	}

	if (flag)
	{
		if (paper[startRow][startCol])
		{
			bluePaper += 1;
		}

		else
		{
			whitePaper += 1;
		}

		return;
	}

	else
	{
		Cut(startRow, (startCol + endCol) / 2, (startRow + endRow) / 2, endCol);  // Quadrant 1
		Cut(startRow, startCol, (startRow + endRow) / 2, (startCol + endCol) / 2);  // Quadrant 2
		Cut((startRow + endRow) / 2, startCol, endRow, (startCol + endCol) / 2);  // Quadrant 3
		Cut((startRow + endRow) / 2, (startCol + endCol) / 2, endRow, endCol);  // Quadrant 4
	}
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int side;

	std::cin >> side;

	for (int i = 0; i < side; i++)
	{
		for (int j = 0; j < side; j++)
		{
			std::cin >> paper[i][j];
		}
	}

	Cut(0, 0, side, side);

	std::cout << whitePaper << "\n" << bluePaper;

	return 0;
}
