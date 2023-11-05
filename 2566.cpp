#include <iostream>

int main()
{
	int count = 0, maxCount = 0, maxNum = -1;

	for (int i = 0; i < 81; i++)
	{
		int temp;

		std::cin >> temp;
		count++;

		if (temp > maxNum)
		{
			maxNum = temp;
			maxCount = count;
		}
	}

	std::cout << maxNum << std::endl;
	std::cout << ((maxCount % 9 == 0) ? (maxCount / 9) : (maxCount / 9) + 1) << " " << ((maxCount % 9 == 0) ? 9 : (maxCount % 9)) << std::endl;

	return 0;
}
