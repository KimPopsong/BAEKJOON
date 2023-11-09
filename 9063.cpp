#include <iostream>

int main()
{
	int count;
	int minX = 10001, minY = 10001;
	int maxX = -10001, maxY = -10001;

	std::cin >> count;

	for (int i = 0; i < count; i++)
	{
		int tempX, tempY;

		std::cin >> tempX >> tempY;

		if (tempX < minX)
		{
			minX = tempX;
		}

		if (tempX > maxX)
		{
			maxX = tempX;
		}

		if (tempY < minY)
		{
			minY = tempY;
		}

		if (tempY > maxY)
		{
			maxY = tempY;
		}
	}

	std::cout << (maxX - minX) * (maxY - minY) << std::endl;

	return 0;
}
