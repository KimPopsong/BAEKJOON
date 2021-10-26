#include <iostream>

int main()
{
	int height, width;
	int waterBlock = 0;
	int block[500] = { 0 };

	std::cin >> height >> width;

	for (int i = 0; i < width; i++)
	{
		std::cin >> block[i];
	}

	for (int h = height; h >= 0; h--)
	{
		int tempWaterBlock = 0;
		bool metBlockFlag = false;

		for (int c = 0; c < width; c++)
		{
			if (block[c] >= h)
			{
				if (metBlockFlag)
				{
					waterBlock += tempWaterBlock;
				}

				metBlockFlag = true;
				tempWaterBlock = 0;
			}

			else
			{
				tempWaterBlock += 1;
			}
		}
	}

	std::cout << waterBlock << "\n";

	return 0;
}
