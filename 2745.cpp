#include <iostream>
#include <cmath>

int main()
{
	int base, decimal = 0;
	std::string number;

	std::cin >> number >> base;

	for (int i = number.length() - 1; i >= 0; i--)
	{
		int temp;

		if (number[i] >= 65)
		{
			temp = number[i] - 55;
		}

		else
		{
			temp = number[i] - 48;
		}

		decimal += temp * std::pow(base, number.length() - i - 1);
	}

	std::cout << decimal << std::endl;

	return 0;
}
