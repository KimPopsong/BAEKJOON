#include <iostream>

int main()
{
	std::string number;

	std::cin >> number;

	for (int i = 0; i < number.length() / 2; i++)
	{
		std::cout << number[i];
	}

	std::cout << ' ';

	for (int i = number.length() / 2; i < number.length(); i++)
	{
		std::cout << number[i];
	}

	std::cout << std::endl;

	return 0;
}
