#include <iostream>

int main()
{
	int paperNumber;
	int area = 0;
	bool coordinateSystem[100][100] = { false };

	std::cin >> paperNumber;

	for (int i = 0; i < paperNumber; i++)
	{
		int x, y;

		std::cin >> x >> y;

		for (int row = y; row < y + 10; row++)
		{
			for (int col = x; col < x + 10; col++)
			{
				coordinateSystem[row][col] = true;
			}
		}
	}

	for (int row = 0; row < 100; row++)
	{
		for (int col = 0; col < 100; col++)
		{
			if (coordinateSystem[row][col])
			{
				area += 1;
			}
		}
	}

	std::cout << area << std::endl;

	return 0;
}
