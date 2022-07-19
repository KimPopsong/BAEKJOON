#include <iostream>

int main()
{
	while (true)
	{
		int numF, numR;

		std::cin >> numF >> numR;

		if (numF > numR)
		{
			std::cout << "Yes" << "\n";
		}

		else if (numF == 0 && numR == 0)
		{
			break;
		}

		else
		{
			std::cout << "No" << "\n";
		}
	}

	return 0;
}
