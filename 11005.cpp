#include <iostream>
#include <algorithm>

int main()
{
	int base, decimal = 0;
	std::string number = "";

	std::cin >> decimal >> base;

	while (decimal >= base)
	{
		int temp;

		temp = decimal % base;
		decimal /= base;

		if (temp >= 10)
		{
			number += char(temp + 55);
		}

		else
		{
			number += char(temp + 48);
		}
	}

	if (decimal >= 10)
	{
		number += char(decimal + 55);
	}

	else
	{
		number += char(decimal + 48);
	}

	std::reverse(number.begin(), number.end());

	std::cout << number << std::endl;

	return 0;
}
